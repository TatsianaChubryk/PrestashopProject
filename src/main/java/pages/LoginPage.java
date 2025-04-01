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
}