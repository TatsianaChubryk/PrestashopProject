package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ComparePage extends BasePage {
    private final SelenideElement PROCEED_BUTTON = $x("//*[@class='btn btn-default button button-medium']");
    private final SelenideElement CONTINUE_SHOPPING_BUTTON = $x("//*[@class='continue btn btn-default button exclusive-medium']");

    public ComparePage() {
    }

    /**
     * Add product to cart with continue shopping
     * @param indexItem
     * @return CartPage object
     */
    public CartPage addProductToCartWithContinueShopping(int indexItem) {
        log.info("Adding a product by index to cart");
        SelenideElement blockProduct = $$(".button-container").get(indexItem);
        blockProduct.$("a[title='Add to cart']").click();
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
        SelenideElement blockProduct = $$(".button-container").get(indexItem);
        blockProduct.$("a[title='Add to cart']").click();
        log.info("Clicking Procced button in shopping cart");
        PROCEED_BUTTON.click();
        return new CartPage();
    }
}