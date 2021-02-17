package Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAutoSuggestiveDropdownHwork2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String path="C:\\Selenium_Drivers_Jars\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Select an oprtion from an autouggestin dropdown
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement f=driver.findElement(By.xpath("//span[contains(Text(),'From')]"));
		wait.until(ExpectedConditions.visibilityOf(f));
		f.click();
		//WebElement f1=driver.findElement(By.id("fromCity"));
		//wait.until(ExpectedConditions.elementToBeClickable(f1));
		//f1.click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Sydney");
		//driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys (Keys.ARROW_DOWN);
		//driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);
		
		//Another way of writing the same program in more effective way
	     WebElement from=driver.findElement(By.xpath("//input[@placeholder='From']"));
	     wait.until(ExpectedConditions.visibilityOf(from));
	     // store the xpath of the webelemnet in to a variable
	     //Thread.sleep(2000);
	     from.sendKeys("Sydney");//Call the whole method which is stored in form and just provide the sendkeys
	    Thread.sleep(1000);
	     from.sendKeys(Keys.ARROW_DOWN); //Call the arrow down method
	     from.sendKeys(Keys.ENTER);
	     //driver.close();
	}

	
	}
