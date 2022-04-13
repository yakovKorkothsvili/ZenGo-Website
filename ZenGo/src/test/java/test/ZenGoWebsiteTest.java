package test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tools.ZenGoWebsiteFunctions;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class ZenGoWebsiteTest {
	static public Actions actions;
	static public WebDriver driver;
	static public JavascriptExecutor js;
    //elements from second task
	static public WebElement intercomButton;
	static public String intercom;
	//elements from third task
	static public WebElement assetsMenu;
	static public WebElement ethereumSubLink;
	//elements from fourth task
	static public String url;
	//elements from fifth task
	static public WebElement logoAndIconImage;
	static public Boolean ImagePresent;
	
  @BeforeMethod
  public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		actions=new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://zengo.com/");
  }

  @AfterMethod
  public void afterMethod() {
  }

  @Test
  public void zenGo() throws InterruptedException {
	  
	  Thread.sleep(2000);
		//taking an element intercom button to check if the site is displayed because this element is appearing after the page is loaded
		intercomButton=driver.findElement(By.xpath("//div[@class='intercom-lightweight-app']//div[@role='button']"));
		intercom=intercomButton.getAttribute("aria-label");
		ZenGoWebsiteFunctions.checkingIfTheSiteIsDisplayed(intercom);
		
		//third task go to menu assets and click on sub link ethereum
		assetsMenu=driver.findElement(By.id("menu-item-12609"));
		ethereumSubLink=driver.findElement(By.id("menu-item-13963"));
		actions.moveToElement(assetsMenu).perform();
		ethereumSubLink.click();
				
	   //fourth task verify that you were redirected to right page
		url=driver.getCurrentUrl();
		ZenGoWebsiteFunctions.verifyThatItWasRedirectedToRightPage(url);
		
	  //fifth task verify that zengo icon and ZenGo logo are displayed successfully	
	  logoAndIconImage=driver.findElement(By.xpath("//header//img[@alt=\"zengo logo\"]"));
	  ImagePresent=logoAndIconImage.isDisplayed();
	  ZenGoWebsiteFunctions.checkingIfLogoAndIconAreDisplayed(ImagePresent);
	  driver.quit();
  }
}
