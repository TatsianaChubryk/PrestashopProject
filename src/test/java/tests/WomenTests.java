package tests;

import org.testng.annotations.Test;

import static constants.ITestConstants.DRESSES_TITLE;

public class WomenTests extends BaseTests {

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

    @Test(description = "Check sort by Categories: Dresses")
    public void checkingSortByCategories() {
        loginSteps.login(EMAIL_ADDRESS, PASSWORD, LOGIN_PAGE_URL);
        myAccountSteps.openWomenPage();
        womenSteps
                .selectSortByCategories()
                .checkDressesTitle(DRESSES_TITLE);
    }
}