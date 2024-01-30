package pom.userActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pom.beyondwalls.utility.ReusableUtils;

public class Cpregistration extends ReusableUtils {
	WebDriver driver;

	public Cpregistration(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory design pattern
//From login page 	
//	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Register as Channel Partner')]")
//	private WebElement clickonRegister1;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Register Now')])[1]")
	private WebElement clickonRegister;

	@FindBy(how = How.XPATH, using = "//input[@id='user_first_name']")
	private WebElement entercpFirstName;

	@FindBy(how = How.XPATH, using = "//input[@id='user_last_name']")
	private WebElement entercpLastName;

	@FindBy(how = How.XPATH, using = "//input[@id='user_phone']")
	private WebElement entercpPhone;

	@FindBy(how = How.XPATH, using = "//input[@id='user_email']")
	private WebElement entercpEmail;

	@FindBy(how = How.XPATH, using = "//input[@id='user_referral_code']")
	private WebElement entercpReferralCode;

	@FindBy(how = How.XPATH, using = "//input[@value='Register']")
	private WebElement submitForm;

//CPONBOARDING FLOW with Existing Company 
//	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Sign in')])[1]")
//	private WebElement clickonSignin;

	@FindBy(how = How.XPATH, using = "//div[@class='selectize-input items required invalid not-full']")
	private WebElement clickoncompanyName;
	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_id-selectized']")
	private WebElement clickoncompanyName1;

	@FindBy(how = How.XPATH, using = "//input[@value='Proceed']")
	private WebElement clickonProceed;

//CPONBOARDING FLOW with New Company 
	@FindBy(how = How.XPATH, using = "//div[@class='step-inner']//p[contains(text(), 'Register a New Company')]")
	private WebElement clickonRegisterNewCompany;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_company_name']")
	private WebElement entercpCompanyName;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_pan_number']")
	private WebElement enterPanNumber;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_rera_id']")
	private WebElement enterReraid;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_company_owner_name']")
	private WebElement enterOwnerName;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_company_owner_phone']")
	private WebElement enterOwnerPhone;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_team_size-selectized']")
	private WebElement selectTeamSize;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_average_quarterly_business']")
	private WebElement enteravgbusiness;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_city-selectized']")
	private WebElement selectCity;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_region_ids-selectized']")
	private WebElement selectRegion;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_manager_id-selectized']")
	private WebElement selectManager;

	@FindBy(how = How.CSS, using = "input[name='commit']")
	private WebElement clickonSave;

//Company Details Form 	
	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_expertise-selectized']")
	private WebElement selectFirmExpertise;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_gstin_number']")
	private WebElement enterGstNumber;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_experience-selectized']")
	private WebElement selectExperience;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_developers_worked_for-selectized']")
	private WebElement selectDevelopers;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_interested_services-selectized']")
	private WebElement selectServices;

//Bank Details 
	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_bank_detail_attributes_name']")
	private WebElement enterBankName;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_bank_detail_attributes_branch']")
	private WebElement enterBranchName;

	@FindBy(how = How.XPATH, using = "//select[@id='channel_partner_bank_detail_attributes_account_type']")
	private WebElement selectAccountType;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_bank_detail_attributes_ifsc_code']")
	private WebElement enterIfscCode;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_bank_detail_attributes_account_holder_name']")
	private WebElement enterAccHolderName;

	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_bank_detail_attributes_account_number']")
	private WebElement enterAccountNumber;
	// Add save button method after above x-path

//Upload Documents 
	@FindBy(how = How.XPATH, using = "(//div[contains(text(), 'PAN Card')])[1]")
	private WebElement clickonDropdown;

	@FindBy(how = How.XPATH, using = "//input[@name='files[]']")	//input[name='files[]']
	private WebElement clickonUpload; 

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Submit Application')]")
	private WebElement submitApplication;

//Complete Registration pop-up 
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Complete Registration')]")
	private WebElement clickonConfirmation;

	// Temporary used in LocalFileUploadClass
	@FindBy(how = How.XPATH, using = "//input[@type='file']")
	private WebElement uploads; // XPath = //span[contains(text(), 'Upload')] CSS 2 =
								// input.btn.btn-primary.fileupload

//Methods to be implementing XPaths 	
	public void clickonRegister() {
		waitUntilClickable(clickonRegister).click();
		wait(2000);
	}

	public void cpFirstName(String cpfirstName) {
		waitUntilVisiblity(entercpFirstName).sendKeys(cpfirstName);
	}

	public void cpLastName(String cplastName) {
		waitUntilVisiblity(entercpLastName).sendKeys(cplastName);
	}

	public String cpPhone(String cpphoneNumber) {
		waitUntilVisiblity(entercpPhone).sendKeys(cpphoneNumber);
		return cpphoneNumber;
	}

	public void cpEmail(String cpemailId) {
		waitUntilVisiblity(entercpEmail).sendKeys(cpemailId);
	}

	public void cpReferralCode(String referralCode) {
		waitUntilVisiblity(entercpReferralCode).sendKeys(referralCode);
	}

	public void submitForm() {
		waitUntilClickable(submitForm).click();
		wait(2000);
	}

	public void validatingSuccessMsg() {
		WebElement successMsg = driver.findElement(By.xpath("//p[@class='theme-txt-color fn-14 mb-0']"));
		boolean isDisplayed = successMsg.isDisplayed();

		if (isDisplayed) {
			System.out.println("Success message is displayed.");
		} else {
			System.out.println("Success message is not displayed.");
		}
	}

//CPONBOARDING FLOW with Existing Company 
	public void clickoncompanyName(String cpFirmName) {
		wait(1000);
		jsClick(clickoncompanyName1);
		clickoncompanyName1.sendKeys(cpFirmName);
		wait(1000);
		clickoncompanyName1.sendKeys(Keys.ENTER);
		wait(1000);
	}

	public void clickonProceed() {
		scrollIntoView(clickonProceed);
		jsClick(clickonProceed);
		wait(2000);
	}

//CPONBOARDING FLOW with New Company 
	public void clickonRegisterNewCompany() {
		jsClick(clickonRegisterNewCompany);
	}

	public void entercpCompanyName(String cpFirmName) {
		waitUntilVisiblity(entercpCompanyName).sendKeys(cpFirmName);
	}

	public void enterPanNumber(String cpPanNumber) {
		waitUntilVisiblity(enterPanNumber).sendKeys(cpPanNumber);
	}

	public void enterReraid(String cpReraId) {
		waitUntilVisiblity(enterReraid).sendKeys(cpReraId);
	}

	public void enterOwnerName(String ownerName) {
		waitUntilVisiblity(enterOwnerName).sendKeys(ownerName);
	}

	public void enterOwnerPhone(String ownerPhone) {
		waitUntilVisiblity(enterOwnerPhone).sendKeys(ownerPhone);
	}

	public void selectTeamSize(String teamSize) {
		waitUntilVisiblity(selectTeamSize).sendKeys(teamSize);
		wait(1000);
		selectTeamSize.sendKeys(Keys.ENTER);
	}

	public void enteravgbusiness(String avgbusinessamt) {
		waitUntilVisiblity(enteravgbusiness).sendKeys(avgbusinessamt);
	}

	public void selectCity(String cityName) {
		waitUntilVisiblity(selectCity).sendKeys(cityName);
		wait(1000);
		selectCity.sendKeys(Keys.ENTER);
		wait(1000);
	}

	public void selectRegion(String regionName) {
		waitUntilVisiblity(selectRegion).sendKeys(regionName);
		wait(1000);
		selectRegion.sendKeys(Keys.ENTER);
	}

	public void selectManager(String managerName) {
		waitUntilVisiblity(selectManager).sendKeys(managerName);
		wait(1000);
		selectManager.sendKeys(Keys.ENTER);
	}

	public void clickonSave() {
		scrollIntoView(clickonSave);
		jsClick(clickonSave);
		wait(2000);
	}

//Company Details Form 
	public void selectFirmExpertise(String expertise) {
		waitUntilVisiblity(selectFirmExpertise).sendKeys(expertise);
		wait(1000);
		selectFirmExpertise.sendKeys(Keys.ENTER);
	}

	public void enterGstNumber(String gstNumber) {
		waitUntilVisiblity(enterGstNumber).sendKeys(gstNumber);
	}

	public void selectExperience(String experience) {
		waitUntilVisiblity(selectExperience).sendKeys(experience);
		wait(1000);
		selectExperience.sendKeys(Keys.ENTER);
	}

	public void selectDevelopers(String developers) {
		waitUntilVisiblity(selectDevelopers).sendKeys(developers);
		wait(1000);
		selectDevelopers.sendKeys(Keys.ENTER);
	}

	public void selectServices(String services) {
		waitUntilVisiblity(selectServices).sendKeys(services);
		wait(1000);
		selectServices.sendKeys(Keys.ENTER);
	}

//Bank Details 
	public void enterBankName(String bankName) {
		waitUntilVisiblity(enterBankName).sendKeys(bankName);
	}

	public void enterBranchName(String branchName) {
		waitUntilVisiblity(enterBranchName).sendKeys(branchName);
	}

	public void selectAccountType(String accountType) {
		Select s1 = new Select(selectAccountType);
		s1.selectByVisibleText(accountType);
		wait(1000);
		// waitUntilVisiblity(selectAccountType).sendKeys(accountType);
	}

	public void enterIfscCode(String ifscCode) {
		waitUntilVisiblity(enterIfscCode).sendKeys(ifscCode);
	}

	public void enterAccHolderName(String accountName) {
		waitUntilVisiblity(enterAccHolderName).sendKeys(accountName);
	}

	public void enterAccountNumber(String accountNumber) {
		waitUntilVisiblity(enterAccountNumber).sendKeys(accountNumber);
	}

//Upload Documents 
	public void clickonDropdown() {
		waitUntilClickable(clickonDropdown).click();
	}

	public void clickonUpload() {
		wait(5000);
		scrollIntoView(clickonUpload);
		wait(2000);
		waitUntilVisiblity(clickonUpload).sendKeys(System.getProperty("user.dir") + "\\com.beyondwalls\\Test Documents\\bld2.jpg");
		wait(2000);
		driver.navigate().refresh();
		wait(3000);
	}

	public void uploads() {
		wait(5000);
		uploads.sendKeys("D:\\rajat\\Test Files\\bld2.jpg");
		wait(5000);
	}

	public void submitApplication() {
		wait(2000);
		waitUntilVisiblity(submitApplication).click();
		wait(2000);
	}

	public void clickonConfirmation() {
		waitUntilClickable(clickonConfirmation).click();
		wait(2000);
	}

}
