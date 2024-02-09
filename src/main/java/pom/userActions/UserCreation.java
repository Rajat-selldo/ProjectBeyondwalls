package pom.userActions;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class UserCreation extends ReusableUtils {
	WebDriver driver;

	public UserCreation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//User Creation Flow 
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Users Accounts')]")
	private WebElement clickonUserAccounts;

	@FindBy(how = How.XPATH, using = "(//button[@role='button'])[1]")
	private WebElement clickonAddUser;

	@FindBy(how = How.XPATH, using = "//a[@class='modal-remote-form-link dropdown-item']")
	private List<WebElement> listAllUsers;

	@FindBy(how = How.XPATH, using = "//input[@id='user_first_name']")
	private WebElement enterFirstName;

	@FindBy(how = How.XPATH, using = "//input[@id='user_last_name']")
	private WebElement enterLastName;

	@FindBy(how = How.XPATH, using = "//input[@id='user_email']")
	private WebElement enterEmail;

	@FindBy(how = How.XPATH, using = "//input[@id='user_phone']")
	private WebElement enterPhone;

	@FindBy(how = How.XPATH, using = "//input[@id='user_city-selectized']")
	private WebElement selectCity;

	@FindBy(how = How.XPATH, using = "//input[@id='user_region_ids-selectized']")
	private WebElement selectRegion;

	@FindBy(how = How.CSS, using = "input[id='user_project_ids-selectized']")
	private WebElement selectProject;

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement clickonSave;

//Methods to implement XPaths 
	public void clickonUserAccounts() {
		waitUntilClickable(clickonUserAccounts).click();
	}

	public void clickonAddUser() {
		waitUntilClickable(clickonAddUser).click();
	}

	public void listAllUsers(String userRole) {
		// Printing the list of users
		System.out.println("List of Users:");
		for (WebElement user : listAllUsers) {
			System.out.println(user.getText());
		}
		// Iterate through the user list
		for (WebElement user : listAllUsers) {
			if (user.getText().trim().equals(userRole)) {
				// Click on the user if found
				user.click();
				wait(2000);
				break;
			}
		}
	}

	public void enterFirstName(String userFirstName) {
		waitUntilVisiblity(enterFirstName).sendKeys(userFirstName);
	}

	public void enterLastName(String userLastName) {
		waitUntilVisiblity(enterLastName).sendKeys(userLastName);
	}

	public void enterEmail(String userEmail) {
		waitUntilVisiblity(enterEmail).sendKeys(userEmail);
	}

	public void enterPhone(String userPhone) {
		waitUntilVisiblity(enterPhone).sendKeys(userPhone);
	}

	public void selectCity(String cityName) {
		waitUntilClickable(selectCity).click();
		waitUntilVisiblity(selectCity).sendKeys(cityName);
		wait(2000);
		selectCity.sendKeys(Keys.ENTER);
	}

	public void selectRegion(String regionName) {
		waitUntilClickable(selectRegion).click();
		waitUntilVisiblity(selectRegion).sendKeys(regionName);
		wait(2000);
		selectRegion.sendKeys(Keys.ENTER);
		selectRegion.sendKeys(Keys.ENTER);
		selectRegion.sendKeys(Keys.ENTER);
	}

	public void selectProject(String projectName) {
		try {
			// Check if the project field is displayed
			if (selectProject.isDisplayed()) {
				// If project field is displayed, select a project
				waitUntilClickable(selectProject).click();
				waitUntilVisiblity(selectProject).sendKeys(projectName);
				wait(2000);
				selectProject.sendKeys(Keys.ENTER);
			} else {
				// If project field is not displayed, skip selecting project
				System.out.println("Project field is not displayed. Skipping project selection.");
			}
		} catch (NoSuchElementException e) {
			// If project field web element is not found, skip this method
			System.out.println("Project field web element is not found. Skipping method.");
		}
	}

	public void clickonSave() {
		waitUntilClickable(clickonSave).click();
		wait(2000);
	}

}
