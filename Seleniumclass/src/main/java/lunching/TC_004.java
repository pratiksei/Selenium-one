package lunching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_004 extends Basetest
{

	public static void main(String[] args) throws Exception 
	{

		init();	
		launcher("chromebrowser");  
	    navigateUrl("facebookurl");
				
		
	   driver.findElement(By.id("email")).sendKeys("pratiksei21@gmail.com");

	   driver.findElement(By.id("pass")).sendKeys("1301348626141");
	   
	   driver.findElement(By.name("login")).click();
	    Thread.sleep(2000);
	    
	   driver.findElement(By.xpath("//body/div[@id='mount_0_0_fZ']/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/span[1]/div[1]/div[1]")).click();
	   
	    
	}

	
	}
	

