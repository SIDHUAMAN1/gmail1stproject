package com.gmail.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.LoginPage;
import com.gmail.qa.pages.SecurityPage;

public class SecurityPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    SecurityPage securityPage;
    
    public SecurityPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        securityPage = new SecurityPage();
        loginPage.username.sendKeys(prop.getProperty("username"));
        loginPage.nextButton.click();
        loginPage.password.sendKeys(prop.getProperty("password"));
        loginPage.loginButton.click();
        homePage = new HomePage();
        homePage.clickOnSecurityLink();
    }

    @Test
    public void verifySecurityPageTitleTest() {
        boolean SecurityLabelDisplayed = securityPage.verifySecurityLabel();
        Assert.assertTrue(SecurityLabelDisplayed, "Security");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
