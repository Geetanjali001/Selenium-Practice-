package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebDriversMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//String path="E:\\Selenium\\driver\\chromedriver87\\chromedriver_win32\\chromedriver.exe";
		String path="E:\\Selenium\\driver\\chromedriver87\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		//driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		//display current url
		System.out.println(driver.getCurrentUrl());
		
		String expected="My Store";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		
		//click on women tab
		driver.findElement(By.linkText("Women")).click();
		String expected1="Women - My Store";
		String actual1=driver.getTitle();
		Assert.assertEquals(actual1, expected1);
		System.out.println(driver.getCurrentUrl());
		
		WebElement womenPageLeftSide=driver.findElement(By.id("categories_block_left"));
		Assert.assertTrue(womenPageLeftSide.isDisplayed());
		
		//click on back button
		driver.navigate().back();
		Assert.assertEquals(actual, expected);
		
		Thread.sleep(1000);
		
		//forward
		driver.navigate().forward();
		Thread.sleep(2000);
		WebElement a=driver.findElement(By.id("categories_block_left"));
		Assert.assertTrue(a.isDisplayed());
		
		//System.out.println(driver.getPageSource());
		driver.close();
	}

}
