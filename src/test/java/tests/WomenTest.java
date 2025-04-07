package tests;

import org.testng.annotations.Test;

public class WomenTest extends BaseTest {

    @Test(description = "Check sort by Price: Highest first")
    public void checkingSortByPrice() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        myAccountSteps.openWomenPage();
        womenSteps
                .selectSortByPrice()
                .checkAppliedSortByPrice();
    }

    @Test(description = "Check sort by name from A to Z")
    public void checkingSortByName() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        myAccountSteps.openWomenPage();
        womenSteps
                .selectSortByName()
                .checkAppliedSortByName();
    }
}