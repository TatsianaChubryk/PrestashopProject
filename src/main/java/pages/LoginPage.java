package pages;

import elements.Button;
import static com.codeborne.selenide.Selenide.open;
import static constants.IConstants.*;

public class LoginPage extends BasePage {
   /* public static final SelenideElement EMAIL_ADDRESS = $x("//*[@id='email']");
    public static final SelenideElement PASSWORD = $x("//*[@id='passwd']");
    public static final SelenideElement SIGN_IN_BUTTON = $x("//*[@id='SubmitLogin']");
    public static final SelenideElement TITLE_XPATH = $x("//*[@id='center_column']/h1");
    public static final SelenideElement EMPTY_FIELD_EMAIL_ERROR = $x("//*[@id='center_column']/div[1]/ol/li/text()");
*/
    public LoginPage openLoginPage(String url) {
        open(url);
        return this;
    }

    private LoginPage fillLoginForm(String emailAddress, String password) {
        EMAIL_ADDRESS.setValue(emailAddress);
        PASSWORD.setValue(password);
        new Button().click(SIGN_IN_BUTTON);
        return this;
    }

    public LoginPage login(String email, String password) {
        fillLoginForm(email, password);
        return new LoginPage();
    }

    /*public LoginPage(WebDriver driver) {
        super(driver);
    }*/

    /*public LoginPage openPage(String url) {
        open(LOGIN_PAGE_URL);
        return this;
    }*/

 /*   public LoginPage login(String emailAddress, String password) {
        new Input("email").write(emailAddress);
        new Input("password").write(password);
        new Button().click(SIGN_IN_BUTTON);
        return this;
    }*/

    /*public void login(User user) {
        EMAIL_ADDRESS.sendKeys(user.getEmailAddress());
        PASSWORD.sendKeys(user.getPassword());
        SIGN_IN_BUTTON.click();

    }

    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) SIGN_IN_BUTTON));
        return this;
    }*/
}