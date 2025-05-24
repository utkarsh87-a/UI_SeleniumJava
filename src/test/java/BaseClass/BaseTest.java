package BaseClass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import Factory.Driver;
import pages.LoginPage;

public class BaseTest {

	Properties prop;
	WebDriver driver;
	LoginPage login;
	
	@BeforeTest
	public void suiteSetup()
	{
	
		Driver d = new Driver();
		prop = d.int_prop();
		driver = d.init_driver(prop);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		login = new LoginPage(driver);
		
	}
	
	
	public void teardown()
	{
		driver.quit();
	}
}
