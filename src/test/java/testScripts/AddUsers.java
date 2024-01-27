package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.UserCreation;

public class AddUsers extends BaseTest {
	
@Test
	public void logIn() throws InterruptedException {
		// Login Flow
				LoginPage userCreds = new LoginPage(driver);
				userCreds.clickonSignIn();
				userCreds.enterUserPhone("+919090909091");
				//Billing Team - 919157565554 
				//CPH - 916954535251
				//DSM - 919156555453
				//Admin - 919090909091 
				//CPO - 916200000001 
				//CP - 916200000002 
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

	@Test
	public void addUsers() throws InterruptedException {
		logIn();
		UserCreation addUser = new UserCreation(driver);
		addUser.clickonUserAccounts();
		addUser.clickonAddUser();
		addUser.listAllUsers("Add Channel Partner Head");
		addUser.enterFirstName("Bruce");
		addUser.enterLastName("Wayne");
		addUser.enterEmail("bruce.cph@mailinator.com");
		addUser.enterPhone("7800000011");
		addUser.selectCity("Bangalore");
		addUser.selectRegion("Basavanagudi");
		
	//Write a if else block for project selection method cause for some users field is not displayed on the form 	
		addUser.selectProject("Demo");
		

		addUser.clickonSave();

	}

}
