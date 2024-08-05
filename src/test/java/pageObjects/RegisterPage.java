package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	//PageFactory
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtPasswordConfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmMsg;
	
	//Methods
	public void setFirstName(String fn) {
		txtFirstName.sendKeys(fn);
	}
	
	public void setLastName(String ln) {
		txtLastName.sendKeys(ln);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		txtPasswordConfirm.sendKeys(pwd);
	}
	
	public void selectCheckbox() {
		chkAgree.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public boolean isConfirmationMsgExist() {
		try {
		boolean flag=confirmMsg.isDisplayed();
		return flag;
		}catch(Exception e){
			return false;
			
		}
	}
	
	
	
	
}
