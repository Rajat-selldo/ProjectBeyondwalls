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

public class addBrokerageScheme extends ReusableUtils {
	WebDriver driver;

	public addBrokerageScheme(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@id='dropdownMenuLeft3']")
	private WebElement clickOnMore;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Brokerage Schemes')])[1]")
	private WebElement clickonBrokerageSchemes;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Brokerage Scheme')]")
	private WebElement clickonAddScheme;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_name']")
	private WebElement enterSchemeName;

	@FindBy(how = How.XPATH, using = "(//div[@class='note-editable card-block'])[1]")
	private WebElement enterDescription;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_city-selectized']")
	private WebElement enterCityName;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_project_ids-selectized']")
	private WebElement enterProjectName;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_starts_on']")
	private WebElement schemeStartsOn;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_ends_on']")
	private WebElement schemeEndsOn;

	@FindBy(how = How.XPATH, using = "(//div[contains(text(), 'Booking')])[1]")
	private WebElement selectResource;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_booking_type_all']")
	private WebElement selectWalkinTypeasAll;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_booking_type_spot']")
	private WebElement selectSpotBookingType;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_booking_type_non_spot']")
	private WebElement selectEveryBookingType;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_booking_type_all']")
	private WebElement selectBookingTypeasAll;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_category-selectized']")
	private WebElement selectCategory;

	@FindBy(how = How.XPATH, using = "(//div[@class='note-editable card-block'])[2]")
	private WebElement enterTermsNConditions;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_ladders_attributes_0_start_value']")
	private WebElement enterLadderStartValue;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_ladders_attributes_0_end_value']")
	private WebElement enterLadderEndValue;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_ladders_attributes_0_payment_adjustment_attributes_absolute_value']")
	private WebElement enterLadderAbsValue;

	@FindBy(how = How.XPATH, using = "//input[@id='incentive_scheme_ladders_attributes_0_payment_adjustment_attributes_formula']")
	private WebElement enterLadderFormula;

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement clickOnSave;

//Methods 	
	public void clickOnMore() {
		waitUntilClickable(clickOnMore).click();
	}

	public void clickonBrokerageSchemes() {
		waitUntilClickable(clickonBrokerageSchemes).click();
		wait(1000);
	}

	public void clickonAddScheme() {
		waitUntilClickable(clickonAddScheme).click();
	}

	public void enterSchemeName(String schemeName) {
		waitUntilVisiblity(enterSchemeName).sendKeys(schemeName);
	}

	public void enterDescription(String description) {
		waitUntilVisiblity(enterDescription).sendKeys(description);
	}

	public void enterCityName(String cityName2) {
		waitUntilVisiblity(enterCityName).sendKeys(cityName2);
	}

	public void enterProjectName(String projectName2) {
		waitUntilVisiblity(enterProjectName).sendKeys(projectName2);
	}

	public void schemeStartsOn(String schemeStartDate) {
		waitUntilVisiblity(schemeStartsOn).sendKeys(schemeStartDate);
		schemeStartsOn.sendKeys(Keys.ENTER);
		wait(1000);
	}

	public void schemeEndsOn(String schemeEndDate) {
		waitUntilVisiblity(schemeEndsOn).sendKeys(schemeEndDate);
		schemeStartsOn.sendKeys(Keys.ENTER);
		wait(1000);
	}

	
	@FindBy(how = How.XPATH, using = "//select[@id='incentive_scheme_resource_class']")
	private WebElement dropdownElement;
	public void selectResource(String selectResourceValue) {
//		scrollIntoView(selectResource);
//		wait(1000);
//		selectResource.sendKeys(selectResourceValue);
		
		wait(1000);
		Select dropdown = new Select(dropdownElement);
		WebElement selectedOption = dropdown.getFirstSelectedOption();
        System.out.println("Selected option: " + selectedOption.getText());
		dropdown.selectByIndex(1);
		
//		waitUntilClickable(selectResource).click();
//		wait(1000);
//		waitUntilVisiblity(selectResource).sendKeys(Keys.CLEAR);
//		wait(2000);
//		driver.findElements(By.xpath("//div[@class='option']")).stream()
//				.filter(S -> S.getText().equalsIgnoreCase(selectResourceValue)).findFirst().get().click();
		wait(3000);
	}

	public void selectWalkinType() {
		scrollIntoView(selectWalkinTypeasAll);
		wait(1000);
		waitUntilClickable(selectWalkinTypeasAll).click();
	}

	public void selectSpotBookingType() {
		scrollIntoView(selectSpotBookingType);
		wait(1000);
		waitUntilClickable(selectSpotBookingType).click();
	}

	public void selectEveryBookingType() {
		scrollIntoView(selectEveryBookingType);
		wait(1000);
		waitUntilClickable(selectEveryBookingType).click();
	}

	public void selectBookingTypeasAll() {
		scrollIntoView(selectBookingTypeasAll);
		wait(1000);
		waitUntilClickable(selectBookingTypeasAll).click();
	}

	public void selectCategory(String selectCategory2) {
		scrollIntoView(selectCategory);
		waitUntilVisiblity(selectCategory).sendKeys(selectCategory2);
		wait(1000);
		selectCategory.sendKeys(Keys.ENTER);
	}

	public void enterTermsNConditions(String entertermsAndConditions) {
		scrollIntoView(enterTermsNConditions);
		waitUntilVisiblity(enterTermsNConditions).sendKeys(entertermsAndConditions);
	}

	public void enterLadderStartValue(String enterLadderFirstValue) {
		scrollIntoView(enterLadderStartValue);
		waitUntilVisiblity(enterLadderStartValue).sendKeys(enterLadderFirstValue);
	}

	public void enterLadderEndValue(String enterLadderLastValue) {
		waitUntilVisiblity(enterLadderEndValue).sendKeys(enterLadderLastValue);
	}

	public void enterLadderAbsValue(String enterAbsoluteValue) {
		waitUntilVisiblity(enterLadderAbsValue).sendKeys(enterAbsoluteValue);
	}

	public void enterLadderFormula(String enterFormula) {
		waitUntilVisiblity(enterLadderFormula).sendKeys(enterFormula);
	}

	public void clickOnSave() {
		waitUntilClickable(clickOnSave).click();
	}

}
