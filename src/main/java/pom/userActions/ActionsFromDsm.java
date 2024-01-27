package pom.userActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class ActionsFromDsm extends ReusableUtils {

	WebDriver driver;

	public ActionsFromDsm(WebDriver driver) {
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
	private WebElement clickonWalkinDetails;
	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Approve')])[1]")
	private WebElement approveWalkin;
	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Reject')])[1]")
	private WebElement rejectWalkin;
	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Documents')])[1]")
	private WebElement clickonwalkinDocuments;
	
//Click on Booking section link 
	@FindBy(how = How.XPATH, using = "//a[text()='Bookings']")
	private WebElement goToBookings;
	
	@FindBy(how = How.XPATH, using = "(//a[@id='dropdownMenuLink'])[1]")
	private WebElement clickonbookingEllipsis;
	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Booking Details')])[1]")
	private WebElement clickonBookingDetails;
	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Approve')])[1]")
	private WebElement approveBooking; 
	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Reject')])[1]")
	private WebElement rejectBooking;
	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Documents')])[1]")
	private WebElement clickOnbookingDocuments; 
	
	
//Walk-in section implementation methods 
		public void goToWalkins() {
			waitUntilClickable(clickonWalkinLink).click();
		}
		
		public void clickonEllipsis() {
			waitUntilClickable(clickonEllipsis).click();
			wait(1000);
		}
		
		public void clickonWalkinDetails() {
			waitUntilClickable(clickonWalkinDetails).click();
			wait(2000);
		}
		
		public void approveWalkin() {
			waitUntilClickable(approveWalkin).click();
		}
		
		public void rejectWalkin() {
			waitUntilClickable(rejectWalkin).click();
		}
		
		public void clickonwalkinDocuments() {
			waitUntilClickable(clickonwalkinDocuments).click();
		}
		
		
	//	While implementing below flow, first add method to click on Booking module 
//Booking section implementation methods 
		public void goToBookings() {
			waitUntilClickable(goToBookings).click();
		}
		
		public void clickonbookingEllipsis() {
			waitUntilClickable(clickonbookingEllipsis).click();
			wait(1000);
		}
		
		public void clickonBookingDetails() {
			waitUntilClickable(clickonBookingDetails).click();
			wait(2000);
		}
		
		public void approveBooking() {
			waitUntilClickable(approveBooking).click();
			wait(2000);
		}
		
		public void rejectBooking() {
			waitUntilClickable(rejectBooking).click();
			wait(2000);
		}
		
		public void clickOnbookingDocuments() {
			waitUntilClickable(clickOnbookingDocuments).click();
			wait(2000);
		}


}
