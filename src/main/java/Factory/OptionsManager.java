package Factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsManager {
	
	ChromeOptions co ;
	private Properties prop;
	
	public OptionsManager(Properties prop)
	{
		this.prop=prop;
	}
	
	
	public ChromeOptions getChromeOptions()
	
	{
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito")))
		{
		co.addArguments("--incognito");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("headless")))
		{
		co.addArguments("--headless");
		}
		
	   return co;
	}
     
}
