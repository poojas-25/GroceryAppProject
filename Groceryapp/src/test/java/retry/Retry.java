package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private static final Logger LOG = LogManager.getLogger("Retry.class"); //initialized logger to track and log test retry attempts using log4j
	private static final int maxTry = 2; //number of retry attempts
 
	private int count = 0; //tracks the number of times the retry has been attempted

	@Override
	public boolean retry(final ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) {  //will retry only if the testcase fails
			if (this.count < maxTry) {
				LOG.info("Retrying test " + iTestResult.getName() + " with status "
						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");//will log these details
				this.count++; //count increases after retry
				return true; //indicates a retry attempts
			}
		}
		return false; //no more retry
	}

	public String getResultStatusName(final int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		}
		if (status == 2) {
			resultName = "FAILURE";
		}
		if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}
}
