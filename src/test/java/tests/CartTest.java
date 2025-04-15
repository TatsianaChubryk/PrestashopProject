package tests;

import org.testng.annotations.Test;

import static constants.ITestConstants.DEMO_SIX;

public class CartTest extends BaseTests {

    @Test(description = "Checking the removal of items in the cart")
    public void removeItemFromCart() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        myAccountSteps.openWomenPage();
        womenSteps
                .addItemToCompare(1)
                .addItemToCompare(5)
                .goToComparePage();
        compareSteps
                .addProductToCartWithContinueShopping(1)
                .addProductToCartWithProceed(2);
        cartSteps
                .removeProductFromCart(0)
                .verifyProductIsNotInCart(DEMO_SIX);
    }

    @Test(description = "Calculation of the value in the 'Total' field when the quantity of goods increases")
    public void calculationTotalWhenIncreasing() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        myAccountSteps.openWomenPage();
        womenSteps
                .addItemToCompare(3)
                .goToComparePage();
        compareSteps.addProductToCartWithProceed(1);
        cartSteps
                .increaseQuantityInCart()
                .verifyTotalCalculated();
    }

    @Test(description = "Calculation of the value in the 'Total' field when the quantity of goods decreases")
    public void calculationTotalWhenDecreasing() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        myAccountSteps.openWomenPage();
        womenSteps
                .addItemToCompare(3)
                .goToComparePage();
        compareSteps.addProductToCartWithProceed(1);
        cartSteps
                .increaseQuantityInCart()
                .decreaseQuantityInCart()
                .verifyTotalCalculated();
    }

    @Test(description = "Calculation of the value in the 'Total' for the entire order")
    public void calculationTotalOrder() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        myAccountSteps.openWomenPage();
        womenSteps
                .addItemToCompare(3)
                .addItemToCompare(4)
                .goToComparePage();
        compareSteps
                .addProductToCartWithContinueShopping(1)
                .addProductToCartWithProceed(2);
        cartSteps.verifyTotalOrderCalculated();
    }
}