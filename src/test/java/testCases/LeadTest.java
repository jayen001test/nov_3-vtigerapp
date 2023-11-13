package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LeadPage;
import pages.LoginPage;
import testBase.BaseTest;

public class LeadTest extends BaseTest{

	public LoginPage Lp;
	public AdminPage Ap;
	public LeadPage LP;


	@Test
	public void  tc_verifyLeadfunctionality() throws InterruptedException {


		logger.info("***** Start tc_verifyLeadfunctionality test case***********");

		Lp=new LoginPage(driver);
		Lp.enterusernameandpassword(rb.getString("username"),rb.getString("password"));
		logger.info("user name and password has been entered");
		Lp.clickonloginbtn();
		logger.info("Clicked on login button");

		Ap=new AdminPage(driver);
		Thread.sleep(5000);
		Ap.verifyAdmintitle();
		logger.info("Admin title is verified");

		LP=new LeadPage(driver);
		LP.clickonLeadbtn();
		logger.info("Clicked on Lead tab");
		Assert.assertEquals(LP.verifyLeadtxt().equalsIgnoreCase(rb.getString("Leadtext")), true);
		logger.info("***** Completed  tc_verifyLeadfunctionality test case successfully***********");

	}










}
