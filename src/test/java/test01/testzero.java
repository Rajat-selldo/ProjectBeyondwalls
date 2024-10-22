package test01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testzero {

	static WebDriver driver;

	@Test
	public void m3() throws InterruptedException {

//		WebDriverManager.chromedriver().setup();
	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://lpmobile.iris1.selldoapp.com/");

		// login flow
		driver.findElement(By.xpath("//a[@class='green-btn sign-in-button alt-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).clear();
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).sendKeys("+911234590001");
		driver.findElement(By.xpath("//input[@value='Get OTP']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='user_login_otp']")).sendKeys("000000");
		driver.findElement(By.xpath("//input[@value='Verify your Account']")).click();
		Thread.sleep(2000);

		// add booking
		driver.findElement(By.xpath("//a[@href='/admin/site_visits?locale=en']")).click();
		driver.findElement(By.xpath(
				"//a[@href='/admin/booking_details/new_booking_without_inventory?lead_id=652783c562d4a743b3710d9c&locale=en&project_id=61376d92b686e76b3325ef3c&site_visit_id=652783c562d4a743b3710d9e']"))
				.click();

		WebElement projecttowername = driver.findElement(By.xpath("//input[@id='booking_detail_project_tower_name']"));
		projecttowername.sendKeys("Tower QA");
		WebElement projectunitname = driver
				.findElement(By.xpath("//input[@id='booking_detail_booking_project_unit_name']"));
		projectunitname.sendKeys("QA 101");
		WebElement unitconfig = driver
				.findElement(By.xpath("//input[@id='booking_detail_project_unit_configuration-selectized']"));
		unitconfig.sendKeys("BHK");
		Thread.sleep(1000);
		unitconfig.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement considvalue = driver.findElement(By.xpath("//input[@id='booking_detail_agreement_price']"));
		considvalue.sendKeys("5500000");

		// Booked On date-picker
		datetimepicker(driver, "05/11/2023");
		Thread.sleep(2000);
		datetimepicker1(driver, "12/12/2023");
		Thread.sleep(2000);

		WebElement source = driver.findElement(By.xpath("//input[@id='booking_detail_source-selectized']"));
		source.sendKeys("Channel Partner");
		source.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		WebElement cp = driver.findElement(By.xpath("//input[@id='tagged_manager-selectized']"));
		cp.sendKeys("Rajat");
		cp.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

//		driver.findElement(By.xpath("//div[@class='datepicker col-md-6']")).click();
//		new WebdriverWait(driver, Duration(5));

	}

	public static void datetimepicker(WebDriver driver, String str1) {
		driver.findElement(By.xpath("//input[@id='booking_detail_booked_on']")).click();
		WebElement datetime = driver.findElement(By.xpath("//input[@id='booking_detail_booked_on']"));
		datetime.click();
		System.out.println("checkpoint 2 - datepicker method");

	}

	public static void datetimepicker1(WebDriver driver, String str2) {
		driver.findElement(By.xpath("//input[@id='booking_detail_agreement_date']")).click();
		WebElement datetime = driver.findElement(By.xpath("//input[@id='booking_detail_agreement_date']"));
		datetime.click();
		System.out.println("checkpoint 3 - datepicker method1");

	}
}
