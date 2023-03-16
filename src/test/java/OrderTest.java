import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.hamcrest.MatcherAssert;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.FirstOrderPage;
import pages.SecondOrderPage;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
@RunWith(Parameterized.class)
public class OrderTest {
    private final String twoButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final int period;
    private final String comment;
    private final WebDriver driver;
    public OrderTest(String twoButton,String name, String surname, String address, String metroStation, String phone, String date, int period, String comment) {
        this.twoButton = twoButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.comment = comment;
        this.driver = new ChromeDriver();
    }
    @Parameterized.Parameters
    public static Object[][] getAnswers() {
        return new Object[][]{
                {"Button_Button__ra12g","Иван", "Рудоров", "г. Москва, ул.Ленина, 4", "Сокольники", "+79109108899",
                        "09/12/2023", 1, " "},
                {"Button_Button__ra12g Button_Middle__1CSJM","Андр", "Оооо", "Обнинск, Белкинская", "Черкизовская", "89159151122", "02/08/2023", 3, "Комментарий1"},
        };
    }

    @Test
    public void orderingSuccess() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.closeCookie();
        objHomePage.scrollToPanelHowItWorks();
        objHomePage.clickButtonOrder(twoButton);
        FirstOrderPage objFirstOrderPage = new FirstOrderPage(driver);
        objFirstOrderPage.waitForLoadHeaderForm();
        objFirstOrderPage.fillingOrder(name, surname, address, metroStation, phone);
        objFirstOrderPage.clickNext();
        SecondOrderPage objSecondOrderPage = new SecondOrderPage(driver);
        objSecondOrderPage.waitForLoadHeaderForm();
        objSecondOrderPage.fillingAboutRentFormWithBlackScooter(date, period, comment);
        objSecondOrderPage.clickOrderButton();
        objSecondOrderPage.clickConsentButton();
        MatcherAssert.assertThat(
                objSecondOrderPage.getTextCompletedPanel(), allOf(startsWith("Номер заказа:"), endsWith("пригодится, чтобы отслеживать статус")));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
