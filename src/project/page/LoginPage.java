package project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ProjectPage {

	@FindBy(name = "username")
	WebElement userNameText;

	@FindBy(name = "password")
	WebElement passwordText;

	@FindBy(id = "remember-me")
	WebElement rememberMeCheckbox;

	@FindBy(css = ".btn.btn-action.btn-block.loginbtn")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage setUserName(String userName) {
		userNameText.sendKeys(userName);
		return this;
	}

	public LoginPage setPassword(String password) {
		passwordText.sendKeys(password);
		return this;
	}

	public LoginPage clickRememberMe() {
		rememberMeCheckbox.click();
		return this;
	}

	public MyAccountPage clickLoginButton() {
		loginButton.click();
		return PageFactory.initElements(driver, MyAccountPage.class);
	}

	public LoginPage loginUser(String userName, String password) {
		this.setUserName(userName).setPassword(password);
		return this;
	}

}
