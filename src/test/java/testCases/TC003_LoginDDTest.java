package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDTest extends BaseClass{
	
	@Test(dataProvider="login",dataProviderClass = DataProviders.class,groups="master")
	public void dataDrivenLogin(String un,String pwd,String status) {
		
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.clickLogin();
			logger.info("Clicked on Login link");
			MyAccountPage myacc=new MyAccountPage(driver);
			LoginPage lp=new LoginPage(driver);
			logger.info("Entering Login details");
			lp.setEmailAddress(un);
			lp.setPassword(pwd);
			lp.clickLogin();
			logger.info("Validating user login");
			boolean flag=lp.isMyAccountExist();
			
			if(status.equalsIgnoreCase("valid")) {
				
				if(flag==true) {
					logger.info("User Login validation successful");
					logger.info("Testcase passed");
					myacc.clickLogout();
					Assert.assertTrue(true);	
				}else {
					logger.info("Test case failed");
					Assert.fail("user login validation failed");
				}
			}
			
			if(status.equalsIgnoreCase("invalid")) {
				
				if(flag==true) {
					logger.info("User Login validation successful on invalid data");
					logger.info("Testcase failed");
					myacc.clickLogout();
					Assert.assertTrue(false);	
				}else {
					logger.info("login validation not successful on invalid data");
					Assert.assertTrue(true);
				}
			}
					
		}catch(Exception e) {
			logger.error("test failed",e);
			Assert.fail();
		}
		logger.info("***finished TC002_LoginTest***" );
	}
}
