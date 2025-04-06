package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetryCount) {
            count++;
            System.out.println("Retrying test " + result.getName() + " for the " + count + " time.");
            return true;
        }
        return false;
    }
}