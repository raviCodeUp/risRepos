package risTestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import OpenBrowsers.Login;

@Test(priority = 3)
public class ReportUpdateTests extends Login {
	
	@Test(priority = 26)
	public void clickUpdateReportButtonTest() throws IOException {

		try {
			Thread.sleep(3000);
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-report-creation/section/div/div/div/mat-card/div[1]/div/button[2]"))
					.click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 27)
	public void defaultViewTableDataTest() throws IOException {

		try {
			Thread.sleep(3000);
			String recordcount=driver.findElement(By.xpath("/html/body/app-root/section/div/app-report-creation/section/div/div/div/mat-card/div[2]/mat-card-content/div/div/div/div[1]/div[2]/mat-paginator/div/div/div[2]/div")).getText();
            if(recordcount.equals("0 of 0"))
            {
            	Assert.assertTrue(false, "Failed: defaultViewTableDataTest, Item count: " + recordcount);
            }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 28)
	public void itemsPerPageTest() throws IOException {

		try {
			Thread.sleep(2000);
			String itemsPerPage = driver.findElement(By.className("mat-select-value")).getText();
			System.out.println("items per page = " + itemsPerPage);
			Assert.assertEquals(itemsPerPage, "5");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 29)
	public void searchWithServiceCategoryServiceStudyNumberRegIdDateTest() throws IOException {

		try {
			Thread.sleep(2000);
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\confirm.properties");
			properties.load(inputstream);
			String studyNumber = properties.getProperty("studyNumber");
			String registrationId = properties.getProperty("registrationId");
			String patientName = properties.getProperty("patientName");
			System.out.println(studyNumber + " " + registrationId + " " + patientName);
			WebElement scDdown = driver.findElement(By.name("ProcedureCategoryCode"));
			Select sc = new Select(scDdown);
			sc.selectByValue("8");
			Thread.sleep(2000);
			WebElement sDdown = driver.findElement(By.name("service_id"));
			Select s = new Select(sDdown);
			s.selectByValue("56");
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-report-creation/section/div/div/div/mat-card/mat-card-content/div/div/div/div/form/div[1]/div[3]/input"))
					.sendKeys(studyNumber);
			driver.findElement(By.name("RegistrationId")).sendKeys(registrationId);
			Thread.sleep(3000);
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-report-creation/section/div/div/div/mat-card/mat-card-content/div/div/div/div/form/div[2]/div/button[1]"))
					.click();
			Thread.sleep(4000);
			driver.findElement(By.className("mat-input-element")).sendKeys(patientName);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 30)
	public void updateButtonTest() throws IOException {
		try {
			Thread.sleep(2000);
			WebElement b=driver.findElement(By.xpath("//*[@id='pay_advance']"));
			Boolean a = b.isEnabled();
			if (a.equals(true)) {
				b.click();
			} else {
				Assert.assertTrue(false, "Failed: updateButton not enable , Returns " + a);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 31)
	public void updateReportAndUpdatebuttonTest() throws IOException {
		try {
			Thread.sleep(3000);
			driver.findElement(By.className("angular-editor-textarea")).sendKeys("Automation Test");
			WebElement b=driver.findElement(
					By.xpath("//*[@id='sideLayoutWrapper']/div/app-create-report/div[2]/form/div/div[4]/button"));
			Boolean a = b.isEnabled();
			if (a.equals(true)) {
				b.click();
			} else {
				Assert.assertTrue(false, "Failed: updateButton not enable , Returns " + a);
			}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
