package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
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
    public void firstStepRegister(String emailAddress, String url) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .firstStepRegistration(emailAddress);
    }

    @Step("Second step registration")
    public void secondStepRegister(String firstName, String lastName, String registrationEmail, String password) {
        registrationPage.getPersonalInformationTitle().shouldBe(Condition.visible);
        registrationPage.secondStepRegistration(firstName, lastName, registrationEmail, password);
    }
}