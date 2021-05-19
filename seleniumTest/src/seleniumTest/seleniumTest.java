package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class seleniumTest {

	static String browser = "";
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		setBrowser();fffff
		setBrowserConfig();
		runTest();

	}
	public static void setBrowser() {

		browser = "chrome";

	}

	public static void setBrowserConfig() {

		if (browser.contains("fireefox")) {
			System.setProperty("webdriver.chrome.driver", "./chromeDriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	public static void runTest() throws InterruptedException {

		String baseURL = "https://apply.sliit.lk/DownloadApplication/Inquiry";

		String expectedTitle = "Inquiry - Online Registration System";
		String actualTitle = "";

		driver.manage().window().maximize();
		driver.get(baseURL);

		actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
			driver.close();

		}

		WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"ProgramFields\"]/div/div/label[1]"));
		checkBox.click();

		Thread.sleep(2000);

		if (checkBox.isSelected()) {
			System.out.println("check box selected");
		}

		WebElement CountryDropDown = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		Select Country = new Select(CountryDropDown);

		Country.selectByVisibleText("Syria");
		Thread.sleep(4000);

		driver.quit();

	}
}


