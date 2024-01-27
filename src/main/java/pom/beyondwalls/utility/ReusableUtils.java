package pom.beyondwalls.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableUtils {

	private WebDriver driver;

	private FileWriter writer;

	private BufferedWriter buffer;

	private final static int waitingTime_Sec = 5;

	private static int zoom;

	public ReusableUtils(WebDriver driver) {

		this.driver = driver;

	}

	public ReusableUtils() {

	//	this.driver = driver;

	}

//RAJAT
	public void dropdownselection(String projectName) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='selectize-input items required has-options invalid not-full']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='selectize-input items required has-options invalid not-full']"))
				.sendKeys(projectName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='selectize-input items required has-options invalid not-full']"))
				.sendKeys(Keys.ENTER);

	}

	public void WaitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

//ANIKET 
	// Method for Date, Month & Year selection
	protected static String getDate(long a, String of) {

		String s = "";
		switch (of) {
		case "D":
			s = new SimpleDateFormat("dd").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "M":
			s = new SimpleDateFormat("M").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "Y":
			s = new SimpleDateFormat("YYYY").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));
			break;
		case "m":
			s = new SimpleDateFormat("mm").format(new Date().getTime() + (a * (1000 * 60)));
			break;
		case "H":
			s = new SimpleDateFormat("hh").format(new Date().getTime() + (a * (1000 * 60 * 60)));
			break;

		default:
			System.out.println("please select valid input");
			break;
		}
		return s;
	}

	public void clickOnElement(By we, String str) throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		List<WebElement> ls = driver.findElements(we);
		Thread.sleep(1000);
		ls.stream().forEach(S -> System.out.println(S.getText()));
		;
		executor.executeScript("arguments[0].click();",
				ls.stream().filter(S -> S.getText().equalsIgnoreCase(str)).findFirst().get());
	}

	protected Properties getGobalData() {

		Properties prop = new Properties();

		try {

			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		} catch (IOException e) {

			e.printStackTrace();

		}

		return prop;

	}

	protected String prop(String str) {

		Properties prop = new Properties();

		try {

			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		} catch (IOException e) {

			e.printStackTrace();

		}

		return prop.getProperty(str);

	}

	// --------------------------Wait ------------------------

	protected void waitUntilAlertIsPresent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	protected WebElement waitUntilVisiblity(WebElement we) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));

		wait.until(ExpectedConditions.visibilityOf(we));

		Square(we);

		return we;

	}

	protected WebElement waitUntilVisiblity(WebElement we, long delay) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));

		wait.until(ExpectedConditions.visibilityOf(we));

		Square(we);

		return we;

	}

	protected List<WebElement> invisibilityOfAllElements(List<WebElement> we) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));

		wait.until(ExpectedConditions.invisibilityOfAllElements(we));

		// Square(we);

		return we;

	}

	protected WebElement waitUntilInvisibility(WebElement we) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));

		wait.until(ExpectedConditions.invisibilityOf(we));

		return we;

	}

	protected WebElement waitUntilInvisibility(WebElement we, int time) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

		wait.until(ExpectedConditions.invisibilityOf(we));

		return we;

	}

	protected WebElement waitUntilClickable(WebElement we) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));

		wait.until(ExpectedConditions.elementToBeClickable(we));

		System.out.println("Clicked Element -> " + we.getText().trim());

		Square(we);

		return we;

	}

	protected WebElement waitUntilAttributeValue(WebElement we, String attribute, String Value, int time) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

		wait.until(ExpectedConditions.attributeContains(we, attribute, Value));

		System.out.println("Clicked Element -> " + we.getText().trim());

		Square(we);

		return we;

	}

	protected WebElement waitUntilClickable(WebElement we, int time) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

		wait.until(ExpectedConditions.elementToBeClickable(we));

		Square(we);

		return we;

	}

	protected List<WebElement> waitUntilVisibilityOfElements(List<WebElement> we) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));

		wait.until(ExpectedConditions.visibilityOfAllElements(we));

		return we;

	}

	protected List<WebElement> waitUntilInVisibilityOfElements(List<WebElement> we) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));

		wait.until(ExpectedConditions.invisibilityOfAllElements(we));

		return we;

	}

	protected void waitElementToBeClickable(WebElement we) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));

		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(we)));

		Square(we);

	}

	protected void wait(int value) {

		try {

			Thread.sleep(value);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}
	
	protected WebDriverWait wait;

    protected void browserPopupHandling(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }
	

	// -------------------------------- Action ----------------------

	protected void HoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick) {

		Actions action = new Actions(driver);

		action.moveToElement(elementToHover).click(elementToClick).build().perform();

	}

	protected void moveToElement(WebElement we) {

		Actions actions = new Actions(driver);

		Square(we);

		actions.moveToElement(we).build().perform();

	}

	protected void moveToElementClick(WebElement we) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we).click().build().perform();

	}

	protected void moveToAndEnter(WebElement we) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we);

		actions.click();

		actions.sendKeys(Keys.ENTER);

		actions.build().perform();

	}

	protected void moveToAndEnter(WebElement we, String value) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we).click().sendKeys(value).sendKeys(Keys.ENTER).build().perform();

		;

	}

	protected void moveToAndSendKeyEnter(WebElement we, String s) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we);

		actions.click();

		actions.sendKeys(s);

		actions.sendKeys(Keys.ENTER);

		actions.build().perform();

	}

	protected void moveToAndSendKey(WebElement we, String s) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we);

		Square(we);

		wait(1000);

		actions.click();

		actions.sendKeys(s);

		actions.build().perform();

	}

	protected void scrollAction(WebElement we, WebElement we2) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we);

		Square(we);

		actions.scrollToElement(we2);

		actions.build().perform();

	}

	protected void moveToAndSendEnter(WebElement we) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we);

		Square(we);

		actions.click();

		actions.sendKeys(Keys.ENTER);

		actions.build().perform();

	}

	protected void move2click(WebElement we, WebElement we2) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we);

		Square(we);

		actions.moveToElement(we2);

		actions.click();

		actions.build().perform();

	}

	protected void moveToElemntClick(WebElement we) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we);

		actions.click();

		actions.build().perform();

	}

	protected void move2click(WebElement we, int value) {

		Actions actions = new Actions(driver);

		actions.moveToElement(we);

		Square(we);

		actions.build().perform();

		driver.findElement(By.cssSelector(

				"body > div.main-nav-container > div.sub-navigation-bar > div:nth-child(1) > div:nth-child(" + value

						+ ") > a"))

				.click();

	}

	// -------------------JavascriptExecutor----------------

	protected void scrollIntoView(WebElement we) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", we);

		scrollBy(-1000);

		wait(500);

		Square(we);

	}

	protected WebElement scrollIntoViewUp(WebElement we) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(false);", we);
		scrollBy(1000);
		Square(we);

		return we;

	}

	protected void scrollBy(int scroll) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0," + scroll + ")", "");

	}

	protected void jsClick(WebElement we) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));

		wait.until(ExpectedConditions.elementToBeClickable(we));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		System.out.println("jsClicked Element -> " + we.getText().trim());

		executor.executeScript("arguments[0].click();", we);

		Square(we);

	}

	protected void scrollHeight() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	protected WebElement Square(WebElement we) {

		// wait(500);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		zoom = 80;

		// js.executeScript("document.body.style.zoom='"+(zoom+0.10)+"%'");

		js.executeScript("arguments[0].style.border='5px solid Green'", we);

		return we;

	}

	protected void deZoom(int in) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.body.style.zoom='" + in + "%'");

	}

	protected WebElement jsSendKey(WebElement we, String txt) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Square(we);

		js.executeScript("arguments[0].value='" + txt + "'", we);

		return we;

	}

	protected String jsGetText(WebElement we) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Square(we);

		return (String) js.executeScript("return arguments[0].text;", we);

	}

	protected void zoom(String zoom) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("document.body.style.zoom = '" + zoom + "'");

	}

	// ----------------Select ------------------

	protected void selectByIndex(WebElement we, int index) {

		Square(we);

		Select oSelect = new Select(we);

		oSelect.selectByIndex(index);

	}

	protected void selectByVisibleText(WebElement we, String index) {

		Square(we);

		Select oSelect = new Select(we);

		oSelect.selectByVisibleText(index);

	}

	protected void selectByVisibleValue(WebElement we, String index) {

		Square(we);

		Select oSelect = new Select(we);

		oSelect.selectByValue(index);

	}

	// -------------------------RANDOME-------------------------------

	protected String random(String method, String choise, int size) {

		String Return = "";

		switch (choise) {

		case "AN":

			Return = RandomStringUtils.randomAlphanumeric(size);

			break;// pX4Mv3KsJU

		case "A":

			Return = RandomStringUtils.randomAlphabetic(size);

			break;// ZLTRqGyuXk

		case "R":

			Return = RandomStringUtils.random(size);

			break;// 嚰险걻鯨贚䵧縓

		case "N":

			Return = RandomStringUtils.randomNumeric(size);

			break;// 3511779161

		default:

			break;

		}

		try {

			writer = new FileWriter(System.getProperty("user.dir") + "/Random Values/" + method + " value" + ".txt");

			buffer = new BufferedWriter(writer);

			buffer.write("for : " + method + " : " + Return);

			buffer.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return Return;

	}

	// -----------------------Switching frame-------------------

	protected void frameSwitch(int value) {

		driver.switchTo().frame(value);

	}

	protected void frameSwitch(String value) {

		driver.switchTo().frame(value);

	}

	protected void frameSwitch(WebElement value) {

		driver.switchTo().frame(value);

	}

	protected void defaultContentSwitch() {

		driver.switchTo().defaultContent();

	}

	// --------------Other------------------------------------------------

	protected void refresh() {

		driver.navigate().refresh();

	}

	protected void robotScroll(WebElement element, int value) {

		wait(999);

		Robot rb = null;

		try {

			rb = new Robot();

		} catch (AWTException e) {

			e.printStackTrace();

		}

		Point point = element.getLocation();

		int x = point.getX();

		int y = point.getY();

		rb.mouseMove(x, y);

		rb.mouseWheel(value);

	}

	protected String date(String format) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);// dd/MM/yyyy HH:mm:ss

		LocalDateTime now = LocalDateTime.now();

		return dtf.format(now);

	}

	protected void waitInvisblityLoading() {

		waitUntilVisiblity(driver.findElement(By.xpath("//div[@class='tc loading_screen_bars']")));

		waitUntilInvisibility(driver.findElement(By.xpath("//div[@class='tc loading_screen_bars']")));

	}

	protected String R(char... arr) {

		return RandomStringUtils.random(1, arr);

	}

	protected String getSuccessMSG() {

		WebElement ele = driver.findElement(By.xpath("//div[@class='noty_message']"));

		new ReusableUtils(driver).waitUntilVisiblity(ele);

		while (true) {

			try {

				Thread.sleep(100);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			if (ele.getText().trim().length() > 5) {

				break;

			}

		}

		String Noty = ele.getText().trim();

		System.out.println("Noty Message >>> " + ele.getText());

		try {

			waitUntilInvisibility(ele);

		} catch (Exception e) {

		}

		return Noty;

	}

	protected String getDate(int a, String of) {

		String s = "";

		switch (of) {

		case "D":

			s = new SimpleDateFormat("dd").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));

			break;

		case "M":

			s = new SimpleDateFormat("M").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));

			break;

		case "Y":

			s = new SimpleDateFormat("YYYY").format(new Date().getTime() + (a * (1000 * 60 * 60 * 24)));

			break;

		default:

			System.out.println("please select valid input");

			break;

		}

		return s;

	}

	public String randomEmail() {

		return "aniket.khandizod+" + Random("AN", 10) + "@sell.do";

	}

	public String randomPhone() {

		return " 12345" + Random("N", 5);

	}

	public String Random(String type, int size) {

		String Return = "";

		switch (type) {

		case "AN":

			Return = RandomStringUtils.randomAlphanumeric(size);

			break;// pX4Mv3KsJU

		case "A":

			Return = RandomStringUtils.randomAlphabetic(size);

			break;// ZLTRqGyuXk

		case "R":

			Return = RandomStringUtils.random(size);

			break;// 嚰险걻鯨贚䵧縓

		case "N":

			Return = RandomStringUtils.randomNumeric(size);

			break;// 3511779161

		default:

			break;

		}

		return Return;

	}
	public static void main(String[] args) {

		System.out.println(new SimpleDateFormat("MM").format(new Date().getTime() + (0 * (1000 * 60 * 60 * 24))));
		System.out.println(new SimpleDateFormat("dd").format(new Date().getTime() + (0 * (1000 * 60 * 60 * 24))));

	}
	

}
