package pom.userActions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddWalkin extends ReusableUtils {
	WebDriver driver;

	public AddWalkin(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//PageFactory design pattern 
	// Click on Walk-in section link
	@FindBy(how = How.XPATH, using = "//a[text()='Walk-ins']")
	private WebElement clickonWalkinLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Add Walk-in']")
	private WebElement clickonAddWalkin;
	@FindBy(how = How.XPATH, using = "//input[@id='lead_first_name']")
	private WebElement enterFirstName;
	@FindBy(how = How.XPATH, using = "//input[@id='lead_last_name']")
	private WebElement enterLastName;
	@FindBy(how = How.XPATH, using = "//input[@id='lead_email']")
	private WebElement enterWalkinEmail;
	@FindBy(how = How.CSS, using = "#lead_phone")
	private WebElement enterWalkinPhone;

	@FindBy(how = How.XPATH, using = "(//a[@id='dropdownMenuLink'])[1]")
	private WebElement clickonEllipsis;

//Project drop-down XPaths but not used in this code 
	@FindBy(how = How.XPATH, using = "//*[@id=\"add-new-lead-form\"]/div[3]/div/div/div/div[1]")
	private WebElement clickonProjectDropdown;
//	@FindBy(how = How.XPATH, using = "//div[@class='selectize-input items required has-options invalid not-full focus input-active dropdown-active']")
//	private WebElement clickonActiveDropdown;
//	@FindBy(how = How.XPATH, using = "//div[@class='selectize-input items required has-options invalid not-full']")
//	private WebElement enterProjectName;

//Project Date Time Picker in calendar 
	@FindBy(how = How.XPATH, using = "(//table[@class=\"table-condensed\"])[1]//td[@data-action=\"selectDay\"]")
	private List<WebElement> selectDate;
	@FindBy(how = How.XPATH, using = "(//table[@class='table-condensed'])[2]//span[@data-action='selectMonth']")
	private List<WebElement> selectMonth;
	@FindBy(how = How.XPATH, using = "(//table[@class=\"table-condensed\"])[3]//span[@data-action=\"selectYear\"]")
	private List<WebElement> selectYear;
	@FindBy(how = How.XPATH, using = "(//th[@title='Select Month'])[1]")
	private WebElement clickonMonth;
	@FindBy(how = How.XPATH, using = "(//th[@title='Select Year'])[1]")
	private WebElement clickonYear;

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement clickonSave;

//After walk-in is added, then mark as conducted and document upload flow 
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Mark Conducted')])[1]")
	private WebElement markAsConducted;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Documents')])[1]")
	private WebElement clickOnDocuments;
	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary fileupload']")
	// Xpath2- //span[contains(text(), 'Upload')]
	// Xpath3- //div[contains(@class, 'btn btn-primary')]
	private WebElement clickonUpload;

	@FindBy(how = How.XPATH, using = "//input[@id='user_login_phone']")
	private WebElement backSpace;

//Add Walk-in Process from Project Listing page 
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Projects')]")
	private WebElement clickonProjects;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'ADD')]")
	private WebElement clickOnAdd;

//Walk-in section implementation methods 
	public void goToWalkins() {
		waitUntilClickable(clickonWalkinLink).click();
	}

	public void clickonAddWalkin() {
		waitUntilClickable(clickonAddWalkin).click();
	}

	public void enterFirstName(String firstName) {
		waitUntilVisiblity(enterFirstName).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		waitUntilVisiblity(enterLastName).sendKeys(lastName);
	}

	public void enterWalkinEmail(String walkinEmail) {
		waitUntilVisiblity(enterWalkinEmail).sendKeys(walkinEmail);
	}

	public void enterWalkinPhone(String walkinPhone) {
		waitUntilClickable(enterWalkinPhone).click();
		waitUntilVisiblity(enterWalkinPhone).sendKeys(walkinPhone);
	}

//Project selection drop-down 
	public void selectProject(String projectName) throws InterruptedException {
		waitUntilClickable(clickonProjectDropdown).click();
		driver.findElements(By.xpath("//div[@class='option']")).stream()
				.filter(S -> S.getText().equalsIgnoreCase(projectName)).findFirst().get().click();
	}

