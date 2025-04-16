package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
@Getter
public class MyAccountPage extends BasePage{
    private static final SelenideElement MY_ACCOUNT_TITLE = $x("//*[@id='center_column']/h1");
    private static final SelenideElement WOMEN_BUTTON = $x("//*[@id='block_top_menu']/ul/li[1]/a");

    public MyAccountPage() {}

    /**
     * Open Women page
     * @return WomenPage object
     */
    public WomenPage openWomenPage() {
        log.info("Opening women page");
        WOMEN_BUTTON.click();
        return new WomenPage();
    }

    /**
     * Getting the account title on the My Account page
     * @return MY_ACCOUNT_TITLE
     */
    public String getMyAccountTitle() {
        try {
            log.info("Getting the account title on the My Account page");
            return MY_ACCOUNT_TITLE.getText();
        } catch (Exception e) {
            log.error("Failed to failed account title on the My Account page " + e.getMessage());
            return null;
        }
    }
}