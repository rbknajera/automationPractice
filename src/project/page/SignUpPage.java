package project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends ProjectPage {

	@FindBy(name = "firstname")
	WebElement firstNameText;

	@FindBy(name = "lastname")
	WebElement lastNameText;

	@FindBy(name = "phone")
	WebElement phoneText;

	@FindBy(name = "email")
	WebElement emailText;

	@FindBy(name = "password")
	WebElement passwordText;

	@FindBy(name = "confirmpassword")
	WebElement confirmPasswordText;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signUpButton;

	@FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
	WebElement messageText;

	public SignUpPage(WebDriver pdriver) {
		super(pdriver);
	}

	public SignUpPage setFirstName(String pFirstName) {
		firstNameText.sendKeys(pFirstName);
		return this;
	}

	public SignUpPage setLastName(String pLastName) {
		lastNameText.sendKeys(pLastName);
		return this;
	}

	public SignUpPage setPhone(String pPhone) {
		phoneText.sendKeys(pPhone);
		return this;
	}

	public SignUpPage setEmail(String pEmail) {
		emailText.sendKeys(pEmail);
		return this;
	}

	public SignUpPage setPassword(String pPassword) {
		passwordText.sendKeys(pPassword);
		return this;
	}

	public SignUpPage setConfirmPassword(String pConfirmPass) {
		confirmPasswordText.sendKeys(pConfirmPass);
		return this;
	}

	public MyAccountPage clickSignUp() {
		signUpButton.click();
		return PageFactory.initElements(driver, MyAccountPage.class);
	}

	public String getErrorMessage() {
		return messageText.getText();
	}

	public boolean isErrorMessagePresent(String errorMessage) {
		return getErrorMessage().contains(errorMessage);
	}

	public SignUpPage signUpUser(String pFirstName, String pLastName, String pPhone, String pEmail, String pPassword,
			String pConfirmPass) {

		this.setFirstName(pFirstName).setLastName(pLastName).setPhone(pPhone).setEmail(pEmail).setPassword(pPassword)
				.setConfirmPassword(pConfirmPass);
		return this;

	}

}
