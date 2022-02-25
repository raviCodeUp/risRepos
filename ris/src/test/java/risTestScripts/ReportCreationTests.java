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

@Test(priority = 2)
public class ReportCreationTests extends OpenBrowsers {
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

	@Test(priority = 16)
	public void openReportCreationTest() throws IOException {

		try {
			//Thread.sleep(4000);
			// driver.findElement(By.className("openMainMenus")).click();
			 Thread.sleep(1000);
			driver.findElement(By.linkText("Report Creation")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 17)
	public void showLastThreeDaysDataDefaultDateSearchTest() throws IOException {

		try {
			Thread.sleep(4000);
			System.out.println("Inside createReportTest : Test Starts");
			String recordCount = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count: " + recordCount);
			if (recordCount.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false, "Failed: showLastThreeDaysDataDefaultTest, Item count: " + recordCount);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 18)
	public void searchWithServiceCategoryServiceStudyNumberRegIdDateTest() throws IOException {

		try {
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\confirm.properties");
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
					.xpath("/html/body/app-root/section/div/app-report-creation/section/div/div/div/mat-card/mat-card-content/div/div/div/div/form/div[1]/div[3]/input"))
					.sendKeys(studyNumber);
			driver.findElement(By.name("RegistrationId")).sendKeys(registrationId);
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-report-creation/section/div/div/div/mat-card/mat-card-content/div/div/div/div/form/div[2]/div/button[1]"))
					.click();
			Thread.sleep(3000);
			String recordCount = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count: " + recordCount);
			if (recordCount.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false,
						"Failed: searchWithServiceCategoryServiceStudyNumberRegIdDateTest , Item count: "
								+ recordCount);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 19)
	public void searchOnCreateReportTableAndDataTest() throws IOException {

		try {
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\confirm.properties");
			properties.load(inputstream);
			String studyNumber = properties.getProperty("studyNumber");
			String registrationId = properties.getProperty("registrationId");
			String patientName = properties.getProperty("patientName");
			String scheduleDateTime = properties.getProperty("scheduleDateTime");
			String orderDate = properties.getProperty("orderDate");
			Thread.sleep(3000);
			driver.findElement(By.className("mat-input-element")).sendKeys(patientName);
			Thread.sleep(3000);
			String recordCount = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count: " + recordCount);
			if (recordCount.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false,
						"Failed: searchWithServiceCategoryServiceStudyNumberRegIdDateTest , Item count: "
								+ recordCount);
			}
			String confirmationDateTime = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-report-creation/section/div/div/div/mat-card/div[2]/mat-card-content/div/div/div/div[2]/table/tbody/tr/td[3]"))
					.getText();
			Properties properties1 = new Properties();
			FileOutputStream outputstream1 = new FileOutputStream(
					"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\createreport.properties");
			properties1.setProperty("registrationId", registrationId);
			properties1.setProperty("patientName", patientName);
			properties1.setProperty("scheduleDateTime", scheduleDateTime);
			properties1.setProperty("confirmationDateTime", confirmationDateTime);
			properties1.setProperty("orderDate", orderDate);
			properties1.setProperty("studyNumber", studyNumber);
			properties1.store(outputstream1, null);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 20)
	public void createButtonTest() throws IOException {

		try {
			Thread.sleep(1000);
			WebElement b = driver.findElement(By.xpath("//*[@id='pay_advance']"));
			Boolean a = b.isEnabled();
			if (a.equals(true)) {
				b.click();
			} else {
				driver.quit();
				Assert.assertTrue(false, "Failed: createButton not enable , Returns " + a);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 21)
	public void reportCreationPageDataTest() throws IOException {

		try {
			SoftAssert Assert = new SoftAssert();
			Thread.sleep(3000);
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\confirm.properties");
			properties.load(inputstream);
			String studyNumber = properties.getProperty("studyNumber");
			String registrationId = properties.getProperty("registrationId");
			String patientName = properties.getProperty("patientName");
			// create Report page
			String name = driver
					.findElement(By
							.xpath("//*[@id='sideLayoutWrapper']/div/app-create-report/div[2]/div/div/div[2]/div/div[1]/strong"))
					.getText();
			String regid = driver
					.findElement(By
							.xpath("//*[@id='sideLayoutWrapper']/div/app-create-report/div[2]/div/div/div[2]/div/div[2]/strong"))
					.getText();
			String ser = driver
					.findElement(By
							.xpath("//*[@id='sideLayoutWrapper']/div/app-create-report/div[2]/div/div/div[2]/div/div[3]/strong"))
					.getText();
			String studyno = driver
					.findElement(By
							.xpath("//*[@id='sideLayoutWrapper']/div/app-create-report/div[2]/div/div/div[2]/div/div[4]/strong"))
					.getText();
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
	@Test(priority = 22)
	public void reportCreationPageNegativeTest() throws IOException {

		try {
			Thread.sleep(1000);
			Boolean a=driver.findElement(
					By.xpath("//*[@id='sideLayoutWrapper']/div/app-create-report/div[2]/form/div/div[5]/button[1]"))
					.isEnabled();
			if(a.equals(true))
			{
				Assert.assertTrue(false, "Failed: Save button enabled without creating report , Returns " + a);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 23)
	public void reportCreationPageSelectTemplateTest() throws IOException {

		try {
			Thread.sleep(1000);
			WebElement tempDdown = driver.findElement(
					By.xpath("//*[@id='sideLayoutWrapper']/div/app-create-report/div[2]/form/div/div[1]/select"));
			Select s2 = new Select(tempDdown);
			s2.selectByIndex(1);
			//s2.selectByVisibleText("Test ravi");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 24)
	public void reportCreationPageCreatedByTest() throws IOException {

		try {
			Thread.sleep(1000);
			WebElement cByDdown = driver.findElement(
					By.xpath("//*[@id='sideLayoutWrapper']/div/app-create-report/div[2]/form/div/div[4]/select"));
			Select s3 = new Select(cByDdown);
			s3.selectByIndex(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 25)
	public void reportCreationPageSaveButtonTest() throws IOException {

		try {
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//*[@id='sideLayoutWrapper']/div/app-create-report/div[2]/form/div/div[5]/button[1]"))
					.click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
