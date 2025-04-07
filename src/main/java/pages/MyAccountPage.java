package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
@Getter
public class MyAccountPage extends BasePage{
    private final SelenideElement myAccountTitle = $x("//*[@id='center_column']/h1");
    private final SelenideElement accountCreatedText = $x("//*[@id='center_column']/p[1]/text()");
    private final SelenideElement WOMEN_BUTTON = $x("//*[@id='block_top_menu']/ul/li[1]/a");

    public MyAccountPage() {}

    /**
     *
     * @return WomenPage object
     */
    public WomenPage openWomenPage() {
        log.info("Opening women page");
        WOMEN_BUTTON.click();
        return new WomenPage();
    }
}