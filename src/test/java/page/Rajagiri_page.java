package page;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Rajagiri_page 
{
	WebDriver d;
	By Quick_appointment = By.xpath("//a[@title=\"Appointment Booking\"]");
	By title = By.id("P_title");
	By Frist_name = By.id("txt_Fname");
	By Last_name = By.id("txt_Lname");
	By gender = By.id("txt_gender");
	By agee = By.id("ptntAge");
	By MaritalStatus = By.xpath("//*[@id=\"TentApt1\"]");
	By Mobilenumber= By.id("txt_Mobno");
	By Emailid= By.xpath("//*[@id=\"TentApt3\"]");
	By pincode= By.xpath("//*[@id=\"TentApt0\"]");
	By state= By.id("txt_State");
	By city = By.id("txt_City");
	By address= By.xpath("//*[@id=\"TentApt2\"]");
	By locality= By.id("txtlocation");
	By Nationalid= By.xpath("//*[@id=\"TentApt4\"]");
	By Nationalidnum= By.xpath("//*[@id=\"TentApt5\"]");
	//next page
	By nextbutton = By.id("btn_Next");
	By Speciality = By.id("ddlSpeciality");
	By Doctor = By.id("ddlDoctor");
	By Date = By.id("txtdate");
	By view = By.id("btnViewAppointment");
	
	public Rajagiri_page(WebDriver d2) 
	{
		this.d=d2;
	}

	
	public void click1() throws InterruptedException
	{
		Thread.sleep(5000);
		d.findElement(Quick_appointment).click();
		
	}
	public void details(String Fname,String Lname)
	{
		
		//firstname & lastname
		d.findElement(Frist_name).sendKeys(Fname);
		d.findElement(Last_name).sendKeys(Lname);
		d.findElement(agee).sendKeys("23");
		d.findElement(Mobilenumber).sendKeys("1234567898");
		d.findElement(Emailid).sendKeys("axyz@gmail.com");
		d.findElement(pincode).sendKeys("689511");
		d.findElement(address).sendKeys("Chengannur,Alppuzha");
		
		
	}
	public void dropdowns() throws InterruptedException
	{
		//selecting title
		WebElement Title = d.findElement(title);
		Title.click();
		Select td = new Select(Title);
		td.selectByIndex(1);
		
		//selecting gender
		WebElement genderr= d.findElement(gender);
		Select gd = new Select(genderr);
		gd.selectByIndex(1);
		
		//MaritalStatus
		WebElement ms = d.findElement(MaritalStatus);
		Select msd = new Select(ms);
		msd.selectByIndex(3);
		Thread.sleep(5000);
		//State
		WebElement Statee= d.findElement(state);
		Select sd = new Select(Statee);
		sd.selectByVisibleText("Kerala");
		Thread.sleep(2000);
		//City
		WebElement Cityy = d.findElement(city);
		Select cd=new Select(Cityy);
		cd.selectByValue("44");
		Thread.sleep(2000);
		//Locality
		WebElement Locality = d.findElement(locality);
		Select ld =new Select(Locality);
		ld.selectByVisibleText("Cheriyanadu");
		Thread.sleep(2000);
		//NationalID 
		WebElement nationallid = d.findElement(Nationalid);
		Select nidd = new Select(nationallid);
		nidd.selectByIndex(1);
		d.findElement(Nationalidnum).sendKeys("123412341234");
		
		
	}
	public void nextpage() throws InterruptedException
	{
		d.findElement(nextbutton).click();
		
		Thread.sleep(5000);
		//Specialty
		WebElement Spec = d.findElement(Speciality);
		Select specd = new Select(Spec);
		specd.selectByValue("58");
		
		Thread.sleep(2000);
		//doctor
		WebElement doc = d.findElement(Doctor);
		Select docd = new Select(doc);
		docd.selectByValue("165");
		
		Thread.sleep(2000);
		//Date
		WebElement date=d.findElement(Date);
		date.sendKeys("29");
		date.sendKeys("09");
		date.sendKeys("2024");
		
		Thread.sleep(2000);
		//view appointment
		d.findElement(view).click();
	}
	public void title_verification() 
	{
		String actual=d.getTitle();
		String expected = "Patient Portal";
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("Tile verification passed, TITLE: " +actual);
		}
		else
		{
			System.out.println("Title verification failed, Actual title is: " +expected);
		}
	}
	public void screenshot() throws IOException
	{
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	org.openqa.selenium.io.FileHandler.copy(src, new File("C:\\Users\\AJIN\\Desktop\\WORKS\\a//book.png"));
	
	}
}
