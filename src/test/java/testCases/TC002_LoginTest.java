package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void verifyLogin() {
		logger.info("***Starting TC002_LoginTest***");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.clickLogin();
			logger.info("Clicked on Login link");
			LoginPage lp=new LoginPage(driver);
			logger.info("Entering Login details");
			lp.setEmailAddress(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();
			logger.info("Validating user login");
			boolean flag=lp.isMyAccountExist();
			if(flag==true) {
				logger.info("User Login validation successful");
				logger.info("Testcase passed");
				Assert.assertTrue(true);
			}else {
				logger.info("User login validation failed");
				logger.error("Testcase failed");
				Assert.fail("User login Validation failed");
			}
		}catch(Exception e) {
			logger.error("test failed",e);
			Assert.fail();
		}
		logger.info("***finished TC002_LoginTest***" );
	}

}
