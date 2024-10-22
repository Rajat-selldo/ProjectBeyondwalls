package pom.userActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class AddProject extends ReusableUtils {
	WebDriver driver;

	public AddProject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

//Project addition Flow 
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Projects')]")
	private WebElement clickonProjects;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Project')]")
	private WebElement clickonAddProject;

//Basic details form 	
	@FindBy(how = How.XPATH, using = "//input[@id='project_name']")
	private WebElement enterProjectName;
	@FindBy(how = How.XPATH, using = "//input[@id='project_developer_name']")
	private WebElement enterDeveloperName;
	@FindBy(how = How.XPATH, using = "//input[@id='project_project_type-selectized']")
	private WebElement selectProjectType;
	@FindBy(how = How.XPATH, using = "//input[@id='project_category-selectized']")
	private WebElement selectCategory;
	@FindBy(how = How.XPATH, using = "//input[@id='project_project_segment-selectized']")
	private WebElement selectSegments;
	@FindBy(how = How.XPATH, using = "//input[@id='project_micro_market']")
	private WebElement enterLocation;
	@FindBy(how = How.XPATH, using = "//input[@id='project_city-selectized']")
	private WebElement selectCity;
	@FindBy(how = How.XPATH, using = "//input[@id='project_region_id-selectized']")
	private WebElement selectRegion;
	@FindBy(how = How.XPATH, using = "//input[@id='project_possession']")
	private WebElement clickonPossesionDate;
	@FindBy(how = How.XPATH, using = "//input[@id='project_launched_on']")
	private WebElement clickonLaunchDate;
	@FindBy(how = How.XPATH, using = "//input[@id='project_registration_name']")
	private WebElement enterRegistrationName;
	@FindBy(how = How.XPATH, using = "//input[@id='project_rera_registration_no']")
	private WebElement enterReraNumber;
	@FindBy(how = How.XPATH, using = "//input[@id='project_is_active_true']")
	private WebElement selectActiveProject;
	@FindBy(how = How.XPATH, using = "//input[@id='project_configurations']")
	private WebElement enterConfigurations;
	@FindBy(how = How.XPATH, using = "//input[@id='project_project_size']")
	private WebElement enterTotalLand;
	@FindBy(how = How.XPATH, using = "//input[@id='project_total_buildings']")
	private WebElement enterOngoingTowers;
	@FindBy(how = How.XPATH, using = "//input[@id='project_total_units']")
	private WebElement enterProjectunits;
	@FindBy(how = How.XPATH, using = "//input[@id='project_amenities-selectized']")
	private WebElement selectAmenities;
	@FindBy(how = How.XPATH, using = "//input[@id='project_approved_banks-selectized']")
	private WebElement selectBanks;
	@FindBy(how = How.XPATH, using = "//input[@id='project_gst_number']")
	private WebElement enterGstNumber;
	@FindBy(how = How.XPATH, using = "//input[@id='project_cin_number']")
	private WebElement enterCinNumber;
	@FindBy(how = How.XPATH, using = "//input[@id='project_price_starting_from']")
	private WebElement enterProjectStartsFrom;
	@FindBy(how = How.XPATH, using = "//input[@id='project_price_upto']")
	private WebElement enterProjectPriceUpto;
	//Project Address 
	@FindBy(how = How.XPATH, using = "//input[@id='project_addresses_attributes_0_address1']")
	private WebElement enterFlatno;
	@FindBy(how = How.XPATH, using = "//input[@id='project_addresses_attributes_0_address2']")
	private WebElement enterStreetName;
	@FindBy(how = How.XPATH, using = "//input[@id='project_addresses_attributes_0_country']")
	private WebElement enterCountry;
	@FindBy(how = How.XPATH, using = "//input[@id='project_addresses_attributes_0_state']")
	private WebElement enterState;
	@FindBy(how = How.XPATH, using = "//input[@id='project_addresses_attributes_0_city-selectized']")
	private WebElement selectProjectCity;
	@FindBy(how = How.XPATH, using = "//input[@id='project_addresses_attributes_0_zip']")
	private WebElement enterProjectPinCode;
	@FindBy(how = How.XPATH, using = "//input[@id='project_website_link']")
	private WebElement projectWebsiteLink;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement clickonSave;
	
	
//Methods for implementing project addition locators 
	public void clickonProjects() {
		waitUntilClickable(clickonProjects).click();
	}
	
	public void clickonAddProject() {
		waitUntilClickable(clickonAddProject).click();
	}
	
	public void enterProjectName(String projectName) {
		waitUntilVisiblity(enterProjectName).sendKeys(projectName);
	}
	
	public void enterDeveloperName(String developerName) {
		waitUntilVisiblity(enterDeveloperName).sendKeys(developerName);
	}
	
	public void selectProjectType(String projectType) {
		wait(1000);
		waitUntilClickable(selectProjectType).sendKeys(Keys.BACK_SPACE);
		waitUntilClickable(selectProjectType).sendKeys(Keys.BACK_SPACE);
		wait(1000);
		waitUntilVisiblity(selectProjectType).sendKeys(projectType);
		wait(2000);
		selectProjectType.sendKeys(Keys.ENTER);
	}
	
	public void selectCategory(String category) {
		waitUntilClickable(selectCategory).sendKeys(Keys.BACK_SPACE);
		waitUntilClickable(selectCategory).sendKeys(Keys.BACK_SPACE);
		wait(1000);
		waitUntilVisiblity(selectCategory).sendKeys(category);
		wait(2000);
		selectCategory.sendKeys(Keys.ENTER);
	}
	
	public void selectSegments(String segments) {
		waitUntilClickable(selectSegments).sendKeys(Keys.BACK_SPACE);
		waitUntilClickable(selectSegments).sendKeys(Keys.BACK_SPACE);
		wait(1000);
		waitUntilVisiblity(selectSegments).sendKeys(segments);
		selectSegments.sendKeys(Keys.ENTER);
		wait(3000);
	}
	
	public void selectSegments2(String segments) {
		wait(1000);
		waitUntilVisiblity(selectSegments).sendKeys(segments);
		selectSegments.sendKeys(Keys.ENTER);
		wait(3000);
	}
	
	public void enterLocation(String location) {
		waitUntilVisiblity(enterLocation).sendKeys(location);
	}
	
	public void selectCity(String cityName) {
		waitUntilVisiblity(selectCity).sendKeys(cityName);
		wait(2000);
		selectCity.sendKeys(Keys.ENTER);
	}
	
	public void selectRegion(String regionName) {
		waitUntilVisiblity(selectRegion).sendKeys(regionName);
		wait(2000);
		selectRegion.sendKeys(Keys.ENTER);
	}
	
	public void clickonPossesionDate(String possessionDate) {
		waitUntilVisiblity(clickonPossesionDate).sendKeys(possessionDate);
		clickonPossesionDate.sendKeys(Keys.ENTER);
	}
	
	public void clickonLaunchDate(String launchDate) {
		waitUntilVisiblity(clickonLaunchDate).sendKeys(launchDate);
		clickonLaunchDate.sendKeys(Keys.ENTER);
	}
	
	public void enterRegistrationName(String registrationName) {
		waitUntilVisiblity(enterRegistrationName).sendKeys(registrationName);
	}
	
	public void enterReraNumber(String reraNumber) {
		waitUntilVisiblity(enterReraNumber).sendKeys(reraNumber);
	}
	
	public void selectActiveProject() {
		waitUntilClickable(selectActiveProject).click();
	}
	
	public void enterConfigurations(String configurations) {
		waitUntilVisiblity(enterConfigurations).sendKeys(configurations);
	}
	
	public void enterTotalLand(String totalLand) {
		waitUntilVisiblity(enterTotalLand).sendKeys(totalLand);
	}
	
	public void enterOngoingTowers(String ongoingTowers) {
		waitUntilClickable(enterOngoingTowers).sendKeys(Keys.BACK_SPACE);
		wait(1000);
		waitUntilVisiblity(enterOngoingTowers).sendKeys(ongoingTowers);
	}
	
	public void enterProjectunits(String projectUnits) {
		waitUntilClickable(enterProjectunits).sendKeys(Keys.DELETE);
		wait(1000);
		waitUntilClickable(enterProjectunits).sendKeys(Keys.CLEAR);
		waitUntilVisiblity(enterProjectunits).sendKeys(projectUnits);
	}
	
	public void selectAmenities(String amenities) {
		waitUntilVisiblity(selectAmenities).sendKeys(amenities);
		wait(2000);
		selectAmenities.sendKeys(Keys.ENTER);
	}
	
	public void selectBanks(String bankName) {
		waitUntilVisiblity(selectBanks).sendKeys(bankName);
		wait(1000);
		selectBanks.sendKeys(Keys.ENTER);
	}
	
	public void enterGstNumber(String gstNumber) {
		waitUntilVisiblity(enterGstNumber).sendKeys(gstNumber);
	}
	
	public void enterCinNumber(String cinNumber) {
		waitUntilVisiblity(enterCinNumber).sendKeys(cinNumber);
	}
	
	public void enterProjectStartsFrom(String projectStartValue) {
		waitUntilVisiblity(enterProjectStartsFrom).sendKeys(projectStartValue);
	}
	
	public void enterProjectPriceUpto(String projectPriceUpto) {
		waitUntilVisiblity(enterProjectPriceUpto).sendKeys(projectPriceUpto);
	}
	
	public void enterFlatno(String flatnumber) {
		waitUntilVisiblity(enterFlatno).sendKeys(flatnumber);
	}
	
	public void enterStreetName(String streetName) {
		waitUntilVisiblity(enterStreetName).sendKeys(streetName);
	}
	
	public void enterCountry(String countryName) {
		waitUntilVisiblity(enterCountry).sendKeys(countryName);
	}
	
	public void enterState(String stateName) {
		waitUntilVisiblity(enterState).sendKeys(stateName);
	}
	
	public void selectProjectCity(String projectCity) {
		waitUntilVisiblity(selectProjectCity).sendKeys(projectCity);
		wait(1000);
		selectProjectCity.sendKeys(Keys.ENTER);
	}
	
	public void enterProjectPinCode(String projectZipcode) {
		waitUntilVisiblity(enterProjectPinCode).sendKeys(projectZipcode);
	}
	
	public void projectWebsiteLink(String websiteLink) {
		waitUntilVisiblity(projectWebsiteLink).sendKeys(websiteLink);
	}
	
	public void clickonSave() {
		waitUntilClickable(clickonSave).click();
		//Need to add wait due to when form is saved it takes time to save the project, if not given then project will not get added.
		wait(2000);
	}
	
	
//Verify Test Case 02 - Project with Same name should not get added.
	 // Method to check if error message is displayed
    public void verifyingSameProjectName() {
					String actmsg = driver.findElement(By.xpath("(//li[contains(text(), 'RERA Registration Number is already taken')])[1]")).getText();
					String errmsg = "Project Name is already taken"; 
					if(actmsg.equals(errmsg)) {
					    System.out.println("Test Case Passed");
					}else{
					    System.out.println("Test Case Failed");
					};
    	
//        try {
//            WebElement errorMessage = driver.findElement(By.xpath("(//li[contains(text(), 'Project Name is already taken')])[1]")); 
//            return errorMessage.isDisplayed();
//        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
//            return false;
//        }
    }
    
    public boolean verifyingSameReraNo() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("(//li[contains(text(), 'RERA Registration Number is already taken')])[1]")); 
            return errorMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    
  

	
	 	
}
