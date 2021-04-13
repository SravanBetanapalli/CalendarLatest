package E2EProjectCopy.CalendarAppCopy;

import org.testng.annotations.Test;

import util.TestUtil;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * @author AKHIL BINGI
 *
 */

public class regPageValidation extends mainClass{

	/*@BeforeTest
	public void setup() throws IOException
	{
		    driver=initialize();
			invokeURLfromtextfile i=new invokeURLfromtextfile();
			driver.get(i.geturl());
			registrationPage reg=new registrationPage(driver);
			reg.EnterRegPage().click();
	}*/
	
	
	
	public WebDriver driver;
	@Test(dataProvider="getdata")
	public void invokingRegistrationPage(String emailid,String Name,String Username,String password,String URL) throws IOException, InterruptedException
	
	{
		driver=initialize();
		invokeURLfromtextfile i=new invokeURLfromtextfile();
		driver.get(i.geturl());
		
		registrationPage reg=new registrationPage(driver);
		reg.EnterRegPage().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		reg.getEmail().sendKeys(emailid);
		reg.getName().sendKeys(Name);
		reg.getUsernme().sendKeys(Username);
		reg.getpassword().sendKeys(password);
		reg.getAvatar().sendKeys(URL);
		reg.Submit().click();
		//cust_url is the url of the login user at that instance
		String cust_url=i.geturl()+"/calendar/"+Username;
        //WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/section/div[1]/h1")));
		///html/body/section/section/div[1]/h1
	
		String curl_url=driver.getCurrentUrl();
		
		//according to functonality the user is logging after functionality so validating the url 
		Assert.assertTrue(cust_url.equalsIgnoreCase(curl_url), "The test case failed as the user could not be able to register");
	}//http://localhost:3000/calendar/bingiweq123s
	
	@DataProvider
	public Object[][] getdata() 
	{
		//Accesing the excel data from static class TestUtil,Enhanced the code without hardcoding
		Object[][] data=TestUtil.getTestData("reg");
		return data;
		
		/*Object[][] data=new Object[2][5];
		data[0][0]="akhilbingi@gmail.com";
		data[0][1]="akhil bingi";
		data[0][2]="akhilbingi32";
		data[0][3]="Matrix@321456";
		data[0][4]="https://www.google.com/";
		
		data[1][0]="akhilbingi64@gmail.com";
		data[1][1]="bingi64";
		data[1][2]="akhilbingi64@gmail.com";
		data[1][3]="Matrix@32164";
		data[1][4]="https://www.google.com/";
		
		return data;*/
		
	}
	
	@AfterTest
	public void aftertest() 
	{
		driver.close();
	}
	
	
	
	
}