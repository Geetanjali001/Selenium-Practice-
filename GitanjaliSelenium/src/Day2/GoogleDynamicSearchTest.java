package Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDynamicSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\work\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.ca/");
		
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("testing");
		Thread.sleep(3000);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='sbl1']//span"));
		System.out.println("No of options: "+list.size());
		
		for(int i=0;i<list.size();i++)
		{
			String s=list.get(i).getText();
			System.out.println(s);
			if(s.contains("testing jobs in canada"))
			{
				list.get(i).click();
				break;
			}
		}
		
		//driver.close();

	}

}
