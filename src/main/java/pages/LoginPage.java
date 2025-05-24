package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	// 1. private By locators: page objects
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By logo = By.cssSelector("img.img-responsive");
	
	private By naveen = By.cssSelector(".naveen");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getPageTitle()
	
	{
		String title = driver.getTitle();
		return title;
		
	}
	
	public String getPageUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public void login (String user, String pass)
	{
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}

	public RegisterPage navigateToRegister()
	{
		driver.findElement(registerLink).click();
		return new RegisterPage();
	}
}
