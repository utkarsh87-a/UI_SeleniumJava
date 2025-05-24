package BaseClass;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	@Test
	public void validateTitle()
	{
		System.out.println(login.getPageTitle());
	}
	
	@Test
	public void validateUrl()
	{
		System.out.println(login.getPageUrl());
	}

}
