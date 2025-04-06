package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Getter
@Log4j2
public class LoginPage extends BasePage {
    SelenideElement EMAIL_ADDRESS = $x("//*[@id='email']");
    SelenideElement PASSWORD = $x("//*[@id='passwd']");
    SelenideElement SIGN_IN_BUTTON = $x("//*[@id='SubmitLogin']");
    SelenideElement TITLE_XPATH = $x("//*[@id='center_column']/h1");
    SelenideElement LOGIN_URL_FIELD_ERROR = $x("//*[@id='center_column']/div[1]/ol/li");
    String emptyEmailErrorText = "An email address required.";
    String emptyPasswordErrorText = "Password is required.";
    String invalidEmailErrorText = "Invalid email address.";
    String invalidPasswordErrorText = "Invalid password.";

    public LoginPage() {
    }

    /**
     *
     * @param url
     * @return LoginPage object
     */
    public LoginPage openLoginPage(String url) {
        log.info("Opening login page: " + url);
        open(url);
        return this;
    }

    /**
     * Checks if the login page is open
     * @return LoginPage object
     */
    public LoginPage isOpened() {
        log.info("Checking if login page is open");
        EMAIL_ADDRESS.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Fills the login form with the provided details
     * @param emailAddress The login (email) address
     * @param password The password
     * @return LoginPage object
     */
    private LoginPage fillLoginForm(String emailAddress, String password) {
        log.info("Filling login form with email address and password");
        new Input("email").write(emailAddress);
        new Input("passwd").write(password);
        /*isOpened();
        EMAIL_ADDRESS.setValue(emailAddress);
        PASSWORD.setValue(password);
        SIGN_IN_BUTTON.click();*/
        return this;
    }

    /**
     * Completes the login process by filling the form and clicking the Login button
     * @param emailAddress The email address
     * @param password The password
     * @return LoginPage object
     */
    public MyAccountPage login(String emailAddress, String password) {
        //isOpened();
        fillLoginForm(emailAddress, password);
        log.info("Clicking Login button to complete login");
        wait.until(ExpectedConditions.visibilityOf(TITLE_XPATH));
        new Button().click(SIGN_IN_BUTTON);
        return new MyAccountPage();
    }

    /**
     * Gets the login failed message displayed on the login page
     * @return The login failed message
     */
    public String getLoginFieldErrorMessageText() {
        log.info("Getting login failed message from login page");
        return LOGIN_URL_FIELD_ERROR.getText();
    }
}