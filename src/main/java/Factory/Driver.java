package Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Exceptions.FrameworkException;

public class Driver {
	
	public Properties prop;
	OptionsManager op;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	public Properties int_prop()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\UTKARSH\\eclipse-workspace\\UI\\src\\test\\resources\\config\\qa.properties");
		    prop.load(ip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}

	public WebDriver init_driver(Properties prop)
	{
		String browserName = prop.getProperty("browserName");
		op = new OptionsManager(prop);
		try {
		switch(browserName)
		{
		case "chrome":
			tldriver.set(new ChromeDriver(op.getChromeOptions()));
			break;
			
		case "firefox":
			tldriver.set(new FirefoxDriver());
			break;
			
		default:
			System.out.println("Please pass the right browser");
			throw new FrameworkException("Please pass the right browser");
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
		
	}
	
	public static WebDriver getDriver()
	{
		return tldriver.get();
	}
}
