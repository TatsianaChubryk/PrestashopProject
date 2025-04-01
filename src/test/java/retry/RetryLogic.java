package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
    private int count = 0;
    private final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetryCount) {
            count++;
            return true; // Повторяем тест
        }
        return false; // Не повторяем
    }
}