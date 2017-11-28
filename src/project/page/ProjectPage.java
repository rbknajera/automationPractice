package project.page;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class ProjectPage {
	
	WebDriver driver;
	
	public ProjectPage(WebDriver pDriver){
		driver = pDriver;
	}
	
	public String getRandomAlphanumeric(int count){
		return RandomStringUtils.randomAlphanumeric(count);
	}
	
	public String getRandomNumeric(int count){
		return RandomStringUtils.randomNumeric(count);
	}
	
	public String getRandomEmail(int count){
		return String.format("%s@test.com", RandomStringUtils.randomAlphanumeric(count));
	}
	
	
	
}
