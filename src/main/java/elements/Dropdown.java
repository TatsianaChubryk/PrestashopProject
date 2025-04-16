package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    private static final String DROPDOWN_XPATH = "//select[@id='%s']";
    private static final String DROPDOWN_OPTION_XPATH = DROPDOWN_XPATH + "/option[@value=%s]";
    String label;

    public Dropdown(String label) {
        this.label = label;
    }

    public void selectByOption(String option) {
        $x(String.format(DROPDOWN_XPATH + "/parent::div", label)).shouldBe(Condition.visible).click();
        $x(String.format(DROPDOWN_OPTION_XPATH, label, option)).shouldBe(Condition.visible).click();
    }
}