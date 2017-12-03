package pl.kisiel.tau.labfour.tests;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;

import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.kisiel.tau.labfour.seleniumpage.HomePage;
import pl.kisiel.tau.labfour.seleniumpage.LoginPage;

import static org.junit.Assert.assertThat;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kisiel.tau.labfour.seleniumpage.MyAccountPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageTest {

    private static WebDriver driver;

    @BeforeClass
    public static void driverSetup() {

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test1RegisterUrl() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        home.signinButtonClick();
        login.setRegisterEmailFieldText("sebastjan@kisiel.pl");
        login.registerButtonClick();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("#account-creation"));
        assertThat(login.isAccountFormVisible(),equalTo(true));
        assertThat(driver.getCurrentUrl(),equalTo("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"));
    }

    @Test
    public void test2SuccessLogin() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        LoginPage login = new LoginPage(driver);
        login.setEmailField("seba@seba.seba");
        login.setPasswordField("sebaseba");
        login.loginButtonClick();
        MyAccountPage map = new MyAccountPage(driver);
        assertThat(map.isAccountMenuVisible(),equalTo(true));
        assertThat(map.isInfoAccountVisible(),equalTo(true));
        assertThat(driver.getCurrentUrl(),equalTo("http://automationpractice.com/index.php?controller=my-account"));
    }

    @Test
    public void test3Logout() {
        MyAccountPage map = new MyAccountPage(driver);
        map.logoutButtonClick();
        assertThat(driver.getCurrentUrl(),equalTo("http://automationpractice.com/index.php?controller=authentication&back=my-account"));
    }

    @Test
    public void test4FailLogin() {
        LoginPage login = new LoginPage(driver);
        login.setEmailField("seba@seba.seba");
        login.setPasswordField("boned");
        login.loginButtonClick();
        assertThat(login.isLoginError(),equalTo(true));
    }

    @AfterClass
    public static void cleanp() {
        driver.quit();
    }
}
