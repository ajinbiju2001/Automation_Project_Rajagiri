package test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import page.Rajagiri_page;

public class Rajagiri_test extends Baseclass
{
@Test
public void test() throws InterruptedException, IOException
{
	Rajagiri_page r = new Rajagiri_page(d);
	d.manage().window().maximize();
	Thread.sleep(2000);
	r.click1();
	r.details("AJIN", "BIJU");
	r.dropdowns();
	r.nextpage();
	r.title_verification();
	r.screenshot();
}
@AfterTest
public void at()
{
	d.close();
}
}
