package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class MyAccountPage extends BasePage{
    private final SelenideElement myAccountTitle = $x("//*[@id='center_column']/h1");

}
