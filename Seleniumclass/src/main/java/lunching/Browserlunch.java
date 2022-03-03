package lunching;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Browserlunch {

	public static void main(String[] args) 
	{		
	WebDriver driver;
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\GUDDU\\Desktop\\selenium 2022 drivers\\chromedriver.exe");	
    WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
    
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\GUDDU\\Desktop\\selenium 2022 drivers\\geckodriver.exe");
    WebDriverManager.firefoxdriver().setup();
	 driver=new FirefoxDriver();
     
	System.setProperty("webdriver.msedge.driver", "C:\\Users\\GUDDU\\Desktop\\selenium 2022 drivers\\msedgedriver.exe");
	 WebDriverManager.edgedriver().setup();
	 driver=new EdgeDriver();
	}
	

}
