package tests;

import org.testng.annotations.Test;
import utils.Retry;

import static constants.ITestConstants.*;

public class RegistrationTests extends BaseTests {

    @Test(description = "Successful user registration")
    public void successRegistration() {
        registrationSteps
                .firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL)
                .secondStepRegister(FIRST_NAME, LAST_NAME, REGISTRATION_EMAIL_ADDRESS, PASSWORD);
        myAccountSteps.checkMyAccountTitle(MY_ACCOUNT_TITLE);
    }

    @Test(description = "Registering an existing user",
            retryAnalyzer = Retry.class)
    public void registerExistingUser() {
        registrationSteps
                .firstStepRegister(EMAIL_ADDRESS, LOGIN_PAGE_URL)
                .checkRegistrationEmailErrorMessageText(EXISTING_USER_ERROR_TEXT);
    }

    @Test(description = "Registering with empty email",
            retryAnalyzer = Retry.class)
    public void registerWithEmptyEmail() {
        registrationSteps
                .firstStepRegister("", LOGIN_PAGE_URL)
                .checkRegistrationEmailErrorMessageText(INVALID_EMAIL_ERROR_TEXT);
    }

    @Test(description = "Registering with invalid email",
            retryAnalyzer = Retry.class)
    public void registerWithInvalidEmail() {
        registrationSteps
                .firstStepRegister(INVALID_EMAIL_ADDRESS, LOGIN_PAGE_URL)
                .checkRegistrationEmailErrorMessageText(INVALID_EMAIL_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the first name is empty",
            retryAnalyzer = Retry.class)
    public void registrationWithEmptyFirstName() {
        registrationSteps
                .firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL)
                .secondStepRegister("", LAST_NAME, REGISTRATION_EMAIL_ADDRESS, PASSWORD)
                .checkRegistrationErrorMessageText(EMPTY_FIRST_NAME_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the last name is empty",
            retryAnalyzer = Retry.class)
    public void registrationWithEmptyLastName() {
        registrationSteps
                .firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL)
                .secondStepRegister(FIRST_NAME, "", REGISTRATION_EMAIL_ADDRESS, PASSWORD)
                .checkRegistrationErrorMessageText(EMPTY_LAST_NAME_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the email is empty",
            retryAnalyzer = Retry.class)
    public void registrationWithEmptyEmail() {
        registrationSteps
                .firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL)
                .secondStepRegister(FIRST_NAME, LAST_NAME, "", PASSWORD)
                .checkRegistrationErrorMessageText(EMPTY_EMAIL_ERROR_TEXT);
    }

    @Test(description = "Checking for an error message when the password is empty",
            retryAnalyzer = Retry.class)
    public void registrationWithEmptyPassword() {
        registrationSteps
                .firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL)
                .secondStepRegister(FIRST_NAME, LAST_NAME, REGISTRATION_EMAIL_ADDRESS, "")
                .checkRegistrationErrorMessageText(EMPTY_PASSWD_ERROR_TEXT);
    }
}