
// Comment added
package Day1;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebDriverMethodHwork2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String path="C:\\Selenium_Drivers_Jars\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/admin.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		String expected="ParaBank | Administration";
		String actual=driver.getTitle();
		Assert.assertEquals(expected,actual);
		System.out.println(driver.getTitle());
		WebElement parabankaleftpnael=driver.findElement(By.id("leftPanel"));
		Assert.assertTrue(parabankaleftpnael.isDisplayed());
		
		driver.get("https://www.amazon.ca/amazonprime?_encoding=UTF8&%2AVersion%2A=1&%2Aentries%2A=0");
        driver.manage().window().maximize();
        String expected1="Amazon.ca: Amazon Prime";
        String actual1=driver.getTitle();
        Select se=new Select (driver.findElement(By.id("searchDropdownBox")));
        se.selectByIndex(7);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Lipstic");
        driver.findElement(By.id("nav-search-submit-button")).click();
        //driver.navigate().back();
        //Thread.sleep(2000);
       // driver.navigate().forward();
        Assert.assertEquals(actual, expected);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //driver.close();
	}

}
