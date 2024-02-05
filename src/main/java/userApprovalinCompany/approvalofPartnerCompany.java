package userApprovalinCompany;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class approvalofPartnerCompany extends ReusableUtils {
	WebDriver driver;

	public approvalofPartnerCompany(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Partner Companies')]")
	private WebElement clickPartnerCompanies;
	
	@FindBy(how = How.XPATH, using = "(//a[@id='dropdownMenuLink'])[4]")
	private WebElement clickonEllipsis;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Edit Partner Company')])[4]")
	private WebElement clickonEditpc;

	@FindBy(how = How.CSS, using = "#channel_partner_event-selectized")
	private WebElement enterApplicationStatus;

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement clickonSave;

	
//Methods 	
	public void clickPartnerCompanies() {
		scrollIntoView(clickPartnerCompanies);
		waitUntilClickable(clickPartnerCompanies).click();
	}
	
	public void clickonEllipsis() {
		scrollIntoView(clickonEllipsis);
		waitUntilClickable(clickonEllipsis).click();
	}

	public void clickonEditpc() {
		waitUntilClickable(clickonEditpc).click();
	}

	public void enterApplicationStatus(String applicationStatus) {
		scrollIntoView(enterApplicationStatus);
		wait(1000);
		waitUntilVisiblity(enterApplicationStatus).sendKeys(applicationStatus);
		wait(1000);
		enterApplicationStatus.sendKeys(Keys.ENTER);
		wait(1000);
	}

	public void clickonSave() {
		waitUntilClickable(clickonSave).click();
	}

}
