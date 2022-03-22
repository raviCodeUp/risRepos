package OpenBrowsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Login {
	public static WebDriver driver;
    @Parameters({"browser"})
	@BeforeSuite(groups={"smoke","sanity","regression"})
	public void launchAndLoginRis(String browser) throws IOException {

		try {

			// Open Browser
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\browser.properties");
			properties.load(inputstream);
			//String browser = properties.getProperty("browser");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			System.out.println("RunOn " + browser);
			if (browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			driver.navigate().to(url);
			driver.manage().window().maximize();
			// Login
			Thread.sleep(2000);
			driver.findElement(By.id("mat-input-0")).sendKeys(username);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='mat-input-1']")).sendKeys(password);
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(15000);
			driver.findElement(
					By.xpath("//*[@id='content-wrap']/app-header/app-login/section/div/div/div[2]/form/div/button"))
					.click();
			System.out.println("inside OpenBrowsers n Login");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
