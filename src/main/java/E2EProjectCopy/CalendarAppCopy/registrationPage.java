package E2EProjectCopy.CalendarAppCopy;
import java.nio.channels.Selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author AKHIL BINGI
 *
 */
public class registrationPage {

	

    public WebDriver driver;
	
    private By RegPage=By.linkText("Register Now");
	private By email=By.xpath("//input[@name='email']");
	private  By name=By.xpath("//input[@name='name']");
	private By username=By.xpath("//input[@name='username']");
	private By Avatar=By.xpath("//input[@name='image']");
	private By password=By.xpath("//input[@name='password']");
	private By button=By.xpath("//form[@action='/register']/button");
	private By regAlready=By.linkText("Already registered");
	

	
	

	public registrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement EnterRegPage() 
	{
		return driver.findElement(RegPage);
		 
	}

	public WebElement getEmail() 
	{
		return driver.findElement(email);
		
		
	}
	
	public WebElement getName() 
	{
		return driver.findElement(name);
	}
	
	public WebElement getUsernme() 
	{
		return driver.findElement(username);
	}
	public WebElement getAvatar() 
	{
		return driver.findElement(Avatar);
	}
	public WebElement getpassword() 
	{
		return driver.findElement(password);
	}
	public WebElement Submit() 
	{
		return driver.findElement(button);
	}
	
	public WebElement register() 
	{
		return driver.findElement(regAlready);
	}
	
}
