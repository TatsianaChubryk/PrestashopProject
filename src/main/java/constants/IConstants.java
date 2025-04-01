package constants;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public interface IConstants {
    SelenideElement EMAIL_ADDRESS = $x("//*[@id='email']");
    SelenideElement PASSWORD = $x("//*[@id='passwd']");
    SelenideElement SIGN_IN_BUTTON = $x("//*[@id='SubmitLogin']");
    SelenideElement TITLE_XPATH = $x("//*[@id='center_column']/h1");
    SelenideElement LOGIN_URL_FIELD_ERROR = $x("//*[@id='center_column']/div[1]/ol/li");

}