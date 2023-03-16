package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private final By btnToOrderSmall = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");//локатор верхней маленькой кнопки заказать
    private final By btnToOrderBig = By.xpath(".//div[@class='Home_ThirdPart__LSTEE']//button");//локатор большой кнопки заказать
    private final By cookiePanel = By.className("App_CookieText__1sbqp"); //панель куки
    private final By btnCookie = By.id("rcc-confirm-button"); //кнопка куки
    private final By panelHowItWorks = By.className("Home_ThirdPart__LSTEE");//понель как это работает


    public HomePage(WebDriver driver) {
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
//нажать на кнопку заказать(2 кнопки)
public void clickButtonOrder(String text){
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(".//button[@class='"+text+"']")));
            driver.findElement(By.xpath(".//button[@class='"+text+"']")).click();
}
}