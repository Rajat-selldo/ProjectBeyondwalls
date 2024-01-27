package pom.userActions;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class FiltersonProjectListing extends ReusableUtils {
	WebDriver driver;

	public FiltersonProjectListing(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//Click on Projects 
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Projects')]")
	private WebElement clickonProjects;
	
	@FindBy(how = How.XPATH, using = "//div[@class='filter-popup']")
	private WebElement clickonFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs__id-selectized']")
	private WebElement selectProjectname;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_city-selectized']")
	private WebElement selectCityname;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_region_ids_-selectized']")
	private WebElement selectRegionname;
	
	@FindBy(how = How.XPATH, using = "fltrs_category-selectized")
	private WebElement selectCategoryname;
	
	@FindBy(how = How.XPATH, using = "fltrs_project_types-selectized")
	private WebElement selectProjecttype;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_project_segment-selectized']")
	private WebElement selectSegments; 
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_configurations-selectized']")
	private WebElement selectConfigurations; 
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_micro_market-selectized']")
	private WebElement selectLocation; 
	
	@FindBy(how = How.XPATH, using = "//input[@id='fltrs_possession']")
	private WebElement enterpossessionDate;
		
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']")
	private WebElement applyFilter;
	
	@FindBy(how = How.XPATH, using = "//div[@class='single-prjt-list mb-4']")
	private java.util.List<WebElement> projectElements;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Apply')]")
	private WebElement applyonCalendar;
	
	

//Methods 	
	public void clickonProjects() {
		waitUntilClickable(clickonProjects).click();
	}
	
	public void clickonFilter() {
		waitUntilClickable(clickonFilter).click();
	}
	
	public void selectProjectname(String projectName1) {
		waitUntilVisiblity(selectProjectname).sendKeys(projectName1);
		wait(2000);
		selectProjectname.sendKeys(Keys.ENTER);		
		}	
	
	public void selectCityname(String cityName1) {
		waitUntilVisiblity(selectCityname).sendKeys(cityName1);
		wait(2000);
		selectCityname.sendKeys(Keys.ENTER);	
	}
	
	public void selectRegionname(String regionName1) {
		waitUntilVisiblity(selectRegionname).sendKeys(regionName1);
		wait(2000);
		selectRegionname.sendKeys(Keys.ENTER);	
	}
	
	public void selectCategoryname(String categoryName1) {
		waitUntilVisiblity(selectCategoryname).sendKeys(categoryName1);
		wait(2000);
		selectCategoryname.sendKeys(Keys.ENTER);	
	}
	
	public void selectProjecttype(String projectType) {
		waitUntilVisiblity(selectProjecttype).sendKeys(projectType);
		wait(2000);
		selectProjecttype.sendKeys(Keys.ENTER);	
	}
	
	public void selectSegments(String segment) {
		waitUntilVisiblity(selectSegments).sendKeys(segment);
		wait(2000);
		selectSegments.sendKeys(Keys.ENTER);	
	}
	
	public void selectConfigurations(String config) {
		waitUntilVisiblity(selectConfigurations).sendKeys(config);
		wait(2000);
		selectConfigurations.sendKeys(Keys.ENTER);	
	}
	
	public void selectLocation(String micro_market) {
		waitUntilVisiblity(selectLocation).sendKeys(micro_market);
		wait(2000);
		selectLocation.sendKeys(Keys.ENTER);	
	}
	
	public void enterpossessionDate(String dateRangeToSelect) {
		waitUntilClickable(enterpossessionDate).sendKeys(dateRangeToSelect);
		System.out.println("Date range selected");
		waitUntilClickable(applyonCalendar).click();
		wait(2000);
		
//	// Logic to handle different date range selections
//        switch (dateRangeToSelect.toLowerCase()) {
//            case "today":
//                // Logic to select Today
//            	driver.findElement(By.xpath("//li[contains(text(), 'Today')]")).click();
//                break;
//            case "yesterday":
//                // Logic to select Yesterday
//            	driver.findElement(By.xpath("//li[contains(text(), 'Yesterday')]")).click();
//                break;
//            case "last 7 days":
//                // Logic to select Last 7 days
//            	driver.findElement(By.xpath("//li[contains(text(), 'Last 7 Days')]")).click();
//                break;
//            case "last 1 month":
//                // Logic to select Last 1 Month
//            	driver.findElement(By.xpath("//li[contains(text(), 'Last 1 Month')]")).click();
//                break;
//            case "last 6 months":
//                // Logic to select Last 6 Months
//            	driver.findElement(By.xpath("//li[contains(text(), 'Last 6 Months')]")).click();
//            	wait(2000);
//                break;
//            default:
//                // Logic to handle custom range - Open calendar or perform any other actions
//            	driver.findElement(By.xpath("//li[contains(text(), 'Custom Range')]")).click();
//            	wait(1000);
//            	
//                break;
//        }
	}
	
	public void applyFilter() {
		waitUntilClickable(applyFilter).click();
		wait(3000);
	}
	
	public void verifyProjects(String projectName1) {
		//Checking the Test case 02 
				wait(2000);
				//java.util.List<WebElement> projectElements = driver.findElements(By.xpath("//h2[@class='title']"));
		        boolean isProjectDisplayed = false;

		        for (WebElement projectElement : projectElements) {
		            String displayedProjectName = projectElement.getText();

		            if (displayedProjectName.equalsIgnoreCase(projectName1)) {
		                isProjectDisplayed = true;
		                break;
		            }
		        }

		        if (isProjectDisplayed) {
		            System.out.println("The project '" + projectName1 + "' is displayed after filtering.");
		        } else {
		            System.out.println("The project '" + projectName1 + "' is not displayed after filtering.");
		        }

	}
	

}
