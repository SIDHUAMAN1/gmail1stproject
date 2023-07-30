package com.gmail.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.qa.base.TestBase;

public class SecurityPage extends TestBase {
    @FindBy(xpath = "//h1[contains(text(),'Security')]")
    WebElement securityLabel;

    public SecurityPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifySecurityLabel() {
        return securityLabel.isDisplayed();
    }
}
