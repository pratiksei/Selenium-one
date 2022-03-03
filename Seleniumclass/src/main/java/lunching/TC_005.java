package lunching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_005 extends Basetest
{

	public static void main(String[] args) throws Exception 
	{
		init();	
		launcher("chromebrowser");  
	    navigateUrl("amazonurl");
	    
	    //selectOption("amazondropbox_id","Books");
	    
	    //typeText("amazonsearchtextbox_name","Harry Potter");
	    
	    //clickElement("amazonsearchbutton_xpath");
	    
	     // driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
	    
	      WebElement loc = driver.findElement(By.id("searchDropdownBox"));
          loc.sendKeys("Electronics");
	     
	      driver.findElement(By.name("field-keywords")).sendKeys("Lenovo Laptop");
	     
	      driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

	}

	
	

}
