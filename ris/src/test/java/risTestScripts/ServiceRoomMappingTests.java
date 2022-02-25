package risTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import OpenBrowsers.OpenBrowsers;

@Test(priority = 0)
public class ServiceRoomMappingTests extends OpenBrowsers {
/*	@Test(priority = 0)
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
	@Test(priority = 52)
	public void openServiceRoomMappingTest() throws IOException {

		try {
			//Thread.sleep(3000);
			//driver.findElement(By.className("openMainMenus")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Service Room Mapping")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 53)
	public void defaultViewTest() throws IOException {

		try {
			Thread.sleep(3000);
			String recordcountdefault = driver.findElement(By.className("mat-paginator-range-label")).getText();
			if (recordcountdefault.equals("0 of 0")) {
				Assert.assertTrue(false, "Failed: defaultViewTest, Item count: " + recordcountdefault);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 54)
	public void addNewRoomButtonTest() throws IOException {

		try {
			Thread.sleep(1000);
			WebElement b=driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-test-vs-room-mapping/section/div/div/div/mat-card/mat-card-title[2]/div/div[2]/button"));
			Boolean a = b.isEnabled();
			if (a.equals(true)) {
				b.click();
			} else {
				Assert.assertTrue(false, "Failed: addNewRoomButton not enable , Returns " + a);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 55)
	public void addNewRoomTest() throws IOException {

		try {
			Thread.sleep(2000);
			WebElement scDdown1 = driver.findElement(By.name("service_category_id"));
			Select sc1 = new Select(scDdown1);
			sc1.selectByValue("8");
			WebElement roomDdown1 = driver.findElement(By.name("room_id"));
			Select sc2 = new Select(roomDdown1);
			sc2.selectByVisibleText("1, Basement2, A Block, CGO");
			driver.findElement(By.name("number_of_test")).sendKeys("5");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='sideLayoutWrapper']/div/app-add-new-room/div[2]/form/div[2]/button"))
					.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 56)
	public void searchRoomMappingTest() throws IOException {

		try {
			Thread.sleep(2000);
			// Update Room
			WebElement scDdown = driver.findElement(By.name("serviceCategoryId"));
			Select sc = new Select(scDdown);
			sc.selectByValue("8");
			WebElement roomDdown = driver.findElement(By.name("roomId"));
			Select scc = new Select(roomDdown);
			scc.selectByVisibleText("1, Basement2, A Block, CGO");
			driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-test-vs-room-mapping/section/div/div/div/mat-card/mat-card-content[1]/div/div/form/div[2]/div/button[1]"))
					.click();
			Thread.sleep(2000);
			String recordcount = driver.findElement(By.className("mat-paginator-range-label")).getText();
			if (recordcount.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false, "Failed: serviceRoomMappingTest , Item count: " + recordcount);
				
			} 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 57)
	public void searchOnServiceRoomMappingTableTest() throws IOException {

		try {
			driver.findElement(By.className("mat-input-element")).sendKeys("1, Basement2, A Block, CGO");
			Thread.sleep(2000);
			String recordcount = driver.findElement(By.className("mat-paginator-range-label")).getText();
			if (recordcount.equals("0 of 0")) {
				driver.quit();
				Assert.assertTrue(false, "Failed: searchOnServiceRoomMappingTableTest , Item count: " + recordcount);
				
			} 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 58)
	public void validateMappingTableDataTest() throws IOException {

		try {
			SoftAssert Assert = new SoftAssert();
			Thread.sleep(2000);
			String serviceCategory = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-test-vs-room-mapping/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[1]"))
					.getText();
			String room = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-test-vs-room-mapping/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[2]"))
					.getText();
			String limit = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-test-vs-room-mapping/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[3]"))
					.getText();
			if (serviceCategory.equals("RADIOLOGY")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false, "Failed: serviceRoomTableTest, serviceCategory: " + serviceCategory
						+ " Expected: RADIOLOGY");
			}
			if (room.equals("1, Basement2, A Block, CGO")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false,
						"Failed: serviceRoomTableTest, room: " + room + " Expected: 1, Basement2, A Block, CGO");
			}
			if (limit.equals("5")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false, "Failed: serviceRoomTableTest, limit: " + limit + " Expected: 5");
			}
			Assert.assertAll();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 59)
	public void updateButtonTest() throws IOException {

		try {
			Thread.sleep(1000);
			WebElement b=driver.findElement(By
					.xpath("/html/body/app-root/section/div/app-test-vs-room-mapping/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[4]/button"));
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
	@Test(priority = 60)
	public void updateMappingTest() throws IOException {

		try {
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//*[@id='sideLayoutWrapper']/div/app-add-new-room/div[2]/form/div[1]/div[3]/input"))
					.sendKeys("9");
			driver.findElement(
					By.xpath("//*[@id='sideLayoutWrapper']/div/app-add-new-room/div[2]/form/div[2]/button"))
					.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 61)
	public void validateUpdatedMappingTest() throws IOException {

		try {
			Thread.sleep(3000);
			String limitupdated = driver
					.findElement(By
							.xpath("/html/body/app-root/section/div/app-test-vs-room-mapping/section/div/div/div/mat-card/mat-card-content[2]/div/div/div/div[2]/table/tbody/tr/td[3]"))
					.getText();
			if (limitupdated.equals("59")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false,
						"Failed: validateUpdatedMappingTest, updated limit: " + limitupdated + " Expected: 59");
			}
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
