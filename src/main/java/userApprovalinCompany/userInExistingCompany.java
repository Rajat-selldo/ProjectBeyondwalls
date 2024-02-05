package userApprovalinCompany;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class userInExistingCompany extends ReusableUtils {
	WebDriver driver;

	public userInExistingCompany(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Users Accounts')]")
	private WebElement goToUserAccounts;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'User Requests')]")
	private WebElement clickOnUserRequests;

	@FindBy(how = How.XPATH, using = "(//a[@id='dropdownMenuLink'])[1]")
	private WebElement clickonEllipsis;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Approve / Reject Request')]")
	private WebElement clickonapproveorreject;

	@FindBy(how = How.CSS, using = "input[id='user_user_status_in_company_event-selectized']")
	private WebElement approveorReject;

	@FindBy(how = How.XPATH, using = "(//input[@type='submit'])[2]")
	private WebElement clickOnSave;

//Methods 	
	public void goToUserAccounts() {
		waitUntilClickable(goToUserAccounts).click();
	}

	public void clickOnUserRequests() {
		waitUntilClickable(clickOnUserRequests).click();
	}

	public void clickonEllipsis() {
		waitUntilClickable(clickonEllipsis).click();
	}

	public void clickonapproveorreject() {
		waitUntilClickable(clickonapproveorreject).click();
	}

	public void approveorReject(String statusValue) {
		waitUntilVisiblity(approveorReject).sendKeys(statusValue);
		wait(1000);
		approveorReject.sendKeys(Keys.ENTER);
	}

	public void clickOnSave() {
		waitUntilClickable(clickOnSave).click();
		wait(2000);
	}

}
