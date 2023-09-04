package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

	public WebDriver driver;

	@FindBy(id = "user_email")
	private WebElement useremail;

	@FindBy(id = "user_login")
	private WebElement username;

	@FindBy(id = "first_name")
	private WebElement firstname;

	@FindBy(id = "last_name")
	private WebElement lastname;

	@FindBy(id = "user_pass")
	private WebElement userpass;

	@FindBy(id = "user_confirm_password")
	private WebElement userconfirmpassword;

	
	public WebElement getUseremail() {
		return useremail;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getUserpass() {
		return userpass;
	}

	public WebElement getUserconfirmpassword() {
		return userconfirmpassword;
	}

	public FormPage(WebDriver dri) {

		driver = dri;
		PageFactory.initElements(driver, this);
	}
}
