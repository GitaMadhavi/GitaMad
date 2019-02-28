import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ReportExtent {
	static com.relevantcodes.extentreports.ExtentReports report;
	static com.relevantcodes.extentreports.ExtentTest logger;

	public static void main(String[] args) {
		

		System.out.println("start");

		// Initialize Extent Report
		String path = "C:\\Users\\gitam\\Desktop\\ExtentReports\\report.html";

		ExtentReports report = new ExtentReports(path);
          
		// Initialize logger
		logger = report.startTest("Login to SFDC");

		logger.log(LogStatus.INFO, "Firefox browser launched");
		logger.log(LogStatus.PASS, "Username Exter Successfully");
		logger.log(LogStatus.FAIL, "Password field does not exist");
		logger.log(LogStatus.PASS, "Login button clicked");

		report.endTest(logger);

		// initialize logger
		logger = report.startTest("Remember Password on SFDC");

		logger.log(LogStatus.INFO, "Firefox beoser launched");
		logger.log(LogStatus.PASS, "Username Exter Successfully");
		logger.log(LogStatus.PASS, "Password Entered");
		logger.log(LogStatus.PASS, "Clicked on Remember Checkbox");
		logger.log(LogStatus.PASS, "Login button clicked");

		report.endTest(logger);
		
		report.flush();

		System.out.println("End");

	}
	}


