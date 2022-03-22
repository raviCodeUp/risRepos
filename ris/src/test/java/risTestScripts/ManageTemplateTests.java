package risTestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import OpenBrowsers.Login;

@Test(priority = 7)
public class ManageTemplateTests extends Login {
	
	@Test(priority = 62,groups="regression")
	public void openManageTemplateTest() throws IOException {

		try {
			driver.findElement(By.linkText("Manage Templates")).click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 63,groups="regression")
	public void defaultViewDataTest() throws IOException {

		try {
			Thread.sleep(2000);
			String recordcountdefault = driver.findElement(By.className("mat-paginator-range-label")).getText();
			if (recordcountdefault.equals("0 of 0")) {
				Assert.assertTrue(false, "Failed: defaultViewDataTest, Item count: " + recordcountdefault);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 64,groups="regression")
	public void AddReportTemplateButtonTest() throws IOException {

		try {
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-manage-report-template/section/div/div/div/mat-card/mat-card-title[2]/button"))
					.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 65,groups="regression")
	public void AddReportTemplateTest() throws IOException {

		try {
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\browser.properties");
			properties.load(inputstream);
			String templateName = properties.getProperty("templateName");
			Thread.sleep(2000);
			WebElement scDdown1 = driver.findElement(By.name("service_category_code"));
			Select sc1 = new Select(scDdown1);
			sc1.selectByValue("8");
			Thread.sleep(2000);
			WebElement scDd = driver.findElement(By.xpath("//*[@id='newTempManage']/div/div/div[2]/div[2]/div/select"));
			Select sc12 = new Select(scDd);
			sc12.selectByValue("56");
			driver.findElement(By.name("report_title")).sendKeys(templateName);
			driver.findElement(By.xpath("//*[@id='report_description']/div/div/div")).sendKeys("Automation Report");
			driver.findElement(By.name("report_impression")).sendKeys("Auto Normal");
			WebElement createByDd = driver
					.findElement(By.xpath("//*[@id='newTempManage']/div/div/div[2]/div[6]/div/select"));
			Select cb12 = new Select(createByDd);
			cb12.selectByValue("1: ashu_6604");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='newTempManage']/div/div/div[3]/button[2]")).click();
			Thread.sleep(4000);
			driver.findElement(By.className("swal2-confirm")).click();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 66,groups="regression")
	public void searchTemplateTest() throws IOException {

		try {
			Thread.sleep(2000);
			WebElement scDdown2 = driver.findElement(By.name("service_category_code"));
			Select sc2 = new Select(scDdown2);
			sc2.selectByValue("8");
			Thread.sleep(2000);
			WebElement scDd2 = driver.findElement(By.name("service_id"));
			Select sc123 = new Select(scDd2);
			sc123.selectByValue("56");
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-manage-report-template/section/div/div/div/mat-card/mat-card-content[1]/div/div/form/div/div[4]/button[1]"))
					.click();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 67,groups="regression")
	public void searchOnAvailableTemplateTableTest() throws IOException {

		try {
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\browser.properties");
			properties.load(inputstream);
			String templateName = properties.getProperty("templateName");
			Thread.sleep(2000);
			driver.findElement(By.className("mat-input-element")).sendKeys(templateName);
			Thread.sleep(2000);
			String recordcount = driver.findElement(By.className("mat-paginator-range-label")).getText();
			if (recordcount.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false,
						"Failed: Template Creation Failed, Item count: " + recordcount);
							}
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 68,groups="regression")
	public void uniqueTemplateNameTest() throws IOException {

		try {
			Thread.sleep(1000);
			String recordcount = driver.findElement(By.className("mat-paginator-range-label")).getText();
			if (recordcount.equals("1 – 1 of 1"))
			{
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false,
						"Failed: Duplicate Template Created , Item count: " + recordcount);
			}
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 69,groups="regression")
	public void updateTemplateTest() throws IOException {

		try {
			SoftAssert Assert = new SoftAssert();
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\browser.properties");
			properties.load(inputstream);
			String templateName = properties.getProperty("templateName");
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-manage-report-template/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div/div[2]/table/tbody/tr/td[3]/button"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.id("report_title")).sendKeys("update");
			driver.findElement(By.className("angular-editor-textarea")).sendKeys("update");
			driver.findElement(By.id("report_impression")).sendKeys("update");
			driver.findElement(By.xpath("//*[@id='newTempManage']/div/div/div[3]/button[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.className("swal2-confirm")).click();
			Thread.sleep(2000);
			String pretext = driver.findElement(By.className("mat-input-element")).getText();
			if (pretext.equals(templateName)) {
				Assert.assertTrue(false, "search box refresh for new search");
			}
			driver.findElement(By.className("mat-input-element")).clear();
			driver.findElement(By.className("mat-input-element")).sendKeys(templateName + "update");
			Thread.sleep(2000);
			String updatedTempname = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-manage-report-template/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]"))
					.getText();
			if (updatedTempname.equals(templateName + "update")) {
			} else {
				Assert.assertTrue(false, "Template not updated");
			}
			Assert.assertAll();
		    driver.close();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}

	