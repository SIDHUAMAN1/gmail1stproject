package com.gmail.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.qa.base.TestBase;

public class LoginPage extends TestBase {

    @FindBy(id="identifierId")
	
    public WebElement username;
    
    @FindBy(xpath="//span[contains(text(),'Next')]")
    public WebElement nextButton;
    
    @FindBy(name="Passwd")
	public WebElement password;
    
    @FindBy(xpath="//span[text()='Next']")
    public WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    
    public HomePage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }
}
