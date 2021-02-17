package Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleAutoSuggestiveDropdownHwork {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String path="C:\\Selenium_Drivers_Jars\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://global.shopbakerhughes.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement searchBox=driver.findElement(By.id("search"));
		searchBox.sendKeys("bit");
		Thread.sleep(2000);
		
		// create object of JavascriptExecutor in order to execute javascript in selenium
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String script="return document.getElementById(\"search\").value;";
		int flag=0;
		String item=" bit breaker";
		
		for(int i=1;i<=8;i++)
		{
			
		searchBox.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		String text=(String) js.executeScript(script);
		System.out.println(text);
			if(text.equals(item))
			{
				System.out.println("Inside if");
				flag = 1;
				searchBox.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				break;
			}
			
		}
		System.out.println("Flag= "+flag);
		if(flag==1)
			Assert.assertTrue(true);
		
		driver.close();
	}

}
