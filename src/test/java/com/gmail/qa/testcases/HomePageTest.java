package com.gmail.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.LoginPage;
import com.gmail.qa.pages.SecurityPage;
import com.gmail.qa.pages.PeoplesharingPage;
import com.gmail.qa.pages.PersonalinfoPage;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    SecurityPage securityPage;
    PeoplesharingPage peoplesharingPage;
    PersonalinfoPage personalinfoPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        securityPage = new SecurityPage();
        peoplesharingPage = new PeoplesharingPage();
        personalinfoPage = new PersonalinfoPage();
        loginPage.username.sendKeys(prop.getProperty("username"));
        loginPage.nextButton.click();
        loginPage.password.sendKeys(prop.getProperty("password"));
        loginPage.loginButton.click();
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Sign in - Google Accounts");
    }

    @Test(priority = 2)
    public void verifyWelcomeLabelTest() {
        Assert.assertTrue(homePage.verifyWelcomeLabel());
    }

    @Test(priority = 3)
    public void verifySecurityLinkTest() {
        securityPage = homePage.clickOnSecurityLink();
        // Add assertions or further actions related to the security page
    }

    @Test(priority = 4)
    public void verifyPeoplesharingLinkTest() {
        peoplesharingPage = homePage.clickOnPeoplesharingLink();
        // Add assertions or further actions related to the PeopleSharingPage
    }

    @Test(priority = 5)
    public void verifyPersonalinfoPageLinkTest() {
        personalinfoPage = homePage.clickonPersonalinfoLink();
        // Add assertions or further actions related to the PersonalInfoPage
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
