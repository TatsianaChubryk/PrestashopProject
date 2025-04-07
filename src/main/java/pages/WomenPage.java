package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
@Getter
public class WomenPage extends BasePage {

    SelenideElement PRODUCTS_NAME_LIST = $x("//*[@itemprop='name']");
    SelenideElement PRODUCTS_PRICE_LIST = $x("//*[@class='price product-price']");
    SelenideElement CHOOSE_SORT_BY_PRICE_HIGHEST_FIRST = $x("//*[@id='selectProductSort']/option[3]");
    SelenideElement CHOOSE_SORT_A_TO_Z = $x("//*[@id='selectProductSort']/option[4]");

    public WomenPage() {}

    /**
     * This is choosing sorting by Price: Highest first
     * @return WomenPage object
     */
    public WomenPage chooseSortByPrice() {
        log.info("Select sorting by Price: Highest first");
        CHOOSE_SORT_BY_PRICE_HIGHEST_FIRST.click();
        return this;
    }

    /**
     * The currency sign and spaces are removed and converted to a number
     * @param priceText
     * @return
     */
    private Double parsePrice(String priceText) {
        try {
            return Double.parseDouble(priceText.replace("₴", "").trim());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing price: " + priceText);
            return null;
        }
    }

    /**
     * Getting all items with prices and check sorting
     * @return prices
     */
    public List<Double> getProductPrices() {
        List<Double> prices = $$(".product-price").texts()
                .stream()
                .map(this::parsePrice)
                .filter(price -> price != null)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        log.info("Price parsing completed. Filtered prices: {}", prices);
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        log.info("Sorted list{}", sortedPrices);
        Assert.assertTrue(sortedPrices.equals(prices));
        return prices;
    }

    /**
     * This is choosing sorting by Name
     * @return WomenPage object
     */
    public WomenPage chooseSortByName() {
        CHOOSE_SORT_A_TO_Z.click();
        log.info("Choose sort by name from A to Z");
        return this;
    }

    /**
     * Getting a list of elements and sorting
     * @return nameElements
     */
    public List<String> getProductName() {
        List<SelenideElement> nameElements = Collections.singletonList(PRODUCTS_NAME_LIST);
        log.info("Getting the number of items with product names");
        return nameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}