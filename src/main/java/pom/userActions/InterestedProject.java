package pom.userActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pom.beyondwalls.utility.ReusableUtils;

public class InterestedProject extends ReusableUtils {
	WebDriver driver;
	String subscribedProjectName;

	public InterestedProject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Need to login from Channel Partner role 	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Projects')])[1]")
	private WebElement clickonProjects;

	@FindBy(how = How.XPATH, using = "(//a[@class='add-wishlist d-none d-sm-inline-block me-2'])[1]")
	private WebElement clickonHeartIcon;

//	@FindBy(how = How.XPATH, using = "(//*[starts-with(text(), 'Subscribe to Project')])[1]")
//	private WebElement clickonSubscribe;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Interested Projects')]")
	private WebElement clickonInterestedProjects;

	public void clickonProjects() {
		waitUntilClickable(clickonProjects).click();
		wait(2000);
	}

//	public void clickonHeartIcon() {
//		waitUntilClickable(clickonHeartIcon).click();
//	}

	// Either use clickonInterestedProjects or clickonHeartIcon
	public void clickonSubscribe(String subscribedProjectName) {
		wait(2000);
		WebElement subscribeProject = driver.findElement(By.xpath("//a[text()='" + subscribedProjectName
				+ "']/ancestor::div[@class='project-inner-info']//a[@class='add-wishlist d-none d-sm-block']"));
		scrollIntoView(subscribeProject);
		wait(2000);
		jsClick(subscribeProject);
		this.subscribedProjectName = subscribedProjectName;
	}

	public void clickonInterestedProjects() {
		waitUntilClickable(clickonInterestedProjects).click();
	}

	// Temp project listing from Interested Projects
	public void verifyInterestedProject() {
		java.util.List<WebElement> projectList = driver
				.findElements(By.xpath("//div[@class='single-prjt-list mb-4']//h2[@class='title']"));
		projectList.stream().map(S -> S.getText()).forEach(System.out::println);

		for (WebElement we : projectList) {
			if (we.getText().contains(subscribedProjectName)) {
				System.out.println(subscribedProjectName + " is present in Interested Projects section");
			} else {
				System.out.println(subscribedProjectName + " is not present in the Interested Projects section");
			}
		}

	}

}
