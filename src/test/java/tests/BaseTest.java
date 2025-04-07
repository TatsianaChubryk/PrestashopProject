package tests;

import com.codeborne.selenide.Configuration;
import listeners.TestListener;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;
import pages.WomenPage;
import steps.MyAccountSteps;
import steps.RegistrationSteps;
import steps.WomenSteps;
import utils.PropertyReader;
import steps.LoginSteps;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    public static String LOGIN_PAGE_URL = PropertyReader.getProperty("loginUrl");
    public static String EMAIL_ADDRESS = PropertyReader.getProperty("email");
    public static String REGISTRATION_EMAIL_ADDRESS = PropertyReader.getProperty("registrationEmail");
    public static String INVALID_EMAIL_ADDRESS = PropertyReader.getProperty("incorrectEmail");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String INVALID_PASSWORD = PropertyReader.getProperty("incorrectPassword");
    public static String FIRST_NAME = PropertyReader.getProperty("firstName");
    public static String LAST_NAME = PropertyReader.getProperty("LastName");

    protected LoginSteps loginSteps;
    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;
    protected RegistrationSteps registrationSteps;
    protected RegistrationPage registrationPage;
    protected WomenPage womenPage;
    protected WomenSteps womenSteps;
    protected MyAccountSteps myAccountSteps;

    public void initPages() {
        loginSteps = new LoginSteps();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        registrationSteps = new RegistrationSteps();
        registrationPage = new RegistrationPage();
        womenPage = new WomenPage();
        womenSteps = new WomenSteps();
        myAccountSteps = new MyAccountSteps();
    }

    @BeforeMethod
    public void initTest() {
        log.info("Initializing test environment");
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
        log.info("Ending test");
    }*/
}