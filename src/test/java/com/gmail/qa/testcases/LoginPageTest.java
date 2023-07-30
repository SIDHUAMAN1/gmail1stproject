package com.gmail.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    
    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority=1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle(); 
        Assert.assertEquals(title, "Sign in - Google Accounts"); 
    }
    @Test(priority=2)
    public void loginTest(){
        loginPage.username.sendKeys(prop.getProperty("username"));
        loginPage.nextButton.click(); // Clicking the "Next" button after entering the username
        loginPage.password.sendKeys(prop.getProperty("password")); // Entering the password
        loginPage.loginButton.click(); // Clicking the "Next" button after entering the password
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
