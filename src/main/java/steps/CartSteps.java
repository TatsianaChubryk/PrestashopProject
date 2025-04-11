package steps;

import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import pages.CartPage;
import java.util.List;

public class CartSteps {
    CartPage cartPage;

    public CartSteps() {
        this.cartPage = new CartPage();
    }

    @Step("Deleting an item from the cart")
    public CartSteps removeProductFromCart(int indexItem) {
        cartPage.removeProductFromCart(indexItem);
        return this;
    }

    @Step("Checking that a product is not in the cart")
    public void verifyProductIsNotInCart(String productName) {
        List<String> productsListInCart = cartPage.getNamesProductsInShoppingCart();
        boolean productFound = false;
        for (String item : productsListInCart) {
            if (item.contains(productName)) {
                productFound = true;
                break;
            }
        }
        Assert.assertFalse(productFound, "Товар '" + productName + "' все еще присутствует в корзине.");
    }

    @Step("Increase the number of items in the cart")
    public void increaseQuantityInCart() {
        cartPage.increaseQuantityInCart();
    }

    @Step("Decrease the number of items in the cart")
    public void decreaseQuantityInCart() {
        cartPage.increaseQuantityInCart();
    }

    @Step("Verify total calculated")
    public void verifyTotalCalculated() {
        double unitPrice = cartPage.getUnitPrice();
        int quantity = cartPage.getProductQuantity();
        double expectedTotal = unitPrice * quantity;
        double actualTotal = cartPage.getTotalValue();
        Assert.assertEquals(actualTotal,expectedTotal);
    }

    @Step("Verify total order calculated")
    public void verifyTotalOrderCalculated() {
        double totalProducts = cartPage.getTotalProducts();
        double totalShipping = cartPage.getTotalShipping();
        double expectedTotalOrderSum = totalProducts + totalShipping;
        double actualTotalOrderSum = cartPage.getTotalOrderSum();
        Assert.assertEquals(actualTotalOrderSum, expectedTotalOrderSum);
    }
}