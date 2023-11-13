package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadPage extends BasePage {

	public LeadPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(xpath ="//td[@class='tabSelected']//a[text()='Leads']//parent::td")
	private WebElement tab_lead;

	@FindBy(xpath ="//td[@class='moduleName']//a[text()='Leads']")
	private WebElement txt_Lead;




	public void clickonLeadbtn() throws InterruptedException {
		
		Thread.sleep(5000);
		tab_lead.click();
	}


	public String verifyLeadtxt() {

		return txt_Lead.getText();
	}


}
