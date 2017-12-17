package pl.kisiel.tau.labfive.test.java.pl.seleniumpage.bdd.scenerio;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pl.I;
import cucumber.api.java.pl.Kiedy;
import cucumber.api.java.pl.Mając;
import cucumber.api.java.pl.Wtedy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.kisiel.tau.labfour.seleniumpage.LoginPage;
import pl.kisiel.tau.labfour.seleniumpage.MyAccountPage;
import pl.kisiel.tau.labfour.seleniumpage.RegisterPage;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RegisterPageScenerio {
    static WebDriver driver;

    @Before
    public static void driverSetup() {

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Mając("^Załadowaną stronę z logowaniem użytkownika$")
    public void ZaladowanaStronaLogowaniaUzytkownika() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Kiedy("^Wpisuję swoje konto \"([^\"]*)\"$")
    public void WpisywanieSwojegoKonta(String user) {
        //wiem że w tym momęcie łamię DRY, ale niestety coś nie chwyta obiektu jak jest klasowy
        LoginPage login = new LoginPage(driver);
        Random random = new Random();
        int constantLogin = random.nextInt(1000000);
        String loginUser = user+constantLogin+"@sebaseba2.pl";
        login.setRegisterEmailFieldText(loginUser);
    }

    @I("^Klikam przycisk rejestracji$")
    public void KliknieciePrzyciskRejestracji() {
        LoginPage login = new LoginPage(driver);
        login.registerButtonClick();
    }

    @Wtedy("^Ukazuje mi się formularz rejestracji$")
    public void UkazanieStronyLogowania() {
        assertThat(driver.getCurrentUrl(),equalTo("http://automationpractice.com/index.php?controller=authentication&back=my-account"));
    }

    @I("^Uzupełniam go swoimi danymi \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void UzupelnienieFormularza(String password,String adres,String miasto,String imie,String nazwisko,String telefon,String kodpocztowy) {
        RegisterPage register = new RegisterPage(driver);
        register.setAddressField(adres);
        register.setCityField(miasto);
        register.setFirstNameField(imie);
        register.setLastNameField(nazwisko);
        register.setMobilePhoneField(telefon);
        register.setPasswordField(password);
        register.chooseCountry();
        register.chooseState();
        register.setZipCodeField(kodpocztowy);
    }

    @Wtedy("^Wysyłam formularz$")
    public void WyslanieFormularza() {
        RegisterPage register = new RegisterPage(driver);
        register.submitButtonClick();
    }

    @Wtedy("^Ukazuje mi się strona mojego konta$")
    public void StronaMojegoKonta() {
        MyAccountPage myAccount = new MyAccountPage(driver);
        assertThat(myAccount.isAccountMenuVisible(),equalTo(true));
        assertThat(myAccount.isInfoAccountVisible(),equalTo(true));
        assertThat(driver.getCurrentUrl(),equalTo("http://automationpractice.com/index.php?controller=my-account"));
    }

    @After
    public static void cleanp() {
        driver.quit();
    }
}
