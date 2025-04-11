package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Log4j2
public class CartPage extends BasePage {
    private ElementsCollection namesProductsInCart = $$(".cart_ref");
    private final SelenideElement INCREASE_QUANTITY_BUTTON = $x("//*[@class='icon-plus']");

    public CartPage() {
    }

    /**
     * Click delete button in Cart
     * @param indexItem
     * @return CartPage object
     */
    public CartPage removeProductFromCart(int indexItem) {
        log.info("Clicking delete button in Cart");
        $$(".cart_quantity_delete").get(indexItem).click();
        return new CartPage();
    }

    /**
     * Get names products in shopping cart list
     * @return the list of product names
     */
    public List<String> getNamesProductsInShoppingCart() {
        log.info("Getting names products in shopping cart list");
        List<String> list = new ArrayList<>();
        for (SelenideElement item : namesProductsInCart){
            list.add(item.getText());
        }
        return list;
    }

    /**
     * Click increase button in Cart
     * @return CartPage object
     */
    public CartPage increaseQuantityInCart() {
        log.info("Clicking increase button in Cart");
        INCREASE_QUANTITY_BUTTON.click();
        return this;
    }
}