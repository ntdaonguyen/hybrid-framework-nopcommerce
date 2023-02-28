package reportConfig;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import commons.GlobalConstants;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			extent = new ExtentReports(System.getProperty("user.dir") + "/extentV2/ExtentReportScreenshot.html", true);
		}
		return extent;
	}
}