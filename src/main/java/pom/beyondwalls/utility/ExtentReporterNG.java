package pom.beyondwalls.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		} catch (IOException e) {
		}

		// -----------------------------------------------------------------------------
		String path = System.getProperty("user.dir") + "//reports//AutomationReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("BeyondWalls Web login test Results");
		reporter.config().setDocumentTitle("BeyondWalls Automation Report");
		reporter.config().setTheme(Theme.DARK);

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rajat Patil");
		extent.setSystemInfo("Email", "rajat.patil@sell.do");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Environment", prop.getProperty("url"));
		return extent;


	}
}
