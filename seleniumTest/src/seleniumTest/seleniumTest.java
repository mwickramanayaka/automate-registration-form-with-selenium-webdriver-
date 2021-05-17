package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class seleniumTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./chromeDriver/chromedriver.exe");
		String baseURL = "https://apply.sliit.lk/DownloadApplication/Inquiry";
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"ProgramFields\"]/div/div/label[1]"));
		checkBox.click();
		
		Thread.sleep(2000);
		
		if (checkBox.isSelected()) {
			System.out.println("check box selected");
		}
		
		WebElement CountryDropDown = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		Select Country = new Select(CountryDropDown);
		
		Country.selectByVisibleText("Syria");
		Thread.sleep(2000);
		
		driver.quit();

		/*
		WebElement SearchField = driver.findElement(By.name("q"));
		SearchField.sendKeys("Chrome");
		
		Thread.sleep(5000);

		WebElement SearchButton = driver.findElement(By.name("btnK"));
		SearchButton.submit(); 
		
		Thread.sleep(3000);
		 
		driver.quit();
		*/
		
	}

}
