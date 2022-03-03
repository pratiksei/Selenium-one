package lunching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_003 extends Basetest
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
	  //go to notification and like one post  
	    driver.findElement(By.xpath("//a[@aria-label='Notifications']")).click();
	     Thread.sleep(3000);
	    
        //driver.findElement(By.xpath("//strong[contains(text(),'Railway colony mancheswar(boys vs girls)')]")).click();	
        // Thread.sleep(5000);
	   // driver.findElement(By.xpath("//div[@aria-label='Remove Wow']")).click();
	      
	      
	     // Thread.sleep(5000);
	      
	   //go to account and log out 
	    driver.findElement(By.xpath("//div[@aria-label='Account'][@role='button']")).click();
	    Thread.sleep(5000);

	     WebElement logout = driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
	     logout.click();
	   
	}

}
