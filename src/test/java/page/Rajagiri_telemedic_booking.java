package page;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Rajagiri_telemedic_booking 
{
	WebDriver d;
	By Department = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div/span/div[1]/div/div/div/ul/li/div/input");
	By Search = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div/span/div[2]/button");
	By Date =By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div[1]/span/div/input");
	By Current_month = By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div[1]/div/span/a[1]");
	By next_month_button = By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div[1]/div/a[3]");
	By select_date = By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div[2]/table/tbody/tr[3]/td[4]/div");
	By checkbox = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div/div[2]/div/div/div/div[1]/label/span[1]/input");
	
	public Rajagiri_telemedic_booking (WebDriver d)
	{
		this.d=d;
	}
	
	//Department selecting
	public void search(String dep_name)
	{
		d.findElement(Department).sendKeys(dep_name);
		d.findElement(Search).click();
	}
	
	//date selecting
	public void date(String exp) throws InterruptedException
	{
		Thread.sleep(3000);
		d.findElement(Date).click();
		while(true)
		{
			String actual = d.findElement(Current_month).getText();
			String expected = exp;
			if(actual.equalsIgnoreCase(expected))
			{
				break;
			}
			else
			{
				d.findElement(next_month_button).click();
			}
		}
		d.findElement(select_date).click();
	}
	
	//unclicking checkbox
	public void checkbox()
	{
		d.findElement(checkbox).click();
	}
	
	//title verification
	public void tverification()
	{
		String Actuall = d.getTitle();
		String Excepted = "Rajagiri Hospital - QuikDr HealthCare Private Limited";
		if(Actuall.equalsIgnoreCase(Excepted))
		{
			System.out.println("Title verification passed, Title is: "+Excepted);
		}
		else
		{
			System.out.println("Title verification Failed");
		}
	}
	//screen shot
	public void screenshot() throws IOException
	{
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	org.openqa.selenium.io.FileHandler.copy(src, new File("C:\\Users\\AJIN\\Desktop\\WORKS\\a//telemedic.png"));
	
	}

}
