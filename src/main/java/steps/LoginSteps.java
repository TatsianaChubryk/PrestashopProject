package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import org.testng.Assert;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @Step("Login by user: {email} and {password}")
    public LoginSteps login(String emailAddress, String password, String url) {
        loginPage
                .openLoginPage(url)
                .isOpened()
                .login(emailAddress, password);
        return new LoginSteps();
    }

    @Step("Gets the login failed message displayed on the login page")
    public LoginSteps checkLoginFieldErrorMessageText(String errorMessage) {
        Assert.assertEquals(loginPage.getLoginFieldErrorMessageText(), errorMessage);
        return this;
    }
}