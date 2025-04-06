package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @Step("Login by user: {email} and {password}")
    public void login(String emailAddress, String password, String url) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .login(emailAddress, password);
    }
}