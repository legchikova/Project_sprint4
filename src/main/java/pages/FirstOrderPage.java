package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstOrderPage {
    private WebDriver driver;
    private final By headerForm = By.className("Order_Header__BZXOb"); //название панели "Для кого самокат"
    private final By name = By.xpath(".//input[@placeholder='* Имя']"); //локатор имени
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']"); //локатор фамилии
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //локатор адреса
    private final By station = By.className("select-search__input"); //локатор cтанции
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //локатор телефона
    private final By btnNext = By.xpath(".//button[text()='Далее']"); //локатор кнопки Далее

    public FirstOrderPage(WebDriver driver){
        this.driver = driver;
    }
    public void waitForLoadHeaderForm() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerForm));
    }
    public void fillingOrder(String name, String surname, String address, String station, String phone) {
        fillingName(name);
        fillingSurname(surname);
        fillingAddress(address);
        fillingStation(station);
        fillingPhoneField(phone);
    }
    private void fillingName(String value) {
        driver.findElement(name).click();
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(value);
    }
    private void fillingSurname(String value) {
        driver.findElement(surname).click();
        driver.findElement(surname).clear();
        driver.findElement(surname).sendKeys(value);
    }
    private void fillingAddress(String value) {
        driver.findElement(address).click();
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(value);
    }
    private void fillingStation(String value) {
        driver.findElement(station).click();
        driver.findElement(station).clear();
        driver.findElement(station).sendKeys(value);
        driver.findElement(By.xpath(".//*[text()='" + value + "']")).click();
    }
    private void fillingPhoneField(String value) {
        driver.findElement(phone).click();
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(value);
    }
    public void clickNext() {
        driver.findElement(btnNext).click();
    }


}
