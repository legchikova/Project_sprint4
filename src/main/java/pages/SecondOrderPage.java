package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class SecondOrderPage {
    private final WebDriver driver;
    private final By headerForm = By.className("Order_Form__17u6u"); //заголовок страницы "Про аренду"
    private final By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //дата привоза самоката
    private final By rentalPeriod = By.className("Dropdown-placeholder");//срок аренды
    private final By blackColor = By.id("black"); //черный жемчуг цвет
    private final By greyColor = By.id("grey");//серая безысходность цвет
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");//комментарий для курьера
    private final By btnOrder = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Buttons__1xGrp > button:nth-child(2)");//кнопка Заказать
    private final By confirmationPanel = By.className("Order_ModalHeader__3FDaJ");//панель подтверждения
    private final By btnConsent = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");//кнопка Да
    private final By completedPanel = By.xpath(".//div[text()='Заказ оформлен']");//панель завершения заказа
    private final By textCompletedPanel = By.className("Order_Text__2broi");//текст на понели завершения заказа


    public SecondOrderPage(WebDriver driver){
        this.driver = driver;
    }
    public void waitForLoadHeaderForm() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerForm));
    }
    public void waitForLoadConfirmationPanel() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmationPanel));
    }
    public void waitForLoadOrderCompletedPanel() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(completedPanel));
    }
    public String getTextCompletedPanel() {
        waitForLoadOrderCompletedPanel();
        return driver.findElement(textCompletedPanel).getText();
    }

    //заполнить поле даты
    private void fillingDate(String date) {
        driver.findElement(deliveryDate).click();
        driver.findElement(deliveryDate).clear();
        driver.findElement(deliveryDate).sendKeys(date, Keys.ENTER);
    }
    //заполнить поле срок аренды
    private void fillingRentalPeriod(int period) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(getPeriod(period)).click();
    }
    //варианты сроков аренды
    private By getPeriod(int period) {
        switch (period) {
            case 2:
                return getPeriod("двое суток");
            case 3:
                return getPeriod("трое суток");
            case 4:
                return getPeriod("четверо суток");
            case 5:
                return getPeriod("пятеро суток");
            case 6:
                return getPeriod("шестеро суток");
            case 7:
                return getPeriod("семеро суток");
            case 1:
            default:
                return getPeriod("сутки");
        }
    }
    private By getPeriod(String period) {
        return By.xpath(format(".//div[@class='Dropdown-menu']/div[text()='%s']", period));
    }
    //заполнить комментарий
    private void fillingComment(String comment) {
        driver.findElement(commentField).click();
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }
    //заполнить поля с черным скутером
    public void fillingAboutRentFormWithBlackScooter(String date, int period, String comment) {
        fillingDate(date);
        fillingRentalPeriod(period);
        driver.findElement(blackColor).click();
        fillingComment(comment);
    }
//заполнить поля с серым скутером
    public void fillingAboutRentFormWithGreyScooter(String date, int period, String comment) {
        fillingDate(date);
        fillingRentalPeriod(period);
        driver.findElement(greyColor).click();
        fillingComment(comment);
    }
    //нажать заказать
    public void clickOrderButton() {

        driver.findElement(btnOrder).click();
    }
//нажать да
    public void clickConsentButton() {
        waitForLoadConfirmationPanel();
        driver.findElement(btnConsent).click();
    }

}
