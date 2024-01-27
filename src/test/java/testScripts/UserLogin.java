package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;

public class UserLogin extends BaseTest {
	
	@Test
	public void logIn() throws InterruptedException {
// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+916200000001");
		// Billing Team - 919157565554
		// CPH - 916954535251
		// DSM - 919156555453
		// Admin - 919090909091
		// CPO - 916200000001
		// CP - 916200000002
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");

		// Wait for the success message element to be visible
		WebElement successMessage = driver.findElement(By.xpath("//div[@class='noty-info ms-3']"));

		boolean isDisplayed = successMessage.isDisplayed();
		// Check if the success message is displayed
		if (isDisplayed) {
			System.out.println("Login successful! Success message is displayed.");
		} else {
			System.out.println("Login unsuccessful! Error message is displayed.");
		}

	}
	
	
	public void logOut() throws InterruptedException {
		logIn();
//Log out flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonProfile();
		userCreds.clickonSignout();
		System.out.println("User logged out successfully.");

	}

}
