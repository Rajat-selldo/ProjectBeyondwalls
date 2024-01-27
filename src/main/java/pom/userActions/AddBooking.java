package pom.userActions;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class AddBooking extends ReusableUtils {
	WebDriver driver;

	public AddBooking(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// PageFactory design pattern
	// Click on Walk-in section link to selection of add booking on first walk-in
	@FindBy(how = How.XPATH, using = "//a[text()='Walk-ins']")
	private WebElement clickonWalkinLink;

	@FindBy(how = How.XPATH, using = "(//a[@id='dropdownMenuLink'])[1]")
	private WebElement clickonEllipsis;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Add Booking')])[1]")
	private WebElement clickonAddBooking;

	@FindBy(how = How.XPATH, using = "//input[@id='booking_detail_project_tower_name']")
	private WebElement enterTowerName;

	@FindBy(how = How.XPATH, using = "//input[@id='booking_detail_booking_project_unit_name']")
	private WebElement enterUnitName;

	@FindBy(how = How.XPATH, using = "//input[@id='booking_detail_project_unit_configuration-selectized']")
	private WebElement enterUnitConfiguration;

	@FindBy(how = How.XPATH, using = "//input[@id='booking_detail_agreement_price']")
	private WebElement enterConsiderationValue;

// XPaths of Booked On and Tentative agreement date fields 
	@FindBy(how = How.XPATH, using = "//input[@id='booking_detail_booked_on']")
	private WebElement clickonBookedOn;

	@FindBy(how = How.XPATH, using = "//input[@id='booking_detail_agreement_date']") //#booking_detail_agreement_date
	private WebElement clickonTentativeAgreementDate;

	@FindBy(how = How.XPATH, using = "//input[@id='booking_detail_source-selectized']")
	private WebElement bookingSource;

	@FindBy(how = How.XPATH, using = "//input[@id='tagged_manager-selectized']")
	private WebElement managerSelection;

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement submitForm;
	
	@FindBy(how = How.CSS, using = "input[data-confirm='You won’t be able to edit it, Are you sure?']")
	private WebElement submitForm1;

	// After Booking is added, then document upload flow
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Documents')])[1]")
	private WebElement clickOnDocuments;
	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary fileupload']")
	private WebElement clickonUpload;


//Booking section implementation methods 
	public void clickonWalkins() {
		clickonWalkinLink.click();
	}

	public void openOptionsMenu() {
		clickonEllipsis.click();
	}

	public void clickonAddBooking() {
		clickonAddBooking.click();
		wait(2000);
	}

	public void enterTowerName(String towerName) {
		enterTowerName.sendKeys(towerName);
	}

	public void enterUnitName(String unitName) {
		enterUnitName.sendKeys(unitName);
	}

	public void enterUnitConfiguration(String bhk) throws InterruptedException {
		enterUnitConfiguration.sendKeys(bhk);
		Thread.sleep(1000);
		enterUnitConfiguration.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	public void enterConsiderationValue(String considerationValue) {
		enterConsiderationValue.sendKeys(considerationValue);
	}

// XPaths of Booked On and Tentative agreement date fields 
	public void clickonBookedOn(String bookedOnDate) {
		waitUntilClickable(clickonBookedOn).click();
		waitUntilVisiblity(clickonBookedOn).sendKeys(Keys.CLEAR);
		wait(2000);
		waitUntilVisiblity(clickonBookedOn).sendKeys(bookedOnDate);
		wait(2000);
		clickonBookedOn.sendKeys(Keys.ENTER);
	}

	public void clickonTentativeAgreementDate(String tentativeAgreementDate) {
		clickonTentativeAgreementDate.sendKeys(tentativeAgreementDate);
	}

	public void bookingSource(String sourceName) {
		waitUntilVisiblity(bookingSource).sendKeys(sourceName);
		wait(1000);
		bookingSource.sendKeys(Keys.ENTER);
		wait(1000);
	}

	public void managerSelection(String managerName) {
		managerSelection.sendKeys(managerName);
		wait(1000);
		managerSelection.sendKeys(Keys.ENTER);
	//	managerSelection.submit();
		wait(1000);
	}

	public void submitForm() throws AWTException, InterruptedException {
		waitUntilVisiblity(submitForm).click();
		wait(5000);
//		jsClick(submitForm);
	}

	public void handleConfirmationPopup() {
		wait(10000);
		driver.switchTo().alert().accept();
	}

//	//After Booking is added, then document upload flow 
//		public void uploadDocumentsonWalkin() {
//			waitUntilClickable(clickonEllipsis).click();
//			wait(1000);
//			waitUntilClickable(clickOnDocuments).click();
//			waitUntilClickable(clickonUpload).click();
//		}

}
