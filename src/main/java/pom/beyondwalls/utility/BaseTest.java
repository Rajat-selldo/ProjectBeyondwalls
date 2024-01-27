package pom.beyondwalls.utility;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;

	public WebDriverWait wait;

	@BeforeMethod(alwaysRun = true)

	protected void browserConfig() throws FileNotFoundException, IOException, AWTException {
		// -------------------Property Files-------------------//

		Properties prop = new Properties();

		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		// -------------------get Browser Property-------------------//

		String browser = prop.getProperty("browser").trim();
		// -------------------WebDriver-------------------//

		if (browser.equalsIgnoreCase("chrome")) {
//			ChromeOptions options = new ChromeOptions();
//			// ================Add Extension==========
//			// options.addExtensions(new File(System.getProperty("user.dir")
//			// +"/AdBlock-—-best-ad-blocker.crx"));
//		//	options.addExtensions(new File(System.getProperty("user.dir") + "/When-the-Night-Falls-1;-rainbow;-1080p.crx"));
// 
//			// ================To disable Automation name==========
//			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
//			// ================To disable notification popup========
//			options.addArguments("--disable-notifications");
//			// ================disable save password===============
//			options.addArguments("--start-maximized");
//			options.addArguments("--disable-web-security");
//			options.addArguments("--no-proxy-server");
//			Map<String, Object> p = new HashMap<String, Object>();
//			p.put("credentials_enable_service", false);
//			p.put("profile.password_manager_enabled", false);
//			options.setExperimentalOption("prefs", p);
//			// =================Dark Mode =========================
//			options.addArguments("--force-dark-mode");
//			// ===============WebDriver=================//
//			options.addArguments("window-position=2000,0");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
 
		
			
			
		} else if (browser.equalsIgnoreCase("firefoxdriver")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edgedriver")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("SafariDriver")) {

			WebDriverManager.safaridriver().setup();

			driver = new SafariDriver();

		} else if (browser.equalsIgnoreCase("HtmlUnitDriver")) {
			
		} else if (browser.equalsIgnoreCase("ChromeDriver")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		// -------------------Browser Management-------------------//

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("URL"));				//config.properties URL value
		
		// -------------------Delay Management-------------------//

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@AfterMethod(alwaysRun = true)

	protected void terminate() throws InterruptedException {

		try {

			driver.quit();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

//implicitly wait method added by Rajat
	 protected void setImplicitWait(long timeoutInSeconds) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
	    }
//Project drop-down method added by Rajat	 
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

//Screenshot 
	public String getScreenshot(String fileName, WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file = ts.getScreenshotAs(OutputType.FILE);

		File filee = new File(System.getProperty("user.dir") + "//reports//" + fileName + ".png");

		try {

			FileUtils.copyFile(file, filee);

		} catch (IOException e) {

			e.printStackTrace();

		}

		return System.getProperty("user.dir") + "//reports//" + fileName + ".png";

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

			new ReusableUtils(driver).waitUntilInvisibility(ele);

		} catch (Exception e) {

		}

		return Noty;

	}

	protected void getSuccessMSGinvisiblity() {

		boolean ele = driver.findElement(By.xpath("//div[@class='noty_message']")).isDisplayed();

		while (ele) {

			try {

				Thread.sleep(100);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			ele = driver.findElement(By.xpath("//div[@class='noty_message']")).isDisplayed();

		}

	}

	public String DateTime(String time) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(time);// yyyy/MM/dd

		LocalDateTime now = LocalDateTime.now();

		return dtf.format(now);

	}

	public String randomEmail() {

		String email[] = prop("Email").split("@");

		String name = email[0];

		String domain = email[1];

		return name + "+" + Random("AN", 10) + "@" + domain;

	}

	public String randomEmail(String str) {

		return str + "+" + Random("AN", 10) + "@sell.do";

	}

	public String randomPAN() {

		String _4th = R('A', 'B', 'C', 'F', 'G', 'H', 'L', 'J', 'P', 'T', 'F');

		return Random("A", 3).toUpperCase() + _4th + Random("A", 1).toUpperCase() + Random("N", 4)
				+ Random("A", 1).toUpperCase();

	}

	public String randomPhone() {

		return " 7" + Random("N", 9);

	}

	public WebElement loading() {

		return driver.findElement(By.xpath("//div[@class='tc loading_screen_bars']"));

	}

	public String Random(int size) {

		return RandomStringUtils.randomAlphabetic(size);

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

	protected void deZoom(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.body.style.zoom='80%'");

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

	public String prop(String propee) {

		Configurations configs = new Configurations();

		Configuration config = null;

		try {

			config = configs.properties(new File(System.getProperty("user.dir") + "/config.properties"));

		} catch (ConfigurationException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return config.getString(propee);

	}

	public void logout() {

		driver.get(prop("URL") + "/users/logout");

	}

}
