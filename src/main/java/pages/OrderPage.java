package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Checkbox;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class OrderPage extends BasePage {

    private static final SelenideElement PROCEED_ADDRESS_BUTTON = $x("//*[@name='processAddress']");
    private static final SelenideElement PROCEED_CARRIER_BUTTON = $x("//*[@name='processCarrier']");
    private static final SelenideElement PAY_BY_BANK_WIRE = $x("//*[@class='bankwire']");
    private static final SelenideElement CONFIRM_ORDER_BUTTON = $x("//*[@id='cart_navigation']/button");
    private static final SelenideElement COMPLETE_ORDER_TEXT = $x("//*[@id='center_column']/p[1]");

    public OrderPage() {
    }

    /**
     * Go to shipping step
     * @return OrderPage object
     */
    public OrderPage goToShippingStep() {
        log.info("Clicking proceed to checkout button");
        PROCEED_ADDRESS_BUTTON.click();
        return new OrderPage();
    }

    /**
     * Go to payment step
     * @return OrderPage object
     */
    public OrderPage goToPaymentStep() {
        log.info("Clicking proceed to checkout button");
        new Checkbox("cgv").setCheckboxValue(true);
        PROCEED_CARRIER_BUTTON.click();
        return new OrderPage();
    }

    /**
     * Choose Pay by bank wire
     * @return OrderPage object
     */
    public OrderPage choosePayByBank() {
        log.info("Clicking on Pay by bank wire");
        PAY_BY_BANK_WIRE.click();
        return new OrderPage();
    }

    /**
     * Click on confirm order
     * @return OrderPage object
     */
    public OrderPage confirmOrder() {
        log.info("Clicking on confirm order");
        CONFIRM_ORDER_BUTTON.click();
        return new OrderPage();
    }

    /**
     * Check order confirmation
     * @return OrderPage object
     */
    public String checkOrderConfirmation() {
        try {
            log.info("Getting the complete order text");
            return COMPLETE_ORDER_TEXT.getText();
        } catch (Exception e) {
            log.error("Failed to complete order text " + e.getMessage());
            return null;
        }
    }
}