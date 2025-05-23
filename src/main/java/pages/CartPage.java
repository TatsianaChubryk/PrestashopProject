package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import waiters.Waiter;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Log4j2
public class CartPage extends BasePage {
    private static final ElementsCollection NAMES_PRODUCTS_IN_CART = $$(".cart_ref");
    private static final SelenideElement INCREASE_QUANTITY_BUTTON = $x("//*[@class='icon-plus']");
    private static final SelenideElement PROCEED_BUTTON = $x("//*[@id='center_column']/p[2]/a[1]");
    private static final SelenideElement UNIT_PRICE_ELEMENT = $x("//*[@class='cart_unit']//li");
    private static final SelenideElement QUANTITY_ELEMENT = $x("//*[@class='cart_quantity text-center']/input[1]");
    private static final SelenideElement TOTAL_ELEMENT = $x("//*[@class='cart_total']/span");
    private static final SelenideElement UNIT_TOTAL_ELEMENT = $x("//*[@id='total_product']");
    private static final SelenideElement UNIT_TOTAL_SHIPPING_ELEMENT = $x("//*[@id='total_shipping']");
    private static final SelenideElement UNIT_TOTAL = $x("//*[@id='total_price']");
    private static final ElementsCollection REMOVE_BUTTON = $$(".cart_quantity_delete");

    Waiter waiter = new Waiter();

    public CartPage() {
    }

    /**
     * Click delete button in Cart
     * @param indexItem
     * @return CartPage object
     */
    public CartPage removeProductFromCartByIndex(int indexItem) {
        log.info("Clicking delete button in Cart");
        REMOVE_BUTTON.get(indexItem).click();
        return this;
    }

    /**
     * Get names products in shopping cart list
     * @return the list of product names
     */
    public List<String> getNamesProductsInShoppingCart() {
        log.info("Getting product names from cart");
        return NAMES_PRODUCTS_IN_CART.texts();
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

    /**
     * Parsing price
     * @param priceText
     * @return priceText
     */
    public static double parsePrice(String priceText) {
        log.info("Parsing price");
        return Double.parseDouble(priceText.replace("$", "").trim());
    }

    /**
     * Get the price per unit of goods
     *
     * @return unitPriceText
     */
    public double getUnitPrice() {
        log.info("Parsing price element");
        String unitPriceText = UNIT_PRICE_ELEMENT.getText();
        return parsePrice(unitPriceText);
    }

    /**
     * Get the current quantity of goods
     * @return quantityText
     */
    public int getProductQuantity() {
        log.info("Getting the current quantity of good");
        String quantityText = QUANTITY_ELEMENT.getAttribute("value");
        return Integer.parseInt(quantityText);
    }

    /**
     * Get the total cost
     * @return totalPriceText
     */
    public double getTotalValue() {
        log.info("Getting total cost");
        String totalPriceText = TOTAL_ELEMENT.getText();
        return parsePrice(totalPriceText);
    }

    /**
     * Get the total price of goods
     * @return unitPriceText
     */
    public double getTotalProducts() {
        log.info("Parsing total products price");
        String unitPriceText = UNIT_TOTAL_ELEMENT.getText();
        return parsePrice(unitPriceText);
    }

    /**
     * Get the total shipping
     * @return unitTotalShippingText
     */
    public double getTotalShipping() {
        log.info("Parsing total shipping");
        String unitTotalShippingText = UNIT_TOTAL_SHIPPING_ELEMENT.getText();
        return parsePrice(unitTotalShippingText);
    }

    /**
     * Get the total
     * @return unitTotalShippingText
     */
    public double getTotalOrderSum() {
        log.info("Parsing total");
        String unitTotalText = UNIT_TOTAL.getText();
        return parsePrice(unitTotalText);
    }

    /**
     * Go to address step
     * @return OrderPage object
     */
    public OrderPage goToAddressesStep() {
        waiter.waitForPageLoaded();
        log.info("Clicking proceed to checkout button");
        PROCEED_BUTTON.click();
        return new OrderPage();
    }
}