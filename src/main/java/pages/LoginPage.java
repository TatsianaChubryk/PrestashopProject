package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;
import waiters.Waiter;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Getter
@Log4j2
public class LoginPage extends BasePage {
    private static final SelenideElement EMAIL_ADDRESS = $x("//*[@id='email']");
    private static final SelenideElement SIGN_IN_BUTTON = $x("//*[@id='SubmitLogin']");
    private static final SelenideElement CREATE_ACCOUNT_BUTTON = $x("//*[@id='SubmitCreate']");
    private static final SelenideElement TITLE_XPATH = $x("//*[@id='center_column']/h1");
    private static final SelenideElement LOGIN_URL_FIELD_ERROR = $x("//*[@id='center_column']/div[1]/ol/li");
    private final SelenideElement PASSWORD = $x("//*[@id='passwd']");
    private final SelenideElement REGISTER_BUTTON = $x("//*[@id='submitAccount']");

    Waiter waiter = new Waiter();

    public LoginPage() {
    }

    /**
     *
     * @param url
     * @return LoginPage object
     */
    public LoginPage openLoginPage(String url) {
        waiter.waitForPageLoaded();
        log.info("Opening login page: " + url);
        open(url);
        return this;
    }

    /**
     * Checks if the login page is open
     * @return LoginPage object
     */
    public LoginPage isOpened() {
        try {
            log.info("Checking if login page is open");
            EMAIL_ADDRESS.shouldBe(Condition.visible);
            return this;
        } catch (Exception e) {
            log.error("Login page is not open or elements are not visible: " + e.getMessage());
            throw e;
        }
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
        return this;
    }

    /**
     * Completes the login process by filling the form and clicking the Login button
     * @param emailAddress The email address
     * @param password The password
     * @return MyAccountPage object
     */
    public MyAccountPage login(String emailAddress, String password) {
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
        try {
            log.info("Getting login failed message from login page");
            return LOGIN_URL_FIELD_ERROR.getText();
        } catch (Exception e) {
            log.error("Failed to get login field error message: " + e.getMessage());
            return "";
        }
    }

    /**
     * Start the registration process by filling the form and clicking the Create button
     * @param emailAddress The email address
     * @return RegistrationPage object
     */
    public RegistrationPage firstStepRegistration(String emailAddress) {
        log.info("Filling registration form with email address");
        new Input("email_create").write(emailAddress);
        log.info("Clicking Create button to continue registration");
        wait.until(ExpectedConditions.visibilityOf(TITLE_XPATH));
        new Button().click(CREATE_ACCOUNT_BUTTON);
        return new RegistrationPage();
    }
}