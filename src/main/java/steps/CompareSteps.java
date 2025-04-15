package steps;

import io.qameta.allure.Step;
import pages.ComparePage;

public class CompareSteps {
    ComparePage comparePage;

    public CompareSteps() {
        this.comparePage = new ComparePage();
    }

    @Step("Add product to cart with continue shopping")
    public CompareSteps addProductToCartWithContinueShopping(int indexItem) {
        comparePage.addProductToCartWithContinueShopping(indexItem);
        return this;
    }

    @Step("Add product to cart with proceed")
    public CompareSteps addProductToCartWithProceed(int indexItem) {
        comparePage.addProductToCartWithProceed(indexItem);
        return this;
    }
}
