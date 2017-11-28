package project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends ProjectPage {

	@FindBy(partialLinkText = "My Account")
	WebElement myAccountLink;

	@FindBy(partialLinkText = "Sign Up")
	WebElement signUpLink;

	@FindBy(partialLinkText = "Login")
	WebElement loginLink;

	@FindBy(partialLinkText = "Home")
	WebElement homeLink;

	public MenuPage(WebDriver pDriver) {
		super(pDriver);
	}

	public SignUpPage goToSignUpPage() {
		myAccountLink.click();
		signUpLink.click();
		return PageFactory.initElements(driver, SignUpPage.class);
	}

	public LoginPage goToLoginPage() {
		myAccountLink.click();
		loginLink.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public HomePage goToHomePage() {
		homeLink.click();
		return PageFactory.initElements(driver, HomePage.class);
	}

}
