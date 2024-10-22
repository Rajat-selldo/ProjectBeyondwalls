package pom.userActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class ActionsFromCph extends ReusableUtils {
	WebDriver driver;

	public ActionsFromCph(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//PageFactory design pattern 
	// Click on Walk-in section link
	@FindBy(how = How.XPATH, using = "//a[text()='Walk-ins']")
	private WebElement clickonWalkinLink;

	@FindBy(how = How.XPATH, using = "(//a[@id='dropdownMenuLink'])[1]")
	private WebElement clickonEllipsis;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Walk-in Details')])[1]")
	private WebElement walkindetails;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'BW Approve')])[1]")
	private WebElement bwapprove;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'BW Reject')])[1]")
	private WebElement bwreject;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Brokerages')])[1]")
	private WebElement brokerages;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Documents')])[1]")
	private WebElement documents;

	// Click on Booking section link
	@FindBy(how = How.XPATH, using = "//a[text()='Bookings']")
	private WebElement goToBookings;

	@FindBy(how = How.XPATH, using = "(//a[@id='dropdownMenuLink'])[1]")
	private WebElement clickonbookingEllipsis;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Booking Details')]")
	private WebElement clickonBookingDetails;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Edit Booking')]")
	private WebElement clickonEditEditBooking;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'BW Approve')]")
	private WebElement bwApproveBooking;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'BW Reject')]")
	private WebElement bwRejectBooking;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Move to Booked Confirmed')]")
	private WebElement moveToConfirmed;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Documents')]")
	private WebElement clickOnDocuments;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Brokerages')]")
	private WebElement clickOnBrokerages;

//Walk-ins 	
	public void clickonWalkinLink() {
		waitUntilClickable(clickonWalkinLink).click();
	}

	public void clickonEllipsis() {
		waitUntilClickable(clickonEllipsis).click();
	}

	public void walkindetails() {
		waitUntilClickable(walkindetails).click();
		wait(2000);
	}

	public void bwapprove() {
		waitUntilClickable(bwapprove).click();
		wait(2000);
	}

	public void bwreject() {
		waitUntilClickable(bwreject).click();
		wait(2000);
	}

	public void brokerages() {
		waitUntilClickable(brokerages).click();
		wait(2000);
	}

	public void documents() {
		waitUntilClickable(documents).click();
		wait(2000);
	}

//Bookings 	
	public void goToBookings() {
		waitUntilClickable(goToBookings).click();
	}

	public void clickonbookingEllipsis() {
		waitUntilClickable(clickonbookingEllipsis).click();
	}

	public void clickonBookingDetails() {
		waitUntilClickable(clickonBookingDetails).click();
		wait(2000);
	}

	public void clickonEditEditBooking() {
		waitUntilClickable(clickonEditEditBooking).click();
		wait(2000);
	}

	public void bwApproveBooking() {
		waitUntilClickable(bwApproveBooking).click();
		wait(2000);
	}

	public void bwRejectBooking() {
		waitUntilClickable(bwRejectBooking).click();
		wait(2000);
	}

	public void moveToConfirmed() {
		waitUntilClickable(moveToConfirmed).click();
		wait(2000);
	}

	public void clickOnDocuments() {
		waitUntilClickable(clickOnDocuments).click();
		wait(2000);
	}

	public void clickOnBrokerages() {
		waitUntilClickable(clickOnBrokerages).click();
		wait(2000);
	}

}
