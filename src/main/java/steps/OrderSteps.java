package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.OrderPage;

public class OrderSteps {
    OrderPage orderPage;

    public OrderSteps() {
        this.orderPage = new OrderPage();
    }

    @Step("Go to the Shipping step")
    public OrderSteps goToShippingStep() {
        orderPage.goToShippingStep();
        return this;
    }

    @Step("Go to payment step")
    public OrderSteps goToPaymentStep() {
        orderPage.goToPaymentStep();
        return this;
    }

    @Step("Choose Pay By Bank")
    public OrderSteps choosePayByBankStep() {
        orderPage.choosePayByBank();
        return this;
    }

    @Step("Confirm order")
    public OrderSteps confirmOrderStep() {
        orderPage.confirmOrder();
        return this;
    }

    @Step("Checking My Account title")
    public OrderSteps checkOrderConfirmationStep(String titleText) {
        Assert.assertEquals(orderPage.checkOrderConfirmation(), titleText);
        return this;
    }
}