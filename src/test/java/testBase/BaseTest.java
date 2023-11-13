package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BaseTest {


	public static WebDriver driver;  // create webdriver as static  

	public Logger logger;

	public ResourceBundle rb;

	@BeforeMethod
	@Parameters("browser")
	public void browsersetup(String br) throws InterruptedException {

		rb=ResourceBundle.getBundle("config");

		logger=LogManager.getLogger(this.getClass());
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		if(br.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver(options);

		}else if(br.equalsIgnoreCase("FF")) {
			driver=new FirefoxDriver();
		}else {

			driver=new EdgeDriver();
		}

		//		driver=new FirefoxDriver();
		//		 driver=new EdgeDriver();
		//		driver=WebDriverManager.chromedriver().create();
		Thread.sleep(5000);
		//		System.out.println(driverpath);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(rb.getString("URL"));
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}


	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}
	
	
	
	public String captureScreen(String tname) throws IOException {

//		 SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
//		  Date dt=new Date();
//		  String time=df.format(dt);
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));  // copied the screenshot from source to destination by using fileutils
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
