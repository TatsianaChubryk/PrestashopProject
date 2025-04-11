package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
@Getter
public class WomenPage extends BasePage {

    private final SelenideElement PRODUCTS_NAME_LIST = $x("//*[@itemprop='name']");
    private final SelenideElement PRODUCTS_PRICE_LIST = $x("//*[@class='price product-price']");
    private final SelenideElement CHOOSE_SORT_BY_PRICE_HIGHEST_FIRST = $x("//*[@id='selectProductSort']/option[3]");
    private final SelenideElement CHOOSE_SORT_A_TO_Z = $x("//*[@id='selectProductSort']/option[4]");
    private final SelenideElement CHOOSE_SORT_BY_CATEGORIES = $x("//*[@id='layered_category_8']");
    private final SelenideElement DRESSES_TITLE = $x("//*[@id='center_column']/h1/span[1]");
    private final SelenideElement BLOCK_PRODUCT = $x("//*[contains(@class, 'ajax_block_product')]");
    private final SelenideElement ADD_TO_COMPARE = $(".addToCompare");
    private final SelenideElement COMPARE_BUTTON = $x("//*[@class='btn btn-default button button-medium bt_compare bt_compare']");
    private final ElementsCollection productContainer = $$(".product-container");
    private final SelenideElement addToCompareButton = $(".add_to_compare");


    public WomenPage() {
    }

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

    /**
     * This is choosing sorting by Categories: Dresses
     * @return WomenPage object
     */
    public WomenPage chooseSortByCategories() {
        log.info("Select sorting by Categories: Dresses");
        CHOOSE_SORT_BY_CATEGORIES.click();
        return this;
    }

    /**
     * Getting a list of elements Dress
     * @return nameElements
     */
    public String getDressesTitle() {
        try {
            log.info("Getting the Dresses title on the page");
            return DRESSES_TITLE.getText();
        } catch (Exception e) {
            log.error("Failed to failed title on the page " + e.getMessage());
            return null;
        }
    }

    /**
     * Add item to compare
     * @param indexItem
     * @return WomenPage object
     */
    public WomenPage addItemToCompare(int indexItem) {
        log.info("Search container by name");
        SelenideElement blockProduct = productContainer.get(indexItem);
        blockProduct.hover();
        log.info("Clicking Add to compare button");
        blockProduct.$(".add_to_compare").click();
        return this;
    }

    /**
     * Open Compare page
     * @return WomenPage object
     */
    public ComparePage goToComparePage() {
        log.info("Clicking Compare button");
        new Button().click(COMPARE_BUTTON);
        return new ComparePage();
    }
}