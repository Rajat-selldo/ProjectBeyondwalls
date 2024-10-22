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

public class FiltersonBrokerageListing extends ReusableUtils {
	WebDriver driver;

	public FiltersonBrokerageListing(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// XPaths for filters present on Brokerage page 	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Brokerages')]")
	private WebElement gotoBrokerages;
	
	@FindBy(how = How.XPATH, using = "//div[@class='filter-popup']")
	private WebElement clickonFilter;
		
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_raised_date']")
	private WebElement enterRaisedOn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_project_ids-selectized']")
	private WebElement selectProjectname2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_status-selectized']")
	private WebElement selectbyStatus;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_manager_id-selectized']")
	private WebElement selectChannelPartner;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_city-selectized']")
	private WebElement selectCity2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_region_ids_-selectized']")
	private WebElement selectRegion2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_channel_partner_id-selectized']")
	private WebElement selectPartnerCompany;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_from_mobile-selectized']")
	private WebElement selectFromMobile;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']")
	private WebElement applyFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_rera_verified-selectized']")
	private WebElement selectReraVerified;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_category-selectized']")
	private WebElement selectType;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_payment_status-selectized']")
	private WebElement selectPaymentStatus;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_team_id-selectized']")
	private WebElement selectTeam;
	
//Calendar Apply button XPaths 	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(), 'Apply')])[1]")
	private WebElement raisedOnApply;

	
		
	
// Methods 	
	public void gotoBrokerages() {
		waitUntilClickable(gotoBrokerages).click();
		wait(1000);
	}
	
	public void clickonFilter() {
		waitUntilClickable(clickonFilter).click();
	}
	
	public void selectProjectname2(String projectName2) {
		waitUntilVisiblity(selectProjectname2).sendKeys(projectName2);
		wait(1000);
		selectProjectname2.sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//h5[contains(text(), 'Filter')]")).click();
		wait(3000);
	}
	
	public void selectbyStatus(String enterStatus) {
		waitUntilVisiblity(selectbyStatus).sendKeys(enterStatus);
	}
	
	public void selectPaymentStatus(String paymentStatus) {
		waitUntilVisiblity(selectPaymentStatus).sendKeys(paymentStatus);
		wait(1000);
		selectPaymentStatus.sendKeys(Keys.ENTER);
	}
	
	public void selectChannelPartner(String selectCP) {
		waitUntilVisiblity(selectChannelPartner).sendKeys(selectCP);
		wait(1000);
		selectChannelPartner.sendKeys(Keys.ENTER);
	}
	
	public void selectCity2(String enterCityName2) {
		waitUntilVisiblity(selectCity2).sendKeys(enterCityName2);
	}
	
	public void selectRegion2(String enterRegionName2) {
		waitUntilVisiblity(selectRegion2).sendKeys(enterRegionName2);
	}
	
	public void selectPartnerCompany(String enterCompanyName) {
		waitUntilVisiblity(selectPartnerCompany).sendKeys(enterCompanyName);
	}
	
	public void enterRaisedOn(String enterRaisednDateRange) {
		waitUntilVisiblity(enterRaisedOn).sendKeys(enterRaisednDateRange);
		waitUntilClickable(raisedOnApply).click();
	}
	
	public void selectReraVerified(String selectbyReraVerified) {
		waitUntilVisiblity(selectReraVerified).sendKeys(selectbyReraVerified);
	}
	
	public void selectFromMobile(String selectbyMobile) {
		waitUntilVisiblity(selectFromMobile).sendKeys(selectbyMobile);
	}
	
	public void selectType(String enterType) {
		waitUntilVisiblity(selectType).sendKeys(enterType);
	}
	
	public void selectTeam(String enterTeamName) {
		waitUntilVisiblity(selectTeam).sendKeys(enterTeamName);
	}
	
	public void applyFilter() {
		jsClick(applyFilter);
		//waitUntilClickable(applyFilter).click();
		wait(5000);
	}
	

}
