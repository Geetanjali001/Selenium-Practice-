
//WAP to select a value from autosuggestive dropdown 
package Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleAutoSuggestiveDropdownHwork3 {

	//private static final String String; = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String path="C:\\Selenium_Drivers_Jars\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/amazonprime?_encoding=UTF8&%2AVersion%2A=1&%2Aentries%2A=0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("eye");
		Thread.sleep(2000);
		// create object of JavascriptExecutor in order to execute javascript in selenium
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String javascript="return document.getElementById(\"twotabsearchtextbox\").value;";
		int flag=0;
		String item="eye mask";
		//int flag=0;
		for (int i=1;i<10;i++) {
			searchbox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			String itemtext=(String) js.executeScript(javascript);
		    System.out.println(itemtext);
		    if(itemtext.equals(item)) {
		    	
		    	 flag = 1;
		    	 searchbox.sendKeys(Keys.ENTER);
		    	 Thread.sleep(2000);
		    	 break;	 
		    }
		
		}
		System.out.println("flag: "+flag);
		if (flag==1)
			Assert.assertTrue(true);
		
		
		
		
			}

}