// X-path used in following method - //div[@data-default-date='04/12/2023 ']//td[@data-day="12/05/2023"] 
	public void datePicker(String date, String time) {
		String parts[] = date.split("/");
		String day = parts[0];
		String month = parts[1];
		String year = parts[2];
		String currentDate = new SimpleDateFormat("dd").format(new Date().getTime() + (0 * (1000 * 60 * 60 * 24)));
		String currentMonth=new SimpleDateFormat("MM").format(new Date().getTime() + (0 * (1000 * 60 * 60 * 24)));
		int month_int = Integer.parseInt(month.replaceAll("[0]", ""));
		String todaysDate = "" + currentDate + "/" + currentMonth + "/" + getDate(0, "Y");
//			String todaysDate = "" + "05" + "/" + getDate(0, "M") + "/" + getDate(0, "Y");
		String todaysDate2 = "" + currentMonth + "/" + day + "/" + getDate(0, "Y"); //getDate(0, "M")
		driver.findElement(By.xpath("//div[@data-default-date='" + todaysDate + " ']//th[@title='Select Month']"))
				.click();
		scrollIntoView(driver.findElement(By.xpath("//div[@data-default-date='" + todaysDate + " ']")));
		wait(1000);
		driver.findElement(By.xpath("//div[@data-default-date='" + todaysDate + " ']//th[@title='Select Year']"))
				.click();
		wait(1000);
		driver.findElements(
				By.xpath("//div[@data-default-date='" + todaysDate + " ']//span[@data-action='selectYear']")).stream()
				.filter(S -> S.getText().equalsIgnoreCase(year)).findFirst().get().click();
		wait(1000);
		driver.findElements(
				By.xpath("//div[@data-default-date='" + todaysDate + " ']//span[@data-action='selectMonth']"))
				.get(month_int - 1).click();
		wait(1000);
		driver.findElement(
				By.xpath("//div[@data-default-date='" + todaysDate + " ']//td[@data-day='" + todaysDate2 + "']"))
				.click();
		wait(1000);
		//Time-Picker 
		driver.findElement(By.xpath("(//span[@class=\"timepicker-hour\"])[1]")).click();
		wait(1000);
		driver.findElements(By.xpath("//div[@data-default-date='" + todaysDate + " ']//td[@class='hour']")).stream()
				.filter(S -> S.getText().equalsIgnoreCase(time.split(":")[0])).findFirst().get().click();
		wait(1000);
		driver.findElement(By.xpath("(//span[@class='timepicker-minute'])[1]")).click();
		wait(1000);
		driver.findElements(By.xpath("//div[@data-default-date='" + todaysDate + " ']//td[@class='minute']")).stream()
				.filter(S -> S.getText().equalsIgnoreCase(time.split(":")[1])).findFirst().get().click();

		// Add if-else statement for selection of AM/PM on basis of time selection
		driver.findElement(By.xpath("(//button[@title='Toggle Period'])[1]")).click();

		wait(1000);

	}
	

	public void clickonSave() {
		waitUntilClickable(clickonSave).click();
		wait(5000);
	}

	// After walk-in is added, then mark as conducted and document upload flow
	public void markAsConducted() {
		waitUntilClickable(clickonEllipsis).click();
		wait(1000);
		waitUntilClickable(markAsConducted).click();
	}

	public void uploadDocumentsonWalkin() throws IOException {
		waitUntilClickable(clickonEllipsis).click();
		wait(1000);
		waitUntilClickable(clickOnDocuments).click();
		waitUntilClickable(clickonUpload).click();
		wait(2000);
		Cpregistration cpreg = new Cpregistration(driver);
		cpreg.uploads();
		wait(5000);
		// File upload method used with AutoIT tool
		Desktop.getDesktop().open(new File(System.getProperty("user.dir") + "//AutoIT//walkinDocUpload3_x64.exe"));

	}

//Add Walk-in from Project Listing page 
	public void clickonProjects() {
		waitUntilClickable(clickonProjects).click();
	}

	public void clickOnAdd() {
		waitUntilClickable(clickOnAdd).click();
	}

}
