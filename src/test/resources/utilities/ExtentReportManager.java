import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public static ExtentReports extent;
	
	public static void extentReportSetup(String filename) {
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filename);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "xxxx");
		extent.setSystemInfo("Organization", "TutorialNinja");
		extent.setSystemInfo("Build","1.0.0");
		
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().getDocumentTitle(filename)
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(filename);
		
		return extent;
		
	}
	
	

	
}
