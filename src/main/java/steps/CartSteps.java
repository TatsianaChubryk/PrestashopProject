package steps;

import io.qameta.allure.Step;
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
}