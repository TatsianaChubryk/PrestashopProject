package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationSteps {
    LoginPage loginPage;
    RegistrationPage registrationPage;

    public RegistrationSteps() {
        this.loginPage = new LoginPage();
        this.registrationPage = new RegistrationPage();
    }

    @Step("First step registration by user: {email}")
    public RegistrationSteps firstStepRegister(String emailAddress, String url) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .firstStepRegistration(emailAddress);
        return new RegistrationSteps();
    }

    @Step("Second step registration")
    public RegistrationSteps secondStepRegister(String firstName, String lastName, String registrationEmail, String password) {
        registrationPage.getPERSONAL_INFORMATION_TITLE().shouldBe(Condition.visible);
        registrationPage.secondStepRegistration(firstName, lastName, registrationEmail, password);
        return this;
    }

    @Step("Gets the email failed message displayed on the registration form")
    public RegistrationSteps checkRegistrationEmailErrorMessageText(String errorMessage) {
        Assert.assertEquals(registrationPage.getRegistrationEmailErrorMessageText(), errorMessage);
        return this;
    }

    @Step("Gets the failed message displayed on the registration form")
    public RegistrationSteps checkRegistrationErrorMessageText(String errorMessage) {
        Assert.assertEquals(registrationPage.getRegistrationErrorMessageText(), errorMessage);
        return this;
    }
}