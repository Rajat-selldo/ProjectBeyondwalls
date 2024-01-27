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

public class FiltersonWalkinsListing extends ReusableUtils {
	WebDriver driver;

	public FiltersonWalkinsListing(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// XPaths for filters present on Walk-in page 	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Walk-ins')]")
	private WebElement gotoWalkins;
	
	@FindBy(how = How.XPATH, using = "//div[@class='filter-popup']")
	private WebElement clickonFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_lead_id-selectized']")
	private WebElement enterNameEmailorPhone;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_project_ids-selectized']")
	private WebElement selectProjectname2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_status-selectized']")
	private WebElement selectbyStatus;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_approval_status-selectized']")
	private WebElement selectApprovalStatus;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_disputed-selectized']")
	private WebElement selectDisputed;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_site_visit_type-selectized']")
	private WebElement selectType;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_manager_id-selectized']")
	private WebElement selectChannelPartner;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_city-selectized']")
	private WebElement selectCity2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_region_ids_-selectized']")
	private WebElement selectRegion2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_bw_manager_id-selectized']")
	private WebElement selectRM;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_channel_partner_id-selectized']")
	private WebElement selectPartnerCompany;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_created_at']")
	private WebElement enterCreatedAtdate;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_scheduled_on']")
	private WebElement enterScheduledOndate;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_conducted_on']")
	private WebElement enterConductedOndate;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_incentive_generated-selectized']")
	private WebElement selectInvoiceGenerated;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_from_mobile-selectized']")
	private WebElement selectFromMobile;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_team_id-selectized']")
	private WebElement selectbyTeam;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']")
	private WebElement applyFilter;
//Calendar Apply button XPaths 	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(), 'Apply')])[1]")
	private WebElement createdAtApply;
	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(), 'Apply')])[2]")
	private WebElement scheduledOnApply;
	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(), 'Apply')])[3]")
	private WebElement conductedOnApply;
		
	
// Methods 	
	public void gotoWalkins() {
		waitUntilClickable(gotoWalkins).click();
	}
	
	public void clickonFilter() {
		waitUntilClickable(clickonFilter).click();
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
		
		//waitUntilVisiblity(enterNameEmailorPhone).sendKeys(nameoremailorphone);
		//enterNameEmailorPhone.sendKeys(Keys.ENTER);
	}
	
	public void selectProjectname2(String projectName2) {
		waitUntilVisiblity(selectProjectname2).sendKeys(projectName2);
		wait(1000);
		selectProjectname2.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//h5[contains(text(), 'Filter')]")).click();
		wait(3000);
	}
	
	public void selectbyStatus(String enterStatus) {
		waitUntilVisiblity(selectbyStatus).sendKeys(enterStatus);
	}
	
	public void selectApprovalStatus(String approvalStatus) {
		waitUntilVisiblity(selectApprovalStatus).sendKeys(approvalStatus);
		wait(1000);
		selectApprovalStatus.sendKeys(Keys.ENTER);
	}
	
	public void selectDisputed(String disputed) {
		waitUntilVisiblity(selectDisputed).sendKeys(disputed);
	}
	
	public void selectType(String svType) {
		waitUntilVisiblity(selectType).sendKeys(svType);
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
	
	public void enterCreatedAtdate(String enterCreatedDateRange) {
		waitUntilVisiblity(enterCreatedAtdate).sendKeys(enterCreatedDateRange);
		waitUntilClickable(createdAtApply).click();
	}
	
	public void enterScheduledOndate(String enterScheduledDateRange) {
		waitUntilVisiblity(enterScheduledOndate).sendKeys(enterScheduledDateRange);
		waitUntilClickable(scheduledOnApply).click();
	}
	
	public void enterConductedOndate(String enterConductedDateRange) {
		waitUntilVisiblity(enterConductedOndate).sendKeys(enterConductedDateRange);
		wait(2000);
		waitUntilClickable(conductedOnApply).click();
	}
	
	public void selectInvoiceGenerated(String selectbyInvoice) {
		waitUntilVisiblity(selectInvoiceGenerated).sendKeys(selectbyInvoice);
	}
	
	public void selectFromMobile(String selectbyMobile) {
		waitUntilVisiblity(selectFromMobile).sendKeys(selectbyMobile);
	}
	
	public void selectbyTeam(String enterTeamName) {
		waitUntilVisiblity(selectbyTeam).sendKeys(enterTeamName);
	}
	
	public void applyFilter() {
		waitUntilClickable(applyFilter).click();
		wait(5000);
	}
	

}
