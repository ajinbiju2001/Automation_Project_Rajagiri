package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.Rajagiri_telemedic_booking;

public class Rajagiri_telemedic_test 
{
	WebDriver d;
	@BeforeClass
	public void bc()
	{
		d = new ChromeDriver();
		d.get("https://booking.rajagirihospital.com/search");	
	}
	
	@Test
	public void test() throws InterruptedException, IOException
	{
		
		Rajagiri_telemedic_booking rt = new Rajagiri_telemedic_booking(d);
		rt.search("cardiology");
		rt.date("Sep");
		rt.checkbox();
		rt.tverification();
		rt.screenshot();
	}
	
}
