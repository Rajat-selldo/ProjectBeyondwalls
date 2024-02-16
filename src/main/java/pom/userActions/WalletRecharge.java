package pom.userActions;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class WalletRecharge extends ReusableUtils {
	WebDriver driver;

	public WalletRecharge(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

//XPaths for wallet recharge functionalities 
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Projects')]")
	private WebElement clickonProjects;

	@FindBy(how = How.XPATH, using = "(//a[@id='dropdownMenuLink'])[1]")
	private WebElement clickonEllipsis;

//1. Recharge Wallet 
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Recharge Wallet')])[1]")
	private WebElement clickonRechargeWallet;

	@FindBy(how = How.XPATH, using = "((//form[@id='wallet_receipt_form']/div)[1]/div/div)[1]")
	private WebElement selectPaymentMode;
	// If Cheques mode selected, then following 4-fields XPaths are used
	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_issuing_bank']")
	private WebElement enterIssuingBank;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_issuing_bank_branch']")
	private WebElement enterBankBranch;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_payment_identifier']")
	private WebElement enterChequeNumber;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_issued_date']")
	private WebElement eneterIssuedDate;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_campaign_duration_from']")
	private WebElement enterCampaignFrom;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_campaign_duration_to']")
	private WebElement enterCampaignTo;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_sv_count']")
	private WebElement enterSvCount;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_sv_incentive_from_mobile']")
	private WebElement enterSvIncentive;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_spot_booking_count']")
	private WebElement enterSbCount;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_spot_booking_incentive']")
	private WebElement enterSbIncentive;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_every_booking_count']")
	private WebElement enterEverybcount;

	@FindBy(how = How.XPATH, using = "//input[@id='basic_receipt_wallet_receipt_every_booking_incentive']")
	private WebElement enterEverybIncentive;

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement clickOnSave;

//2. Transfer Wallet Balance 
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Transfer Wallet Balance')])[1]")
	private WebElement clickonTransferBalance;

	@FindBy(how = How.XPATH, using = "//input[@id='wallet_amount_to_transfer']")
	private WebElement enterAmount;

	@FindBy(how = How.XPATH, using = "//input[@id='wallet_project_id-selectized']")
	private WebElement clickonProjectDropdown;

//3. Edit incentives	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Edit Incentives')])[1]")
	private WebElement clickonEditIncetive;

	@FindBy(how = How.XPATH, using = "//input[@id='project_payment_adjustments_attributes_0_absolute_value']")
	private WebElement enterSvAbsoluteValue;

	@FindBy(how = How.XPATH, using = "//input[@id='project_payment_adjustments_attributes_0_formula']")
	private WebElement enterSvFormula;

	@FindBy(how = How.XPATH, using = "//input[@id='project_payment_adjustments_attributes_1_absolute_value']")
	private WebElement enterBookingAbsoluteValue;

	@FindBy(how = How.XPATH, using = "//input[@id='project_payment_adjustments_attributes_1_formula']")
	private WebElement enterBookingFormula;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Wallet']")
	private WebElement clickOnWallet;

	@FindBy(how = How.XPATH, using = "//input[@id='project_wallet_credit']")
	private WebElement enterWalletCreditamt;

//4. Edit Project	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Edit Project')])[1]")
	private WebElement clickOnEditProject;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Wallet Notification Settings']")
	private WebElement clickOnWalletNotifications;

	@FindBy(how = How.XPATH, using = "//input[@id='project_reminder_low_balance']")
	private WebElement enterLowBalanceLimit;

	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='true']") // use 'false' in value tag
	private WebElement selectInsuffucientBalance;

	@FindBy(how = How.CSS, using = "button[method='netbanking']")
	private WebElement selectNetbanking;

	@FindBy(how = How.XPATH, using = "//div[@class='mb-3']//div[starts-with(@class,'option')]")
	private List<WebElement> SelectPaymentMode;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Axis')]")
	private WebElement selectBank;

	@FindBy(how = How.XPATH, using = "button[id='redesign-v15-cta']")
	private WebElement clickOnPayNow;

//1. Recharge Wallet 
	public void clickonProjects() {
		waitUntilClickable(clickonProjects).click();
	}

	public void clickonEllipsis() {
		waitUntilClickable(clickonEllipsis).click();
	}

	public void clickonRechargeWallet() {
		waitUntilClickable(clickonRechargeWallet).click();
	}

	public void selectPaymentMode(String enterModeName) {
		waitUntilVisiblity(selectPaymentMode).click();
		waitUntilVisiblity(SelectPaymentMode.stream().filter(S -> S.getText().trim().equalsIgnoreCase(enterModeName))
				.findFirst().get()).click();
		wait(2000);
	}

	public void enterIssuingBank(String enterBankName) {
		waitUntilVisiblity(enterIssuingBank).sendKeys(enterBankName);
	}

	public void enterBankBranch(String enterBranchName) {
		waitUntilVisiblity(enterBankBranch).sendKeys(enterBranchName);
	}

	public void enterChequeNumber(String enterChequeNo) {
		waitUntilVisiblity(enterChequeNumber).sendKeys(enterChequeNo);
	}

	public void eneterIssuedDate(String enterIssuedate) {
		waitUntilVisiblity(eneterIssuedDate).sendKeys(enterIssuedate);
	}

	public void enterCampaignFrom(String enterCampaignStartDate) {
		waitUntilVisiblity(enterCampaignFrom).clear();
		wait(1000);
		waitUntilVisiblity(enterCampaignFrom).sendKeys(enterCampaignStartDate);
		wait(2000);
	}

	public void enterCampaignTo(String enterCampaignEndDate) {
		waitUntilVisiblity(enterCampaignTo).clear();
		wait(1000);
		waitUntilVisiblity(enterCampaignTo).sendKeys(enterCampaignEndDate);
		wait(2000);
	}

	public void enterSvCount(String enterSVCount) {
		waitUntilVisiblity(enterSvCount).sendKeys(enterSVCount);
	}

	public void enterSvIncentive(String enterSVIncetive) {
		waitUntilVisiblity(enterSvIncentive).sendKeys(enterSVIncetive);
	}

	public void enterSbCount(String enterSBCount) {
		waitUntilVisiblity(enterSbCount).sendKeys(enterSBCount);
	}

	public void enterSbIncentive(String enterSBIncetive) {
		waitUntilVisiblity(enterSbIncentive).sendKeys(enterSBIncetive);
	}

	public void enterEverybcount(String enterEvrybookingcount) {
		waitUntilVisiblity(enterEverybcount).sendKeys(enterEvrybookingcount);
	}

	public void enterEverybIncentive(String enterEvrybookingIncetive) {
		waitUntilVisiblity(enterEverybIncentive).sendKeys(enterEvrybookingIncetive);
	}

	public void clickOnSave() {
		waitUntilClickable(clickOnSave).click();
		wait(2000);
	}

	public void razorPayFlow() {
		wait(2000);
		// Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		// Iterate through each window handle
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().contains("Razorpay Checkout")) {
				// Perform actions in Razorpay window
				waitUntilClickable(selectNetbanking).click();
				wait(1000);
				waitUntilClickable(selectBank).click();
				wait(2000);
				waitUntilClickable(clickOnPayNow).click();
				wait(5000);
			}
		}
	}

