package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import utils.Retry;

import static constants.ITestConstants.*;

public class LoginTests extends BaseTest {

    @Test(description = "Login with valid Email and Password data",
            retryAnalyzer = Retry.class)
    public void successLogin() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        myAccountPage.getMyAccountTitle().shouldBe(Condition.visible);
    }

    @Test(description = "Checking for an error message when the Email address is empty",
            retryAnalyzer = Retry.class)
    public void loginWithEmptyEmailTest() {
        loginSteps
                .login("", PASSWORD, LOGIN_PAGE_URL)
                .checkLoginFieldErrorMessageText(EMPTY_EMAIL_ADDRESS_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the Password is empty",
            retryAnalyzer = Retry.class)
    public void loginWithEmptyPasswordTest() {
        loginSteps
                .login(EMAIL_ADDRESS, "", LOGIN_PAGE_URL)
                .checkLoginFieldErrorMessageText(EMPTY_PASSWORD_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the Email address is incorrect",
            retryAnalyzer = Retry.class)
    public void loginWithInvalidEmailTest() {
        loginSteps
                .login(INVALID_EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL)
                .checkLoginFieldErrorMessageText(INVALID_EMAIL_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the Password is incorrect",
            retryAnalyzer = Retry.class)
    public void loginWithInvalidPasswordTest() {
        loginSteps
                .login(EMAIL_ADDRESS, INVALID_PASSWORD, LOGIN_PAGE_URL)
                .checkLoginFieldErrorMessageText(INVALID_PASSWORD_ERROR_TEXT);
    }
}