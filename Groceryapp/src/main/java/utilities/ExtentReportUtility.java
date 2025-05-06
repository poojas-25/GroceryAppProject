package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();   //creating instance for ExtentReports class
	public synchronized static ExtentReports createExtentReports() {    //synchronized is used for ensuring thread safety 

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //ExtentSparkReporter class handles the creation and config of a html report.Path of the folder of the report in html format
		
		reporter.config().setReportName("Grocery Application");  //set name of the html report
		extentReports.attachReporter(reporter);                 //attaches the ExtentSparkReporter configuration to ExtentReports instance
		extentReports.setSystemInfo("Organization", "Obsqura");  //adds s/m level info to the report
		extentReports.setSystemInfo("Name", "Pooja");
		return extentReports;   //returns the report
	}
}
