package project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends ProjectPage {
	
	@FindBy(className = "RTL")
	WebElement headerText;
	
	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	
	public String getHeaderMessage() {
		return headerText.getText();
	}
	
	public boolean isHeaderPresent(){
		return getHeaderMessage().contains("Hi, ");
	}
	
	

}
