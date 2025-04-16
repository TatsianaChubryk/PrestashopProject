package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ComparePage extends BasePage {
    private static final SelenideElement PROCEED_BUTTON = $x("//*[@class='btn btn-default button button-medium']");
    private static final SelenideElement CONTINUE_SHOPPING_BUTTON = $x("//*[@class='continue btn btn-default button exclusive-medium']");
    private static final ElementsCollection BLOCK_PRODUCT = $$(".button-container");
    private static final String ADD_TO_CART = "a[title='Add to cart']";

    public ComparePage() {
    }

    /**
     * Add product to cart with continue shopping
     * @param indexItem
     * @return CartPage object
     */
    public CartPage addProductToCartWithContinueShopping(int indexItem) {
        log.info("Adding a product by index to cart");
        SelenideElement blockProduct = BLOCK_PRODUCT.get(indexItem);
        blockProduct.$(ADD_TO_CART).click();
        log.info("Clicking Continue button in shopping cart");
        CONTINUE_SHOPPING_BUTTON.click();
        return new CartPage();
    }

    /**
     * Add product to cart with proceed
     * @param indexItem
     * @return CartPage object
     */
    public CartPage addProductToCartWithProceed(int indexItem) {
        log.info("Adding a product to the cart by index");
        SelenideElement blockProduct = BLOCK_PRODUCT.get(indexItem);
        blockProduct.$(ADD_TO_CART).click();
        log.info("Clicking Procced button in shopping cart");
        PROCEED_BUTTON.click();
        return new CartPage();
    }
}