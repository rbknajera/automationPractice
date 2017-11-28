package project.test;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import project.page.LoginPage;
import project.page.MenuPage;
import project.page.MyAccountPage;
import project.page.SignUpPage;

public class SignUpTest {
	WebDriver driver;
	SignUpPage objSignUpPage;
	MenuPage objMenuPage;
	MyAccountPage objMyAccountPage;
	LoginPage objLoginPage;

	@DataProvider(name = "signUpMethodDataProvider")
	public Object[][] signUpDP() {
		return new Object[][] {
				{ "", "Najera", "123456", "rbknajera@gmail.com", "rebe123456", "rebe123456",
						"The First name field is required." },
				{ "Rebecca", "", "123456", "rbknajera@gmail.com", "rebe123456", "rebe123456",
						"The Last Name field is required." },
				{ "Rebecca", "Najera", "123456", "", "rebe123456", "rebe123456", "The Email field is required." },
				{ "Rebecca", "Najera", "123456", "rbknajera@gmail.com", "", "", "The Password field is required." },
				{ "Rebecca", "Najera", "123456", "rbknajera@gmail.com", "rebe123456", "rebe456789",
						"Password not matching with confirm password." } };
	}

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://phptravels.net");
		// Maximize the window to be able to see the 'Sign Up' button
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objMenuPage = PageFactory.initElements(driver, MenuPage.class);
	}

	@Test(dataProvider = "signUpMethodDataProvider")
	public void signUpErrorMessagesMethod(String nameData, String lastNameData, String phoneData, String emailData,
			String passData, String confPassData, String messageData) {
		objSignUpPage = objMenuPage.goToSignUpPage();
		objSignUpPage.signUpUser(nameData, lastNameData, phoneData, emailData, passData, confPassData).clickSignUp();
		assertTrue("Client must fill all spaces to complete the sign up",
				objSignUpPage.isErrorMessagePresent(messageData));

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 60); //This line is
		 * made to wait until the error message is displayed.
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//div[contains(@class,'alert alert-danger')]"))); //This
		 * assertion compares the Error Message displayed with the Error Message
		 * expected saved in the Data Provider.
		 */

	}

	@Test
	public void signUpCorrectlyMethod() {
		objSignUpPage = objMenuPage.goToSignUpPage();
		String password = objSignUpPage.getRandomAlphanumeric(9);
		objSignUpPage.signUpUser(objSignUpPage.getRandomAlphanumeric(8), objSignUpPage.getRandomAlphanumeric(8),
				objSignUpPage.getRandomNumeric(8), objSignUpPage.getRandomEmail(7), password, password);
		objMyAccountPage = objSignUpPage.clickSignUp();
		assertTrue("Sign Up Process failed.", objMyAccountPage.isHeaderPresent());
	}
	
	@Test(priority = 0)
	public void LoginCorrectlyMethod(){
		objLoginPage = objMenuPage.goToLoginPage();
		objLoginPage.loginUser("r@r.com", "123456");
		objMyAccountPage = objLoginPage.clickLoginButton();
		assertTrue("Login Process failed.", objMyAccountPage.isHeaderPresent());
	}

	@AfterMethod
	public void closeAll() {
		driver.close();
	}

}
