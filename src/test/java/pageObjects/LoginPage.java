package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement lblMyAccount;
	
	//methods
	
	public void setEmailAddress(String email) {
		txtEmailAddress.sendKeys(email);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	
	public boolean isMyAccountExist() {
		try {
		return lblMyAccount.isDisplayed();
		
		}catch(Exception e) {
			return false;
		}
	}
}
