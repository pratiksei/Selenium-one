package lunching;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest 
{
	public static WebDriver driver;
	public static String projectpath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainprop;
	public static Properties childprop;
	public static Properties orprop;

	
	public static void init() throws Exception
	{
	    fis = new FileInputStream(projectpath+"/src/main/resources/data.properties");
	    p = new Properties();
		p.load(fis);
		String value = p.getProperty("amazonurl");
		//System.out.println(value);
			
		fis = new FileInputStream(projectpath+"/src/main/resources/environment.properties");
		mainprop = new Properties();
		mainprop.load(fis);
	    String e = mainprop.getProperty("env");
	    System.out.println(e);
	     
	    fis = new FileInputStream(projectpath+"/src/main/resources/"+e+".properties");
	    childprop = new Properties();
	    childprop.load(fis);
	    String v = childprop.getProperty("amazonurl");
	    System.out.println(v);
	    
	    fis = new FileInputStream(projectpath+"/src/main/resources/or.properties");
	    orprop = new Properties();
	    orprop.load(fis);
	    
	}
	
	public static void launcher(String browser)
	{
	 if(p.getProperty(browser).equals("chrome")) 
	 {
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions option = new ChromeOptions();
		 option.addArguments("user-data-dir=C:\\Users\\GUDDU\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
		 option.addArguments("--disable-notifications");
		 option.addArguments("--start-maximized");
		 //certificate errors
		// option.addArguments("--ignore-certificate-errors-spki-list");
		 //proxy ip setting
		 //option.addArguments("--proxy-server=https://192.168.10.1:9090");
		 
		 driver = new ChromeDriver(option);		 
	  }
	 else if(p.getProperty(browser).equals("firefox")) 
	 {
		 WebDriverManager.firefoxdriver().setup();
		 
		 ProfilesIni p = new ProfilesIni();
		 FirefoxProfile profile = p.getProfile("jan2022FF");
		 
		 FirefoxOptions option = new FirefoxOptions();
		 option.setProfile(profile);
		 
		// Handling  Browser Notification
 		 profile.setPreference("dom.webnotifications.enabled", false);	
 		 
 		 //handling certificate error
 		 profile.setAcceptUntrustedCertificates(true);
 		 profile.setAssumeUntrustedCertificateIssuer(false);
 		 
 		 //how to work with proxy setting
 		 profile.setPreference("network.proxy.type", 1);
 		 profile.setPreference("network.proxy.socks", "");
 		 
 		 driver = new FirefoxDriver(option);
 		 		 
	  }
	}
	public static void navigateUrl(String url) 
	{
	driver.get(childprop.getProperty(url));	
	//driver.navigate().to(childprop.getProperty(url));

	}
	
    public static void clickElement(String locatorkey) 
    {
		//driver.findElement(By.xpath(orprop.getProperty(locatorkey))).click();
    	getElement(locatorkey).click();
	}

	public static void typeText(String locatorkey, String text) 
    {
		//driver.findElement(By.name(orprop.getProperty(locatorkey))).sendKeys(text);
    	getElement(locatorkey).sendKeys(text);

	}

    public static void selectOption(String locatorkey, String option) 
    {
	  //driver.findElement(By.id(orprop.getProperty(locatorkey))).sendKeys(option);
    	getElement(locatorkey).sendKeys(option);

	}
    public static WebElement getElement(String locatorkey) 
    {
        WebElement element  = null;
      //check for presence of Element
      		if(!isElementPresent(locatorkey))
      			//report the failure
      			System.out.println("Element is not present :" + locatorkey);
      		
      		 element = driver.findElement(getlocator(locatorkey));
      		 
			/*
			 * if(locatorkey.endsWith("_id")) { element =
			 * driver.findElement(By.id(orprop.getProperty(locatorkey))); } else
			 * if(locatorkey.endsWith("_name")) { element =
			 * driver.findElement(By.name(orprop.getProperty(locatorkey))); } else
			 * if(locatorkey.endsWith("_classname")) { element =
			 * driver.findElement(By.className(orprop.getProperty(locatorkey))); } else
			 * if(locatorkey.endsWith("_xpath")) { element =
			 * driver.findElement(By.xpath(orprop.getProperty(locatorkey))); } else
			 * if(locatorkey.endsWith("_css")) { element =
			 * driver.findElement(By.cssSelector(orprop.getProperty(locatorkey))); }else
			 * if(locatorkey.endsWith("_linktext")){ element =
			 * driver.findElement(By.linkText(orprop.getProperty(locatorkey))); } else
			 * if(locatorkey.endsWith("_partialLinktext")){ element =
			 * driver.findElement(By.partialLinkText(orprop.getProperty(locatorkey)));
			 * 
			 * }
			 */
		  return element;		
		
       }

	public static boolean isElementPresent(String locatorkey)
	{
		System.out.println("check for element present...");
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   
	   try 
	   {
		      wait.until(ExpectedConditions.presenceOfElementLocated(getlocator(locatorkey)));
		    
			/*
			 * if(locatorkey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orprop.
			 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orprop.
			 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_classname")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orprop.
			 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_xpath")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orprop.
			 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_css")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orprop.
			 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_linktext")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orprop.
			 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_partiallinltext"))
			 * { wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(
			 * orprop.getProperty(locatorkey)))); }
			 */
	   } 
	   catch (Exception e)
	   {
	    return false;
	   }		
		return true;
	 }
	 public static By getlocator(String locatorkey)
     {
		 By by = null;
		 
		 if(locatorkey.endsWith("_id")) {
		    by = By.id(orprop.getProperty(locatorkey));	 
		 }else if(locatorkey.endsWith("_name")) {
			 by = By.name(orprop.getProperty(locatorkey));
		 }else if(locatorkey.endsWith("_className")) {
			 by = By.className(orprop.getProperty(locatorkey));
		 }else if(locatorkey.endsWith("_xpath")) {
			 by = By.xpath(orprop.getProperty(locatorkey));
		 }else if(locatorkey.endsWith("_css")) {
			 by = By.cssSelector(orprop.getProperty(locatorkey));
		 }else if(locatorkey.endsWith("linkText")) {
			 by = By.linkText(orprop.getProperty(locatorkey));
		 }else if(locatorkey.endsWith("_partialLinkText")) {
			 by = By.partialLinkText(orprop.getProperty(locatorkey));
		 }
		 
		return by;
	
     }
}
	 

	


