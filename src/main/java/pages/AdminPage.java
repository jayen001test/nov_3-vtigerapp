package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class AdminPage extends BasePage{

	public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[@class='userName']")
	private WebElement txt_admin;


	@FindBy(xpath="(//td[@class='small'])[2]")
	private WebElement btn_Administrator;

	// //div[@id='ondemand_sub']//a[text()='Sign Out']


	@FindBy(xpath = "//div[@id='ondemand_sub']//a[text()='Sign Out']")
	private WebElement btn_signout; 


	@FindBy(xpath = "//span[@class='userName']")
	private WebElement txt_administrator;


	public void verifyAdmintitle() {

		Assert.assertEquals(driver.getTitle().contains(txt_admin.getText()), true,"title is matching with the partial text");
		System.out.println("Title is matching");

	}




	public void clickonAdministratorbtn() {

		btn_Administrator.click();
	}

	public void clickonSignOutbtn() {

		btn_signout.click();
	}

	public boolean isAdminPageExist() {
		try {

			return txt_administrator.isDisplayed();
		}catch(Exception e) {
			return (false);
		}

	}

}
