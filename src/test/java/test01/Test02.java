package test01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;

public class Test02 extends BaseTest {

	@Test
	public void m2() throws InterruptedException {

		driver.findElement(By.xpath("//a[@class='green-btn sign-in-button alt-btn']")).click();

		// Login page with OTP
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='user_login_phone']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).clear();
		driver.findElement(By.xpath("//input[@id='user_login_phone']")).sendKeys("1100000001");
		driver.findElement(By.xpath("//input[@value='Get OTP']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='user_login_otp']")).sendKeys("000000");
		driver.findElement(By.xpath("//input[@value='Verify your Account']")).click();

		Thread.sleep(10000);

//Walkin 
		driver.findElement(By.xpath("//a[@href='/admin/site_visits?locale=en']")).click();
		driver.findElement(By.xpath("//a[@href='/admin/leads/new?locale=en&walkin=true']")).click();

		// Walk-in Calendar
		// driver.findElement(By.xpath("(//table[@class='table-condensed'])[1]"));
		List<WebElement> dateElements = driver
				.findElements(By.xpath("//div[@class='datepicker-days']//td[@data-action='selectDay']"));
		System.out.println("Dates in the Calendar");
		for (WebElement date : dateElements) {
			System.out.println(date.getText());
		}

// Calendar flow with Actions Method
		WebElement walkinCalendar = driver
				.findElement(By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']"));

		// Get today's date and the desired date to select
		LocalDate currentDate = LocalDate.now();
		LocalDate desiredDate = LocalDate.of(2023, 12, 05);

		// Format the desired date to match the calendar's format (if needed)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		String desiredDateStr = desiredDate.format(formatter);

		// Perform actions to move the cursor to the desired date
		Actions actions = new Actions(driver);

		walkinCalendar.click();
		
		WebElement currentDateElement = driver.findElement(By.xpath("//td[@class='day active today']"));
		while (!currentDateElement.getText().equals(desiredDateStr)) {
			WebElement nextButton = driver.findElement(By.xpath("//td[@class='day active today']"));
		//	Next = nextButton.sendKeys(Keys.ARROW_RIGHT);
            actions.moveToElement(nextButton).click().perform();

            // Update the current date element after navigating
            currentDateElement = driver.findElement(By.xpath("//td[contains(@class, 'today')]/a")); 
        }
		
		
		
//		// Login page with Email & Password
//		driver.findElement(By.xpath("//a[text()=\"Login with password instead\"]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("test@mail.com");
//		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("pass");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
//		Thread.sleep(3000);
//
//		WebElement errmsg = driver.findElement(By.xpath("//p[@class='theme-txt-color fn-14 mb-0']"));
//		boolean isDisplayed = errmsg.isDisplayed();
//
//		if (isDisplayed) {
//			System.out.println("Error message is displayed.");
//		} else {
//			System.out.println("Error message is not displayed.");
//		}

	}

}
