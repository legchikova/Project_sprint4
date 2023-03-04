package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private final By btnToOrderSmall = By.xpath (".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");//локатор верхней маленькой кнопки заказать
    private final By btnToOrderBig = By.xpath (".//div[@class='Home_ThirdPart__LSTEE']//button");//локатор большой кнопки заказать
    private final By cookiePanel = By.className("App_CookieText__1sbqp"); //панель куки
    private final By btnCookie = By.id("rcc-confirm-button"); //кнопка куки
    private final By panelHowItWorks = By.className("Home_ThirdPart__LSTEE");//понель как это работает
    //локаторы вопросов
    private final By questionFirst = By.id("accordion__heading-0"); //первый вопрос
    private final By questionSecond = By.id("accordion__heading-1"); //второй вопрос
    private final By questionThird = By.id("accordion__heading-2"); //третий вопрос
    private final By questionFourth = By.id("accordion__heading-3"); //четвертый вопрос
    private final By questionFifth = By.id("accordion__heading-4"); //пятый вопрос
    private final By questionSixth = By.id("accordion__heading-5"); //шестой вопрос
    private final By questionSeventh = By.id("accordion__heading-6"); //седьмой вопрос
    private final By questionEighth = By.id("accordion__heading-7"); //восьмой вопрос


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void closeCookie() {
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(cookiePanel).isDisplayed());
        driver.findElement(btnCookie).click();
    }
    public void scrollToPanelHowItWorks() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(panelHowItWorks));
    }
    public void clickOrderButtonSmall() {
        driver.findElement(btnToOrderSmall).click();
    }
    public void clickOrderButtonBig() {
        driver.findElement(btnToOrderBig).click();
    }
    public void cliclQuestionFirst() {
        driver.findElement(questionFirst).click();
    }
    public void cliclQuestionSecond() {
        driver.findElement(questionSecond).click();
    }
    public void cliclQuestionThird() {
        driver.findElement(questionThird).click();
    }
    public void cliclQuestionFourth() {
        driver.findElement(questionFourth).click();
    }
    public void cliclQuestionFifth() {
        driver.findElement(questionFifth).click();
    }
    public void cliclQuestionSixth() {
        driver.findElement(questionSixth).click();
    }
    public void cliclQuestionSeventh() {
        driver.findElement(questionSeventh).click();
    }
    public void cliclQuestionEigth() {
        driver.findElement(questionEighth).click();
    }
}
