package risTestScripts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import OpenBrowsers.Login;

@Test(priority = 0)
public class ScheduleTests extends Login {

	public String patientName1;

	/*
	 * @Test(priority = 0) public void openRis() throws IOException {
	 * 
	 * try { OpenBrowsers.main(null);// open Browser login System.out.println(
	 * "inside openRis"); Thread.sleep(5000); driver.findElement( By.linkText(
	 * "Radiology Information System")).click(); } catch (InterruptedException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */
	@Test(priority = 0)
	public void openRis() throws IOException {

		try {
			// OpenBrowsers.main(null);// open Browser login
			System.out.println("inside openRis");
			Thread.sleep(5000);
			driver.findElement(By.linkText("Radiology Information System")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void searchWithDateNegativeTest() {
		try {
			Thread.sleep(3000);
			WebElement scheduleSearchButton = driver.findElement(By.id("searchid"));
			scheduleSearchButton.click();
			Thread.sleep(2000);
			String alertText = driver.findElement(By.id("toast-container")).getText();
			System.out.println("alertText = " + alertText);
			Assert.assertEquals(alertText, "Please Select Service!");

			// driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void searchWithServiceCategoryServiceDateTest() throws IOException {
		try {
			Thread.sleep(3000);
			System.out.println("Inside schedulingSearch : Service & Date Search Test begain");
			WebElement sCDdown = driver.findElement(By.name("service_category_code"));
			Select selectSc = new Select(sCDdown);
			selectSc.selectByValue("8");
			Thread.sleep(2000);
			WebElement sDdown = driver.findElement(By.name("service_code"));
			Select selectS = new Select(sDdown);
			selectS.selectByValue("56");
			WebElement scheduleSearchButton = driver.findElement(By.id("searchid"));
			scheduleSearchButton.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 3)
	public void searchResultsTest() throws IOException {
		try {
			Thread.sleep(3000);
			String itemCounts = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count displayed: " + itemCounts);
			if (itemCounts.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false, "Records count displayed: " + itemCounts);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void itemsPerPageTest() throws IOException {
		try {
			Thread.sleep(1000);
			String itemsPerPage = driver.findElement(By.xpath("//*[@id='mat-select-value-1']")).getText();
			System.out.println("items per page = " + itemsPerPage);
			Assert.assertEquals(itemsPerPage, "5");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void searchOnTableTest() throws IOException {
		String orderDate;
		String patientName;
		String serviceName;
		try {
			Thread.sleep(2000);
			orderDate = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/form/div/table/tbody/tr/td[1]"))
					.getText();
			System.out.println("orderDate :" + orderDate);
			patientName = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/form/div/table/tbody/tr/td[2]"))
					.getText();
			System.out.println("patientName :" + patientName);
			// search on table test
			driver.findElement(By.className("mat-input-element")).sendKeys(patientName);
			Thread.sleep(2000);
			serviceName = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/form/div/table/tbody/tr/td[3]"))
					.getText();
			System.out.println("serviceName :" + serviceName);
			Properties properties = new Properties();
			FileOutputStream outputstream = new FileOutputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\testdata.properties");
			properties.setProperty("patientName", patientName);
			properties.setProperty("orderDate", orderDate);
			properties.setProperty("serviceName", serviceName);
			properties.store(outputstream, null);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void inputRoomScheduledateTime() throws IOException {
		String scheduledDate;
		try {
			Thread.sleep(3000);
			SoftAssert Assert = new SoftAssert();
			System.out.println("Inside schedulingSearch : searchHeading Test begain");
			String searchHeading = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-title[1]/h4"))
					.getText();
			System.out.println("search Heading = " + searchHeading);
			Assert.assertEquals(searchHeading, "Search");
			// -------------------------------------
			System.out.println("Inside schedulingSearch : service Category Level Test begain");
			String serviceCategoryText = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-content[1]/div/div/div/div/form/div[1]/div[1]/label"))
					.getText();
			System.out.println("service Category Level = " + serviceCategoryText);
			Assert.assertEquals(serviceCategoryText, "Service Category");
			// -------------------------------------
			System.out.println("Inside schedulingSearch : service Level Test begain");
			String serviceText = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-content[1]/div/div/div/div/form/div[1]/div[2]/label"))
					.getText();
			System.out.println("service Level = " + serviceText);
			Assert.assertEquals(serviceText, "Service");
			// -------------------------------------
			System.out.println("Inside schedulingSearch : orderDate Level Test begain");
			String orderDateText = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-content[1]/div/div/div/div/form/div[1]/div[3]/label"))
					.getText();
			System.out.println("oderDate Level = " + orderDateText);
			Assert.assertEquals(orderDateText, "Order Date");
			// -------------------------------------
			System.out.println("Inside schedulingSearch : Search Button Text Test begain");
			WebElement searchButtonText = driver.findElement(By.id("searchid"));
			String sButtonText = searchButtonText.getText();
			System.out.println("searchButtonText = " + sButtonText);
			Assert.assertEquals(sButtonText, "Search");
			// -------------------------------------
			System.out.println("Inside schedulingSearch : Reset Button Text Test begain");
			WebElement resetButton = driver.findElement(By.xpath(
					"/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-content[1]/div/div/div/div/form/div[2]/div/button[2]"));
			String rButtonText = resetButton.getText();
			System.out.println("resetButtonText = " + rButtonText);
			Assert.assertEquals(rButtonText, "Reset");
			// -------------------------------------
			System.out.println("Inside schedulingSearch : Table Name Test begain");
			String tableName = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-title[2]/h4"))
					.getText();
			System.out.println("tableName = " + tableName);
			Assert.assertEquals(tableName, "Scheduling");
			// Scheduling table test start
			WebElement ddownroom = driver.findElement(By.name("procedurecatg"));
			Select select = new Select(ddownroom);
			select.selectByVisibleText("1, Basement2, A Block, CGO");
			// select schedule date from calender
			DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			Date scheduleDate = new Date();
			scheduledDate = dateFormat1.format(scheduleDate);
			System.out.println("scheduledDate :" + scheduledDate);
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			System.out.println("System Date :" + date1);
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/form/div/table/tbody/tr/td[5]/mat-form-field/div/div[1]/div[2]/mat-datepicker-toggle/button/span[1]"))
					.click();
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.className("mat-calendar-body-today"));
			element.click();
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-scheduling/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/form/div/table/tbody/tr[1]/td[6]/input"))
					.sendKeys("18:00");
			Assert.assertAll();
			// driver.quit();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void scheduleButtonTest() throws IOException {
		try {
			Thread.sleep(2000);
			WebElement button = driver.findElement(By.className("smallBtn"));
			Boolean a = button.isEnabled();
			if (a.equals(false)) {
				Assert.assertTrue(false, "Schedule button disabled ");
				driver.quit();
			} else {
				button.click();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
