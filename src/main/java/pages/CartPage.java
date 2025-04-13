package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import waiters.Waiter;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
@Log4j2
public class CartPage extends BasePage {
    private ElementsCollection NAMES_PRODUCTS_IN_CART = $$(".cart_ref");
    private final SelenideElement INCREASE_QUANTITY_BUTTON = $x("//*[@class='icon-plus']");
    private final SelenideElement PROCCED_BUTTON = $x("//*[@id='center_column']/p[2]/a[1]");

    Waiter waiter = new Waiter();

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
        for (SelenideElement item : NAMES_PRODUCTS_IN_CART){
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

    /**
     * Get the price per unit of goods
     * @return unitPriceText
     */
    public double getUnitPrice() {
        log.info("Parsing price");
        SelenideElement unitPriceElement = $x("//*[@class='cart_unit']//li");
        String unitPriceText = unitPriceElement.getText().replace("$", "").trim(); // Удаляем символы, если необходимо
        return Double.parseDouble(unitPriceText);
    }

    /**
     * Get the current quantity of goods
     * @return quantityText
     */
    public int getProductQuantity() {
        log.info("Getting the current quantity of good");
        SelenideElement quantityElement = $x("//*[@class='cart_quantity text-center']/input[1]");
        String quantityText = quantityElement.getAttribute("value");
        return Integer.parseInt(quantityText);
    }

    /**
     * Get the total cost
     * @return totalPriceText
     */
    public double getTotalValue() {
        log.info("Getting total cost");
        SelenideElement totalElement = $x("//*[@class='cart_total']/span");
        String totalPriceText = totalElement.getText().replace("$", "").trim();
        return Double.parseDouble(totalPriceText);
    }

    /**
     * Get the total price of goods
     * @return unitPriceText
     */
    public double getTotalProducts() {
        log.info("Parsing total products price");
        SelenideElement unitTotalElement = $x("//*[@id='total_product']");
        String unitPriceText = unitTotalElement.getText().replace("$", "").trim();
        return Double.parseDouble(unitPriceText);
    }

    /**
     * Get the total shipping
     * @return unitTotalShippingText
     */
    public double getTotalShipping() {
        log.info("Parsing total shipping");
        SelenideElement unitTotalShippingElement = $x("//*[@id='total_shipping']");
        String unitTotalShippingText = unitTotalShippingElement.getText().replace("$", "").trim();
        return Double.parseDouble(unitTotalShippingText);
    }

    /**
     * Get the total
     * @return unitTotalShippingText
     */
    public double getTotalOrderSum() {
        log.info("Parsing total");
        SelenideElement unitTotal = $x("//*[@id='total_price']");
        String unitTotalText = unitTotal.getText().replace("$", "").trim();
        return Double.parseDouble(unitTotalText);
    }

    /**
     * Go to address step
     * @return OrderPage object
     */
    public OrderPage goToAddressesStep() {
        waiter.waitForPageLoaded();
        log.info("Clicking proceed to checkout button");
        PROCCED_BUTTON.click();
        return new OrderPage();
    }
}