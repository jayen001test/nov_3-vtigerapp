package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;
import testBase.BaseTest;
import utils.DataProviders;

public class LoginTest extends BaseTest{



	public LoginPage Lp;
	public AdminPage Ap;


	@Test
	public void tc_login() throws InterruptedException {

		logger.info("***** Start tc_login test case***********");

		Lp=new LoginPage(driver);
		Lp.enterusernameandpassword(rb.getString("username"),rb.getString("password"));
		logger.info("user name and password has been entered");
		Lp.clickonloginbtn();
		logger.info("Clicked on login button");

		Ap=new AdminPage(driver);
		Thread.sleep(5000);
		Ap.verifyAdmintitle();
		logger.info("Admin title is verified");
		logger.info("*****tc_login test case completed***********");
	}


	//@Test
	public void tc_verifysignoutfunctionality() throws InterruptedException {

		logger.info("***** Start tc_verifysignoutfunctionality test case***********");

		Lp=new LoginPage(driver);
		Lp.enterusernameandpassword(rb.getString("username"),rb.getString("password"));
		logger.info("user name and password has been entered");
		Lp.clickonloginbtn();
		logger.info("Clicked on login button");

		Ap=new AdminPage(driver);
		Thread.sleep(5000);
		Ap.verifyAdmintitle();
		logger.info("Admin title is verified");

		Ap.clickonAdministratorbtn();
		Ap.clickonSignOutbtn();
		logger.info("*****Clicked on SignOut button***********");
		Assert.assertEquals(driver.getTitle().contains(rb.getString("loginpagetitle")), true,"Title is not matching of login page");
		logger.info("*****completed tc_verifysignoutfunctionality test case***********");
	}


	//@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void tc_verifyloginwithmultipledata(String username, String Password, String exp  ) throws InterruptedException {

		try {

			logger.info("***** Start tc_verifysignoutfunctionality test case***********");

			Lp=new LoginPage(driver);
			Lp.enterusernameandpassword(rb.getString("username"),rb.getString("password"));
			logger.info("user name and password has been entered");
			Lp.clickonloginbtn();
			logger.info("Clicked on login button");

			Ap=new AdminPage(driver);
			Thread.sleep(5000);
//			Ap.verifyAdmintitle();
//			logger.info("Admin title is verified");

			boolean admintxt=Ap.isAdminPageExist();
			

			if (exp.equalsIgnoreCase("Valid")) {
				if (admintxt == true) {
					Ap.clickonAdministratorbtn();
					Ap.clickonSignOutbtn();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (admintxt == true) {
					Ap=new AdminPage(driver);
					Ap.clickonAdministratorbtn();
					Ap.clickonSignOutbtn();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		}catch(Exception e) {

			Assert.fail();
		}
		
		logger.info("***************Finished tc_verifyloginwithmultipledata ****************** ");
	}

}
