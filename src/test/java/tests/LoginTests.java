package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.IConstants.LOGIN_URL_FIELD_ERROR;
import static constants.IConstants.TITLE_XPATH;

public class LoginTests extends BaseTest {

    @Test(description = "Login with valid Email and Password data")
    public void successLogin() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        Assert.assertEquals(TITLE_XPATH.getText(), TITLE);
    }

    @Test(description = "Checking for an error message when the Email address is empty")
    public void loginWithEmptyEmailTest() {
        loginSteps.login("", PASSWORD, LOGIN_PAGE_URL);
        Assert.assertEquals(LOGIN_URL_FIELD_ERROR.getText(), EMPTY_FIELD_EMAIL_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the Password is empty")
    public void loginWithEmptyPasswordTest() {
        loginSteps.login(EMAIL_ADDRESS, "", LOGIN_PAGE_URL);
        Assert.assertEquals(LOGIN_URL_FIELD_ERROR.getText(), EMPTY_FIELD_PASSWORD_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the Email address is incorrect")
    public void loginWithInvalidEmailTest() {
        loginSteps.login(INVALID_EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        Assert.assertEquals(LOGIN_URL_FIELD_ERROR.getText(), INVALID_EMAIL_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the Email address is incorrect")
    public void loginWithInvalidPasswordTest() {
        loginSteps.login(EMAIL_ADDRESS, INVALID_PASSWORD, LOGIN_PAGE_URL);
        Assert.assertEquals(LOGIN_URL_FIELD_ERROR.getText(), INVALID_PASSWORD_ERROR_TEXT);
    }
}