//2. Transfer Wallet Balance
	public void clickonTransferBalance() {
		waitUntilClickable(clickonTransferBalance).click();
	}

	public void enterAmount(String enterTransferAmount) {
		waitUntilVisiblity(enterAmount).sendKeys(enterTransferAmount);
	}

	public void selectProject(String projectName) throws InterruptedException {
		waitUntilClickable(clickonProjectDropdown).sendKeys(projectName);
		wait(2000);
		clickonProjectDropdown.sendKeys(Keys.ENTER);
	}

//3. Edit incentives
	// Basic Details section
	public void clickonEditIncetive() {
		waitUntilClickable(clickonEditIncetive).click();
	}

	public void enterSvAbsoluteValue(String enterSVAbsoluteValue) {
		waitUntilVisiblity(enterSvAbsoluteValue).sendKeys(enterSVAbsoluteValue);
	}

	public void enterSvFormula(String enterSVFormula) {
		waitUntilVisiblity(enterSvFormula).sendKeys(enterSVFormula);
	}

	public void enterBookingAbsoluteValue(String enterBAbsoluteValue) {
		waitUntilVisiblity(enterBookingAbsoluteValue).sendKeys(enterBAbsoluteValue);
	}

	public void enterBookingFormula(String enterBFormula) {
		waitUntilVisiblity(enterBookingFormula).sendKeys(enterBFormula);
	}

	// Wallet
	public void clickOnWallet() {
		waitUntilClickable(clickOnWallet).click();
	}

	public void enterWalletCreditamt(String enterCreditAmount) {
		waitUntilVisiblity(enterWalletCreditamt).sendKeys(enterCreditAmount);
	}

//4. Edit Project	
	public void clickOnEditProject() {
		waitUntilClickable(clickOnEditProject).click();
	}

	public void clickOnWalletNotifications() {
		waitUntilClickable(clickOnWalletNotifications).click();
	}

	public void enterLowBalanceLimit(String enterLowBalance) {
		waitUntilVisiblity(enterLowBalanceLimit).sendKeys(enterLowBalance);
	}

	public void selectInsuffucientBalance() {
		waitUntilClickable(selectInsuffucientBalance).click();
	}

}
