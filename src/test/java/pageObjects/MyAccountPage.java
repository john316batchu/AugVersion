package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement lblMyAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	//methods
	public void clickLogout() {
		btnLogout.click();
	}
	public boolean isMyAccountExist() {
		try {
		return lblMyAccount.isDisplayed();
		
		}catch(Exception e) {
			return false;
		}
	}

}
