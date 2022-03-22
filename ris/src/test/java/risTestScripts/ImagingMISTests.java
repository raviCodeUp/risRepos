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

@Test(priority = 5)
public class ImagingMISTests extends Login {

	@Test(priority = 46,groups={"sanity","regression"})
	public void openImagingMISTest() throws IOException {
		try {
			Thread.sleep(2000);
			driver.findElement(By.linkText("Imaging MIS")).click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 47,groups={"sanity","regression"})
	public void defaultViewDateSearchTest() throws IOException {
		try {
			Thread.sleep(3000);
			/*String recordCount1 = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count: " + recordCount1);
			if (recordCount1.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false,
						"Failed: defaultViewDateSearchTest, Item count: "
								+ recordCount1);
			}*/

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 48,groups={"sanity","regression"})
	public void searchWithServiceCategoryServiceServiceStatusRoomDateTest() throws IOException {
		try {
			Thread.sleep(2000);
			WebElement scDdown1 = driver.findElement(By.name("ProcedureCategoryCode"));
			Select sc1 = new Select(scDdown1);
			sc1.selectByValue("8");
			Thread.sleep(2000);
			WebElement sDdown1 = driver.findElement(By.name("service_id"));
			Select s1 = new Select(sDdown1);
			s1.selectByValue("56");
			WebElement statusDdown1 = driver.findElement(By.name("serviceStatus"));
			Select status1 = new Select(statusDdown1);
			status1.selectByValue("REPORT_VERIFIED");
			WebElement roomddown = driver.findElement(By.name("Room"));
			Select roomno = new Select(roomddown);
			roomno.selectByVisibleText("1, Basement2, A Block, CGO");
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-imaging-mis/section/div/div/div/mat-card/mat-card-content[1]/div/div/form/div[2]/div/button[1]"))
					.click();
			Thread.sleep(3000);
			String recordCount1 = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count: " + recordCount1);
			if (recordCount1.equals("0 of 0")) {
				Assert.assertTrue(false,
						"Failed: searchWithServiceCategoryServiceServiceStatusRoomDateTest, Item count: "
								+ recordCount1);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 49,groups={"sanity","regression"})
	public void searchOnMISTableTest() throws IOException {
		try {
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\verifyreport.properties");
			properties.load(inputstream);
			String patientName = properties.getProperty("patientName");
			driver.findElement(By.className("mat-input-element")).sendKeys(patientName);
			Thread.sleep(4000);
			String recordCount1 = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count: " + recordCount1);
			if (recordCount1.equals("0 of 0")) {
				Assert.assertTrue(false,
						"Failed: searchOnMISTableTest, Item count: "
								+ recordCount1);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 50,groups={"sanity","regression"})
	public void validateMisReportDataTest() throws IOException {
		try {
			SoftAssert Assert = new SoftAssert();
			Thread.sleep(2000);
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\verifyreport.properties");
			properties.load(inputstream);
			String studyNumber = properties.getProperty("studyNumber");
			String registrationId = properties.getProperty("registrationId");
			String patientName = properties.getProperty("patientName");
			String scheduleDateTime = properties.getProperty("scheduleDateTime");
			String confirmationDateTime = properties.getProperty("confirmationDateTime");
			String reportCreationDateTime = properties.getProperty("reportCreationDateTime");
			String reportVerificationDateTime = properties.getProperty("reportVerificationDateTime");
			String orderDate = properties.getProperty("orderDate");
			String name1 = driver.findElement(By.xpath("//*[@id='printData']/table/tbody/tr/td[2]")).getText();
			String regid1 = driver.findElement(By.xpath("//*[@id='printData']/table/tbody/tr/td[1]")).getText();
			String ser1 = driver.findElement(By.xpath("//*[@id='printData']/table/tbody/tr/td[3]")).getText();
			String studyno1 = driver.findElement(By.xpath("//*[@id='printData']/table/tbody/tr/td[5]")).getText();
			String orderDate1 = driver.findElement(By.xpath("//*[@id='printData']/table/tbody/tr/td[7]")).getText();
			String scheduleDateTime1 = driver.findElement(By.xpath("//*[@id='printData']/table/tbody/tr/td[8]"))
					.getText();
			String confirmationDateTime1 = driver.findElement(By.xpath("//*[@id='printData']/table/tbody/tr/td[9]"))
					.getText();
			String reportCreationDateTime1 = driver.findElement(By.xpath("//*[@id='printData']/table/tbody/tr/td[10]"))
					.getText();
			String reportVerificationDateTime1 = driver
					.findElement(By.xpath("//*[@id='printData']/table/tbody/tr/td[11]")).getText();
			if (name1.equals(patientName))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: patience name is incorrect in mis report page as " + name1
						+ "Expected Name: " + patientName);
			if (regid1.equals(registrationId))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: registrationId is incorrect in mis report page as " + regid1
						+ "Expected regid: " + registrationId);
			if (ser1.equals("X-ray"))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: Service name is incorrect in mis report page as " + ser1
						+ "Expected Service:  X-ray ");
			if (studyno1.equals(studyNumber))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: studyNumber is incorrect in mis report page as " + studyno1
						+ "Expected studyNo: " + studyNumber);
			if (orderDate1.equals(orderDate))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: orderDate is incorrect in mis report page as:" + orderDate1
						+ "Expected orderDate:" + orderDate);
			if (scheduleDateTime1.equals(scheduleDateTime))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: scheduleDateTime is incorrect in mis report page as:"
						+ scheduleDateTime1 + "Expected scheduleDateTime:" + scheduleDateTime);
			if (confirmationDateTime1.equals(confirmationDateTime))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: confirmationDateTime is incorrect in mis report page as:"
						+ confirmationDateTime1 + "Expected confirmationDateTime:" + confirmationDateTime);
			if (reportCreationDateTime1.equals(reportCreationDateTime))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false, "Failed: reportCreationDateTime is incorrect in mis report page as:"
						+ reportCreationDateTime1 + "Expected reportCreationDateTime:" + reportCreationDateTime);
			if (reportVerificationDateTime1.equals(reportVerificationDateTime))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false,
						"Failed: reportVerificationDateTime is incorrect in mis report page as "
								+ reportVerificationDateTime1 + "Expected reportVerificationDateTime: "
								+ reportVerificationDateTime);
			String def = driver.findElement(By.xpath("//*[@id='printData']/table/thead/tr/th[6]/div/div[1]")).getText();
			if (def.equals("Room No")) {
			} else {
				Assert.assertTrue(false, "Failed: MISReport " + "Actual: " + def + " " + "Expected: Room No");
			}
			Assert.assertAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 51,groups={"sanity","regression"})
	public void printMISReportButtonTest() throws IOException {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/app-root/section/div/app-imaging-mis/section/div/div/div/mat-card/mat-card-title[2]/div/div[2]/button")).isEnabled();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
