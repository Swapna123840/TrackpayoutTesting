package SetUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Helpers.TestHelpers;


public class TestSetUp  {
	public static WebDriver driver;
	public static Properties props;
	
	public TestSetUp(){
		try {
			props = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config/config.properties");
			props.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 public static Logger logger;
	
	public static void initialization(){
		
		System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+ "/src/main/resources/chromedriver.exe"));
		driver = new ChromeDriver(); 
		 logger = Logger.getLogger("TrackPayout");
		PropertyConfigurator.configure("Log4j.properties");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestHelpers.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestHelpers.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
	}	

}

