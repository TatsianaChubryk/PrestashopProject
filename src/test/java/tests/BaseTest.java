package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.PropertyReader;
import steps.LoginSteps;

import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    public static String LOGIN_PAGE_URL = PropertyReader.getProperty("loginUrl");
    public static String EMAIL_ADDRESS = PropertyReader.getProperty("email");
    public static String INVALID_EMAIL_ADDRESS = PropertyReader.getProperty("incorrectEmail");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String INVALID_PASSWORD = PropertyReader.getProperty("incorrectPassword");

    protected LoginSteps loginSteps;
    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;

    public void initPages() {
        loginSteps = new LoginSteps();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
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