package page;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Rajagiri_home_feedback 
{
	WebDriver d;
	By feedback = By.xpath("//*[@id=\"ctl00\"]/footer/div/div/div/div/div[4]/ul/li[11]/a");
	By f_name = By.id("cphMainContent_txtName");
	By l_name =By.xpath("//*[@id=\"cphMainContent_TextBox1\"]");
	By phonenum = By.id("cphMainContent_txtPh");
	By Email = By.id("cphMainContent_txtEmail");
	By cityname =By.id("cphMainContent_txtSubject");
	By feedback_message = By.xpath("/html/body/form/div[5]/div[2]/div/div[6]/textarea");
	By captcha_checkbox = By.id("recaptcha-anchor");
	By submit = By.xpath("//*[@id=\"cphMainContent_A1\"]");
	
	public Rajagiri_home_feedback(WebDriver d)
	{
		this.d=d;
	}

	
	//feedback form filling
	public void feedback(String firstname,String lastname,String city) throws InterruptedException
	{
		Thread.sleep(5000);
		d.findElement(feedback).click();
		d.findElement(f_name).sendKeys(firstname);
		d.findElement(l_name).sendKeys(lastname);
		d.findElement(phonenum).sendKeys("1234123412");
		d.findElement(Email).sendKeys("example12@gmail.comm");
		d.findElement(cityname).sendKeys(city);
		Thread.sleep(5000);
		WebElement fb = d.findElement(feedback_message);
		fb.sendKeys("sample text");
		Thread.sleep(5000);
		//WebElement cb =	d.findElement(captcha_checkbox);
		//Actions act = new Actions(d);
		//act.moveToElement(cb);
		//act.click();
		//act.perform();
		d.findElement(submit).click();
		
		
	}
	public void title_verification()
	{
		String actual = d.getTitle();
		String expected = "Rajagiri Hospital";
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("verification passed, Title: "+expected);
		}
		else
		{
			System.out.println("verification failed, Actual title: "+expected );
		}
	}
	public void screenshot() throws IOException
	{
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	org.openqa.selenium.io.FileHandler.copy(src, new File("C:\\Users\\AJIN\\Desktop\\WORKS\\a//src.png"));
	
	}

}
