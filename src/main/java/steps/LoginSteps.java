package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @Step("Success Login by user: {email}")
    public void login(String emailAddress, String password, String url) {
        loginPage
                .openLoginPage(url)
                .login(emailAddress, password);
    }
}