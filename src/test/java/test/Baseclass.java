package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass 
{
	WebDriver d;
	@BeforeClass
	public void bc()
	{
		d=new ChromeDriver();
		d.get("https://patientportal.rajagirihospital.com/");
	}

}
