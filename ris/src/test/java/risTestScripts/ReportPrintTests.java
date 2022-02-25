package risTestScripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import OpenBrowsers.OpenBrowsers;

@Test(priority = 4)
public class ReportPrintTests extends OpenBrowsers {
	/*@Test(priority = 0)
	public void openRis() throws IOException {

		try {
			OpenBrowsers.main(null);// open Browser login
			System.out.println("inside openRis");
			Thread.sleep(5000);
			driver.findElement(
					By.linkText("Radiology Information System")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Test(priority = 39)
	public void openReportPrintTest() throws IOException {
		try {
			//Thread.sleep(4000);
			// driver.findElement(By.className("openMainMenus")).click();
			 Thread.sleep(2000);
			driver.findElement(By.linkText("Report Print")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 40)
	public void defaultViewDateSearchTest() throws IOException {
		try {
			Thread.sleep(4000);
			System.out.println("Inside printReportMisTest : Test Starts");
			String recordCount = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count: " + recordCount);
			if (recordCount.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false, "Failed: defaultViewDateSearchTest, Item count: " + recordCount);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 41)
	public void searchWithServiceCategoryServiceStudyNumberRegIdTest() throws IOException {
		try {
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\verifyreport.properties");
			properties.load(inputstream);
			String studyNumber = properties.getProperty("studyNumber");
			String registrationId = properties.getProperty("registrationId");
			WebElement scDdown = driver.findElement(By.name("ProcedureCategoryCode"));
			Select sc = new Select(scDdown);
			sc.selectByValue("8");
			Thread.sleep(2000);
			WebElement sDdown = driver.findElement(By.name("service_id"));
			Select s = new Select(sDdown);
			s.selectByValue("56");
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-report-print-list/section/div/div/div/mat-card/mat-card-content[1]/div/div/div/div/form/div[1]/div[3]/input"))
					.sendKeys(studyNumber);
			driver.findElement(By.name("RegistrationId")).sendKeys(registrationId);
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-report-print-list/section/div/div/div/mat-card/mat-card-content[1]/div/div/div/div/form/div[2]/div/button[1]"))
					.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 42)
	public void searchOnPrintReportTableTest() throws IOException {
		try {
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\verifyreport.properties");
			properties.load(inputstream);
			String studyNumber = properties.getProperty("studyNumber");
			String registrationId = properties.getProperty("registrationId");
			String patientName = properties.getProperty("patientName");
			String scheduleDateTime = properties.getProperty("scheduleDateTime");
			String confirmationDateTime = properties.getProperty("confirmationDateTime");
			String reportCreationDateTime = properties.getProperty("reportCreationDateTime");
			String orderDate = properties.getProperty("orderDate");
			Thread.sleep(3000);
			driver.findElement(By.className("mat-input-element")).sendKeys(patientName);
			Thread.sleep(2000);
			String reportVerificationDateTime = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-report-print-list/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[3]"))
					.getText();
			String recordCount = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count: " + recordCount);
			if (recordCount.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false, "Failed: defaultViewDateSearchTest, Item count: " + recordCount);
			}
			Properties properties1 = new Properties();
			FileOutputStream outputstream1 = new FileOutputStream(
					"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\printreport.properties");
			properties1.setProperty("registrationId", registrationId);
			properties1.setProperty("patientName", patientName);
			properties1.setProperty("scheduleDateTime", scheduleDateTime);
			properties1.setProperty("confirmationDateTime", confirmationDateTime);
			properties1.setProperty("reportCreationDateTime", reportCreationDateTime);
			properties1.setProperty("reportVerificationDateTime", reportVerificationDateTime);
			properties1.setProperty("orderDate", orderDate);
			properties1.setProperty("studyNumber", studyNumber);
			properties1.store(outputstream1, null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 43)
	public void viewReportButtonTest() throws IOException {
		try {
			Thread.sleep(1000);
			WebElement b=driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-report-print-list/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[6]/button"));
			Boolean a = b.isEnabled();
			if (a.equals(true)) {
				b.click();
			} else {
				Assert.assertTrue(false, "Failed: viewReportButton not enable , Returns " + a);
			}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 44)
	public void printReportPageDataValidationTest() throws IOException {
		try {
			SoftAssert Assert = new SoftAssert();
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\verifyreport.properties");
			properties.load(inputstream);
			String studyNumber = properties.getProperty("studyNumber");
			String registrationId = properties.getProperty("registrationId");
			String patientName = properties.getProperty("patientName");
			Thread.sleep(3000);
			String name = driver.findElement(By.xpath("//*[@id='printData']/div[4]/div/div[2]/div/div[1]/strong"))
					.getText();
			String regid = driver.findElement(By.xpath("//*[@id='printData']/div[4]/div/div[2]/div/div[2]/strong"))
					.getText();
			String ser = driver.findElement(By.xpath("//*[@id='printData']/div[4]/div/div[2]/div/div[3]/strong"))
					.getText();
			String studyno = driver
					.findElement(By.xpath("//*[@id='printData']/div[4]/div/div[2]/div/div[4]/strong")).getText();
			if (name.equals(patientName))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: patience name is incorrect in create report page as " + name
						+ "Expected Name: " + patientName);
			if (regid.equals(registrationId))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: registrationId is incorrect in create report page as " + regid
						+ "Expected regid: " + registrationId);
			if (ser.equals("X-ray"))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: Service name is incorrect in create report page as " + ser
						+ "Expected Service:  X-ray ");
			if (studyno.equals(studyNumber))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: studyNumber is incorrect in create report page as " + studyno
						+ "Expected studyNo: " + studyNumber);
			Assert.assertAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 45)
	public void printButtonTest() throws IOException {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='sideLayoutWrapper']/div/app-add-report-print/div[1]/div[2]/em")).click();
            //driver.findElement(By.xpath("//*[@id='printData']/div[4]/div/div[5]/button")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
