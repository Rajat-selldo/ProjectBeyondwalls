package pom.userActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pom.beyondwalls.utility.ReusableUtils;

public class FiltersonBookingsListing extends ReusableUtils {
	WebDriver driver;

	public FiltersonBookingsListing(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// XPaths for filters present on Booking page 	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Bookings')]")
	private WebElement gotoBookings;

	@FindBy(how = How.XPATH, using = "//div[@class='filter-popup']")
	private WebElement clickonFilter;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_lead_id-selectized']")
	private WebElement enterNameEmailorPhone;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_id-selectized']")
	private WebElement enterBookingName;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_project_ids-selectized']")
	private WebElement selectProjectname2;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_status-selectized']")
	private WebElement selectbyStatus;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_approval_status-selectized']")
	private WebElement selectApprovalStatus;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_manager_id-selectized']")
	private WebElement selectChannelPartner;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_city-selectized']")
	private WebElement selectCity2;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_region_ids_-selectized']")
	private WebElement selectRegion2;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_cp_manager_id-selectized']")
	private WebElement selectRM;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_channel_partner_id-selectized']")
	private WebElement selectPartnerCompany;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_booked_on']")
	private WebElement enterBookedOndate;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_agreement_date']")
	private WebElement enterAgreementdate;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_incentive_generated-selectized']")
	private WebElement selectInvoiceGenerated;

	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_from_mobile-selectized']")
	private WebElement selectFromMobile;

	@FindBy(how = How.XPATH, using = "//input[@value='Apply']")
	private WebElement applyFilter;

//Calendar Apply button XPaths 	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(), 'Apply')])[1]")
	private WebElement bookedOnApply;

	@FindBy(how = How.XPATH, using = "(//button[contains(text(), 'Apply')])[2]")
	private WebElement AagreementDatepply;

// Methods 	
	public void gotoBookings() {
		waitUntilClickable(gotoBookings).click();
	}

	public void clickonFilter() {
		waitUntilClickable(clickonFilter).click();
		wait(1000);
	}

	public void enterNameEmailorPhone(String nameoremailorphone) {
		waitUntilClickable(enterNameEmailorPhone).click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//input[@id='fltrs_lead_id-selectized']/option"));
		for (WebElement option : allOptions) {
			if (option.getText().equals(nameoremailorphone)) {
				option.click();
				System.out.println("Checkpoint from if statement");
				break;
			}
		}

		// waitUntilVisiblity(enterNameEmailorPhone).sendKeys(nameoremailorphone);
		// enterNameEmailorPhone.sendKeys(Keys.ENTER);
	}

	public void selectProjectname2(String projectName2) {
		waitUntilVisiblity(selectProjectname2).sendKeys(projectName2);
		wait(1000);
		selectProjectname2.sendKeys(Keys.ENTER);
		// driver.findElement(By.xpath("//h5[contains(text(), 'Filter')]")).click();
		wait(1000);
	}

	public void selectbyStatus(String enterStatus) {
		waitUntilVisiblity(selectbyStatus).sendKeys(enterStatus);
	}

	public void selectApprovalStatus(String approvalStatus) {
		waitUntilVisiblity(selectApprovalStatus).sendKeys(approvalStatus);
		wait(1000);
		selectApprovalStatus.sendKeys(Keys.ENTER);
	}

	public void enterBookingName(String bookingName) {
		waitUntilVisiblity(enterBookingName).sendKeys(bookingName);
	}

	public void selectChannelPartner(String selectCP) {
		waitUntilVisiblity(selectChannelPartner).sendKeys(selectCP);
		wait(2000);
		selectChannelPartner.sendKeys(Keys.ENTER);
	}

	public void selectCity2(String enterCityName2) {
		waitUntilVisiblity(selectCity2).sendKeys(enterCityName2);
	}

	public void selectRegion2(String enterRegionName2) {
		waitUntilVisiblity(selectRegion2).sendKeys(enterRegionName2);
	}

	public void selectRM(String enterRMName) {
		waitUntilVisiblity(selectRM).sendKeys(enterRMName);
	}

	public void selectPartnerCompany(String enterCompanyName) {
		waitUntilVisiblity(selectPartnerCompany).sendKeys(enterCompanyName);
	}

	public void enterBookedOndate(String enterBookedOnDateRange) {
		waitUntilVisiblity(enterBookedOndate).sendKeys(enterBookedOnDateRange);
		waitUntilClickable(enterBookedOndate).click();
	}

	public void enterAgreementdate(String enterAgreementDateRange) {
		waitUntilVisiblity(enterAgreementdate).sendKeys(enterAgreementDateRange);
		waitUntilClickable(enterAgreementdate).click();
	}

	public void selectInvoiceGenerated(String selectbyInvoice) {
		waitUntilVisiblity(selectInvoiceGenerated).sendKeys(selectbyInvoice);
	}

	public void selectFromMobile(String selectbyMobile) {
		waitUntilVisiblity(selectFromMobile).sendKeys(selectbyMobile);
	}

	public void applyFilter() {
		waitUntilClickable(applyFilter).click();
		wait(3000);
	}

	
	// Function to print numbers displayed on the web-page
	public static void printNumbers(WebDriver driver, By locator) {
		// Find all elements matching the XPath
		for (WebElement element : driver.findElements(locator)) {
			// Get the text of each element and print it
			String text = element.getText();
			System.out.println("Number displayed: " + text);
		}
	}

	// Find elements using XPath 
	public void printTheCount() {
		By xpathLocator = By.xpath("(//div//p[contains(text(), 'Displaying Bookings')]//b[contains(text(), '')])[2]");
		wait(1000);
		printNumbers(driver, xpathLocator);
		wait(3000);
	}

}
