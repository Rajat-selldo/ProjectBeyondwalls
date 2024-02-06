package pom.userActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class LoginPage extends ReusableUtils {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// PageFactory design pattern
	// sign-in button x-path
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Sign in')])[1]")
	private WebElement clickonSignIn;

//Login with Phone
	@FindBy(how = How.XPATH, using = "//input[@id='user_login_phone']")
	private WebElement userPhone;
	@FindBy(how = How.XPATH, using = "//input[@value='Get OTP']")
	private WebElement clickonGetOtp;
	@FindBy(how = How.XPATH, using = "//input[@id='user_login_otp']")
	private WebElement userOTP;
	@FindBy(how = How.XPATH, using = "//input[@value='Verify your Account']")
	private WebElement clickonOtp;

//Login with Email 
	@FindBy(how = How.ID, using = "userEmail")
	private WebElement userEmail;
	@FindBy(how = How.ID, using = "userPassword")
	private WebElement userPassword;
	@FindBy(how = How.ID, using = "loginButton")
	private WebElement loginButton;

//Log Out Flow
	@FindBy(how = How.XPATH, using = "//a[@id='navbarDropdown']")
	private WebElement clickonProfile;
	@FindBy(how = How.XPATH, using = "//a[@href='/users/sign_out?locale=en']")
	private WebElement clickonSignout;

//Implementation of pageFactory elements 
	// Click on Sign-in button
	public void clickonSignIn() {
		waitUntilClickable(clickonSignIn).click();
	}

//Login with Phone 
	public void enterUserPhone(String phone) {
		waitUntilClickable(userPhone).click();
		waitUntilVisiblity(userPhone).sendKeys(phone);
	}

	public void clickonGetOtp() {
		moveToElementClick(clickonGetOtp);
		wait(2000);
	}

	public void enterUserOtp(String Otp) {
		waitUntilVisiblity(userOTP).sendKeys(Otp);
	}

	public void clickonverify() {
		waitUntilClickable(clickonOtp).click();
	}

//Login with Email 
	public void enterUserEmail(String email) {
		waitUntilVisiblity(userEmail).sendKeys(email);
	}

	public void enterUserPassword(String password) {
		waitUntilVisiblity(userPassword).sendKeys(password);
	}

	public void loginButton() {
		waitUntilClickable(loginButton).click();
		wait(5000);
	}

//Logout Flow 
	public void clickonProfile() {
		waitUntilClickable(clickonProfile).click();
	}

	public void clickonSignout() {
		waitUntilClickable(clickonSignout).click();
	}

	public void logIn(String phone) {
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone(phone);
		// Billing Team - 919157565554
		// CPH - 916954535251
		// DSM - 919156555453
		// Admin - 919090909091
		// CPO - 916200000001 (JoyBoy)
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

}
