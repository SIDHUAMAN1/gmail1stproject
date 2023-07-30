package com.gmail.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.qa.base.TestBase;

public class HomePage extends TestBase  {

	@FindBy(xpath = "//h1[contains(text(),'Welcome, selenium test')]")
	WebElement WelcomeLabel;

	@FindBy(linkText = "Security")
    WebElement securityLink;

	@FindBy(linkText = "People & sharing")
    WebElement PeoplesharingLink;


	@FindBy(linkText = "Personal info")
    WebElement PersonalinfoLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle(){
			return driver.getTitle();
		}

	public boolean verifyWelcomeLabel(){
		return WelcomeLabel.isDisplayed();
	}
	
	
	public SecurityPage clickOnSecurityLink(){
		securityLink.click();
		return new SecurityPage();
	}

	public PeoplesharingPage clickOnPeoplesharingLink(){
		PeoplesharingLink.click();
		return new PeoplesharingPage();
	}

	public PersonalinfoPage clickonPersonalinfoLink(){
		PersonalinfoLink.click();
		return new PersonalinfoPage();
	}












}
