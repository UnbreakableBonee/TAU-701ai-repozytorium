package pl.kisiel.tau.labfour.tests;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.kisiel.tau.labfour.seleniumpage.HomePage;
import pl.kisiel.tau.labfour.seleniumpage.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pl.kisiel.tau.labfour.seleniumpage.MyAccountPage;
import pl.kisiel.tau.labfour.seleniumpage.RegisterPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisterPageTest {

    private static WebDriver driver;

    @BeforeClass
    public static void driverSetup() {

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testFailRegister() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        RegisterPage register = new RegisterPage(driver);
        home.signinButtonClick();
        login.setRegisterEmailFieldText("sebastjan@kisiel.pl");
        login.registerButtonClick();
        register.setFirstNameField("imie");
        register.submitButtonClick();
        assertThat(register.isValidateError(),equalTo(true));
    }

    @Test
    public void testSuccessFullRegister() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        RegisterPage register = new RegisterPage(driver);
        MyAccountPage myAccount = new MyAccountPage(driver);
        home.signinButtonClick();
        Random random = new Random();
        int constantLogin = random.nextInt(1000000);
        String loginUser = "sebastjan"+constantLogin+"@kisiel.pl";
        login.setRegisterEmailFieldText(loginUser);
        login.registerButtonClick();
        register.setAddressField("szuberta");
        register.setCityField("gdansk");
        register.setEmailField(loginUser);
        register.setFirstNameField("sebastian");
        register.setLastNameField("kisiel");
        register.setMobilePhoneField("123456789");
        register.setPasswordField("taktak");
        register.chooseCountry();
        register.chooseState();
        register.setZipCodeField("80969");

        register.submitButtonClick();
        assertThat(myAccount.isAccountMenuVisible(),equalTo(true));
        assertThat(myAccount.isInfoAccountVisible(),equalTo(true));
        assertThat(driver.getCurrentUrl(),equalTo("http://automationpractice.com/index.php?controller=my-account"));
    }
     
    @AfterClass
    public static void cleanp() {
        driver.quit();
    }
}
