package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class RegistrationTest extends BaseTest {

    @Test(description = "Successful user registration")
    public void successRegistration() {
        registrationSteps.firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL);
        registrationSteps.secondStepRegister(FIRST_NAME, LAST_NAME, REGISTRATION_EMAIL_ADDRESS, PASSWORD);
        myAccountPage.getMyAccountTitle().shouldBe(Condition.visible);
    }

    @Test(description = "Registering an existing user",
            retryAnalyzer = Retry.class)
    public void registerExistingUser() {
        registrationSteps.firstStepRegister(EMAIL_ADDRESS, LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getRegistrationEmailErrorMessageText(), loginPage.getExistingUserErrorText());
    }

    @Test(description = "Registering with empty email",
            retryAnalyzer = Retry.class)
    public void registerWithEmptyEmail() {
        registrationSteps.firstStepRegister("", LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getRegistrationEmailErrorMessageText(), loginPage.getInvalidEmailErrorText());
    }

    @Test(description = "Registering with invalid email",
            retryAnalyzer = Retry.class)
    public void registerWithInvalidEmail() {
        registrationSteps.firstStepRegister(INVALID_EMAIL_ADDRESS, LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getRegistrationEmailErrorMessageText(), loginPage.getInvalidEmailErrorText());
    }

    @Test(description = "Checking for an error message when the first name is empty",
            retryAnalyzer = Retry.class)
    public void registrationWithEmptyFirstName() {
        registrationSteps.firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL);
        registrationSteps.secondStepRegister("", LAST_NAME, REGISTRATION_EMAIL_ADDRESS, PASSWORD);
        Assert.assertEquals(loginPage.getRegistrationErrorMessageText(), loginPage.getEmptyFirstNameErrorText());
    }

    @Test(description = "Checking for an error message when the last name is empty",
            retryAnalyzer = Retry.class)
    public void registrationWithEmptyLastName() {
        registrationSteps.firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL);
        registrationSteps.secondStepRegister(FIRST_NAME, "", REGISTRATION_EMAIL_ADDRESS, PASSWORD);
        Assert.assertEquals(loginPage.getRegistrationErrorMessageText(), loginPage.getEmptyLastNameErrorText());
    }

    @Test(description = "Checking for an error message when the email is empty",
            retryAnalyzer = Retry.class)
    public void registrationWithEmptyEmail() {
        registrationSteps.firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL);
        registrationSteps.secondStepRegister(FIRST_NAME, LAST_NAME, "", PASSWORD);
        Assert.assertEquals(loginPage.getRegistrationErrorMessageText(), loginPage.getEmptyEmailErrorText());
    }

    @Test(description = "Checking for an error message when the password is empty",
            retryAnalyzer = Retry.class)
    public void registrationWithEmptyPassword() {
        registrationSteps.firstStepRegister(REGISTRATION_EMAIL_ADDRESS, LOGIN_PAGE_URL);
        registrationSteps.secondStepRegister(FIRST_NAME, LAST_NAME, REGISTRATION_EMAIL_ADDRESS, "");
        Assert.assertEquals(loginPage.getRegistrationErrorMessageText(), loginPage.getEmptyPasswdErrorText());
    }
}