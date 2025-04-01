package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import retry.PropertyReader;
import steps.LoginSteps;

import java.util.HashMap;
import java.util.Map;;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest extends BasePage {
    protected LoginSteps loginSteps;

    public static String LOGIN_PAGE_URL = PropertyReader.getProperty("loginUrl");
    public static String EMAIL_ADDRESS = PropertyReader.getProperty("email");
    public static String INVALID_EMAIL_ADDRESS = PropertyReader.getProperty("incorrectEmail");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String INVALID_PASSWORD = PropertyReader.getProperty("incorrectPassword");
    public static String TITLE = PropertyReader.getProperty("title");
    public static String EMPTY_FIELD_EMAIL_ERROR_TEXT = PropertyReader.getProperty("emptyEmailError");
    public static String EMPTY_FIELD_PASSWORD_ERROR_TEXT = PropertyReader.getProperty("emptyPasswordError");
    public static String INVALID_PASSWORD_ERROR_TEXT = PropertyReader.getProperty("invalidPasswordError");
    public static String INVALID_EMAIL_ERROR_TEXT = PropertyReader.getProperty("invalidEmailError");

    public void initPages() {
        loginSteps = new LoginSteps();
    }

    @BeforeMethod
    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        initPages();
    }

  /*  @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }*/
}