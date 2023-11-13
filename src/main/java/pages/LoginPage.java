package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(xpath = "//input[@name='user_name']")
	public WebElement txtbox_username;
	
	
	@FindBy(xpath = "//input[@name='user_password']")
	public WebElement txtbox_pw;
	
	
	
	@FindBy(xpath = "//input[@id='submitButton']")
	public WebElement btn_login;

	
	
	
	public  void enterusernameandpassword(String username, String pw) {
		
		txtbox_username.sendKeys(username);
		txtbox_pw.sendKeys(pw);
		
	}
	
	public void clickonloginbtn() {
		
		btn_login.click();
	}
	
	
	
	
	

}
