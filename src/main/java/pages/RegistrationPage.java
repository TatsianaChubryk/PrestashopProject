package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Checkbox;
import elements.Input;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
@Getter
public class RegistrationPage extends BasePage {
    private static final SelenideElement REGISTER_BUTTON = $x("//*[@id='submitAccount']");
    private final SelenideElement TITLE_XPATH = $x("//*[@id='center_column']/h1");
    private final SelenideElement PERSONAL_INFORMATION_TITLE = $x("//*[@id='account-creation_form']/div[1]/h3");
    private static final SelenideElement REGISTRATION_URL_FIELD_ERROR = $x("//*[@id='create_account_error']/ol/li");
    private static final SelenideElement REGISTRATION_FIELD_ERROR = $x("//*[@id='center_column']/div/ol/li[1]");

    public RegistrationPage() {
    }

    /**public static final
     * Fills the registration form with the provided details
     * @param firstName The first name
     * @param lastName The last name
     * @param registrationEmail The registration email
     * @param password The password
     * @return RegistrationPage object
     */
    private RegistrationPage fillSecondStepRegistration(String firstName, String lastName, String registrationEmail, String password) {
        log.info("Filling registration form with email, password, password hint.");
        new Checkbox("id_gender2").setCheckboxValue(true);
        new Input("customer_firstname").write(firstName);
        new Input("customer_lastname").write(lastName);
        new Input("email").write(registrationEmail);
        new Input("passwd").write(password);
        return this;
    }

    /**
     * Finisg the registration process by filling the form and clicking the Create button
     * @param firstName The first name
     * @param lastName The last name
     * @param registrationEmail The registration email
     * @param password The password
     * @return MyAccountPage object
     */
    public MyAccountPage secondStepRegistration(String firstName, String lastName, String registrationEmail, String password) {
        fillSecondStepRegistration(firstName, lastName, registrationEmail, password);
        new Checkbox("newsletter").setCheckboxValue(true);
        log.info("Clicking Create button to continue registration");
        new Button().click(REGISTER_BUTTON);
        return new MyAccountPage();
    }

    /**
     * Gets the email failed message displayed on the registration form
     * @return The login failed message
     */
    public String getRegistrationEmailErrorMessageText() {
        try {
            log.info("Getting the email failed message displayed on the registration form");
            return REGISTRATION_URL_FIELD_ERROR.getText();
        } catch (Exception e) {
            log.error("Failed to get email field error message: " + e.getMessage());
            return "";
        }
    }

    /**
     * Gets the failed message displayed on the registration form
     * @return The login failed message
     */
    public String getRegistrationErrorMessageText() {
        try {
            log.info("Getting the failed message displayed on the registration form");
            return REGISTRATION_FIELD_ERROR.getText();
        } catch (Exception e) {
            log.error("Failed to failed message displayed on the registration form error message: " + e.getMessage());
            return "";
        }
    }
}