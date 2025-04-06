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
    SelenideElement REGISTER_BUTTON = $x("//*[@id='submitAccount']");
    SelenideElement TITLE_XPATH = $x("//*[@id='center_column']/h1");
    SelenideElement personalInformationTitle = $x("//*[@id='account-creation_form']/div[1]/h3");

    public RegistrationPage() {}

    /**
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
        new Checkbox("optin").setCheckboxValue(true);
        log.info("Clicking Create button to continue registration");
        new Button().click(REGISTER_BUTTON);
        return new MyAccountPage();
    }
}