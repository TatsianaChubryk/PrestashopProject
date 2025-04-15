package steps;

import io.qameta.allure.Step;
import pages.WomenPage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenSteps {
    WomenPage womenPage;

    public WomenSteps() {
        this.womenPage = new WomenPage();
    }

    @Step("Select sort by Price: Highest first")
    public WomenSteps selectSortByPrice() {
        womenPage.chooseSortByPrice();
        return this;
    }

    @Step("Checking that sorting by Price: Highest first has been applied")
    public WomenSteps checkAppliedSortByPrice() {
        womenPage.getProductPrices();
        return this;
    }

    @Step("Select sort by Name: A to Z")
    public WomenSteps selectSortByName() {
        womenPage.chooseSortByName();
        return this;
    }

    @Step("Checking that sorting by Name: A to Z")
    public WomenSteps checkAppliedSortByName() {
        List<String> actualSortByName = womenPage.getProductName();
        List<String> sortedProductNames = new ArrayList<>(actualSortByName);
        Collections.sort(sortedProductNames, Collections.reverseOrder());
        Assert.assertEquals(sortedProductNames, actualSortByName);
        return this;
    }

    @Step("Select sort by Categories: Dresses")
    public WomenSteps selectSortByCategories() {
        womenPage.chooseSortByCategories();
        return this;
    }

    @Step("Checking Dresses title")
    public WomenSteps checkDressesTitle(String titleText) {
        Assert.assertEquals(womenPage.getDressesTitle(), titleText);
        return this;
    }

    @Step("Add item to compare")
    public WomenSteps addItemToCompare(int itemIndex) {
        womenPage.addItemToCompare(itemIndex);
        return this;
    }

    @Step("Open Compare page")
    public void goToComparePage() {
        womenPage.goToComparePage();
    }
}