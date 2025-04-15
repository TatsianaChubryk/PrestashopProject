package tests;

import org.testng.annotations.Test;

import static constants.ITestConstants.ORDER_CONFIRMATION_TEXT;

public class OrderTests extends BaseTests {

    @Test(description = "Successful order and payment for goods")
    public void successfulOrderAndPayment() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        myAccountSteps.openWomenPage();
        womenSteps
                .addItemToCompare(3)
                .addItemToCompare(4)
                .goToComparePage();
        compareSteps
                .addProductToCartWithContinueShopping(1)
                .addProductToCartWithProceed(2);
        cartSteps
                .verifyTotalOrderCalculated()
                .goToAddressesStep();
        orderSteps
                .goToShippingStep()
                .goToPaymentStep()
                .choosePayByBankStep()
                .confirmOrderStep()
                .checkOrderConfirmationStep(ORDER_CONFIRMATION_TEXT);
    }
}