package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass {

	@Test(groups={"regression","master"})
	public void accountRegistration() {
			logger.info("*****Starting TC001_RegistrationTest*****");
			logger.debug("This is a debug log");
		try {
			HomePage hp = new HomePage(driver);
			MyAccountPage myacc=new MyAccountPage(driver);
			hp.clickMyAccount();
			logger.info("Clicked On MyAccount Link");
			hp.clickRegister();
			logger.info("Clicked on Register Link");
			RegisterPage rp = new RegisterPage(driver);
			logger.info("Entering details into User Registration form");
			rp.setFirstName(generateString());
			rp.setLastName(generateString());
			rp.setEmail(generateString()+"@gmail.com");
			rp.setTelephone(generateNumber());
			String pwd=generateAlphaNumeric();
			rp.setPassword(pwd);
			rp.setConfirmPassword(pwd);
			rp.selectCheckbox();
			logger.info("Clicking on Continue Button");
			rp.clickContinue();
			logger.info("Validating User Registration Confirmation Message");
			boolean status = rp.isConfirmationMsgExist();
			if (status == true) {
				logger.info("Confirmation message exist...Validation passed");
				logger.info("testcase passed");
				myacc.clickLogout();
				Assert.assertTrue(true);
			} else {
				logger.info("Confirmation Message not found...validation failed");
				logger.error("testcase failed");
				Assert.fail("Confirmation Message not found...validation failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("testcase failed");
			Assert.fail();
		}
		logger.info("***TC001_RegistrationTest finished***");
	}

}
