package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ValidateValueinAutosuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String path="E:\\Selenium\\driver\\chromedriver87\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		driver.manage().window().maximize();
		
		//verify
		
		//inspect the searh box and enter lip
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mask");
		Thread.sleep(1000);
		
		String item="mask bracket";
		int flag=0;
		
		for(int i=1;i<=10;i++)
		{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String script="return document.getElementById(\"twotabsearchtextbox\").value;";
		String text=(String) js.executeScript(script);
		System.out.println(text);
		if(text.equals(item))
		{
			Assert.assertEquals(text, item);
			flag=1;
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);;
			Thread.sleep(3000);
			break;
		}
		Thread.sleep(1000);
		}// end of loop
		if(flag==1)
			System.out.println("Successfull");
		if(flag==0)
			System.out.println("unsuccessful");
		driver.close();
	}

}
