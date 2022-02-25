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

import OpenBrowsers.OpenBrowsers;

@Test(priority = 1)
public class ConfirmationTests extends OpenBrowsers {
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
	@Test(priority = 8)
	public void openMainMenuTest() throws IOException {
		try {
			Thread.sleep(4000);
			driver.findElement(By.className("openMainMenus")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 9)
	public void openImageCaptureAndConfirmationTest() throws IOException {
		try {
			Thread.sleep(2000);
			driver.findElement(By.linkText("Image Capture and Confirmation")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 10)
	public void searchWithDateTest() throws IOException {
		try {
			Thread.sleep(4000);
			System.out.println("Inside captureConfirmTest : Date Search Test Starts");
			String itemCounts = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count displayed: " + itemCounts);
			if (itemCounts.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false, "Failed: Date Search Test, Item count: " + itemCounts);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 11)
	public void searchWithServiceCategoryServiceAndDateTest() throws IOException {
		try {
			Thread.sleep(2000);
			System.out.println("Inside captureConfirmTest : Service & Date search Test");
			WebElement sCDdown = driver.findElement(By.name("service_category_code"));
			Select selectSc = new Select(sCDdown);
			selectSc.selectByValue("8");
			Thread.sleep(3000);
			WebElement sDdown = driver.findElement(By.xpath(
					"/html/body/app-root/section/div/app-image-capture-confirmation/section/div/div/div/mat-card/mat-card-content[1]/div/div/div/div/form/div[1]/div[2]/select"));
			Select selectS = new Select(sDdown);
			selectS.selectByValue("56");
			WebElement searchButton = driver.findElement(By.xpath(
					"/html/body/app-root/section/div/app-image-capture-confirmation/section/div/div/div/mat-card/mat-card-content[1]/div/div/div/div/form/div[2]/div/button[1]"));
			searchButton.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 12)
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

	@Test(priority = 13)
	public void SearchOnTableAndConfirmationTableDataTest() throws IOException {
		try {
			Thread.sleep(2000);
			Properties properties = new Properties();
			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\testdata.properties");
			properties.load(inputstream);
			String patientName = properties.getProperty("patientName");
			String orderDate = properties.getProperty("orderDate");
			System.out.println("patient name in file: " + patientName);
			driver.findElement(By.className("mat-input-element")).sendKeys(patientName);
			Thread.sleep(2000);
			String itemCounts1 = driver.findElement(By.className("mat-paginator-range-label")).getText();
			System.out.println("Record count displayed: " + itemCounts1);
			if (itemCounts1.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false, "Failed: Patient not found, Records: " + itemCounts1);
			} else {
				String patientName1 = driver
						.findElement(By
								.xpath("/html/body/app-root/section/div/app-image-capture-confirmation/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[2]"))
						.getText();
				String registrationId = driver
						.findElement(By
								.xpath("/html/body/app-root/section/div/app-image-capture-confirmation/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[1]"))
						.getText();
				String scheduleDateTime = driver
						.findElement(By
								.xpath("/html/body/app-root/section/div/app-image-capture-confirmation/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[3]"))
						.getText();
				System.out.println(registrationId + " " + scheduleDateTime);
				Properties properties1 = new Properties();
				FileOutputStream outputstream1 = new FileOutputStream(
						"C:\\Users\\ravik\\OneDrive\\Desktop\\eclipse data\\RaviQA\\workspace\\ris\\src\\test\\resources\\properties\\confirm.properties");
				properties1.setProperty("registrationId", registrationId);
				properties1.setProperty("patientName", patientName1);
				properties1.setProperty("scheduleDateTime", scheduleDateTime);
				properties1.setProperty("orderDate", orderDate);
				properties1.setProperty("studyNumber", "1234567890");
				properties1.store(outputstream1, null);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 14)
	public void inputStudyNumberTest() throws IOException {
		try {
			Thread.sleep(1000);
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-image-capture-confirmation/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[5]/input"))
					.sendKeys("1234567890");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 15)
	public void confirmButtonTest() throws IOException {
		try {
			Thread.sleep(1000);
			WebElement button=driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-image-capture-confirmation/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[6]/button"));
            button.isEnabled();
            button.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
