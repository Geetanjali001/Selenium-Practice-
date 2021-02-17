package Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleGoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String path="E:\\Selenium\\driver\\chromedriver87\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("testing");
		WebElement box=driver.findElement(By.xpath("//ul[@role='listbox']"));
		//Assert.assertTrue(box.isDisplayed());
		
		WebElement searchBox=driver.findElement(By.name("q"));
		//List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='sbl1']//span"));
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li[@class='sbct']//descendant::div[@class='sbtc']//span//b"));
		int count=list.size();
		for(int i=0;i<count;i++)
		{
			String text=list.get(i).getText();
			System.out.println(text);
		}
		
		driver.close();
	}

}
