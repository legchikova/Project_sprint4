package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class ListFAQ {
    private final WebDriver driver;
    //блок вопросов о важном
    private final By questionsAboutImportantBlock = By.className("Home_FourPart__1uthg");
    //"Вопросы о важном" текст
    private final By questionsAboutImportantText = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    //список вопросов о важном
    private final By dropDownListFAQ = By.className("Home_FAQ__3uVm4");


//конструктор
    public ListFAQ(WebDriver driver) {
        this.driver = driver;
    }
    //проскроллить до блока вопросов
    public void scrollToFAQ() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(questionsAboutImportantBlock));
    }
    //дождаться панель вопросов
    public void waitForLoadFAQ() {
        new WebDriverWait(driver, 3).until(driver ->
                driver.findElement(dropDownListFAQ).isEnabled() &&
                        driver.findElement(questionsAboutImportantText).isDisplayed());
    }
    //получить элемент
    private By getElement(int numberElement) {
        return By.id("accordion__heading-" + numberElement);
    }
    //получить текст
    private By getText(int numberElement) {
        return By.xpath(".//div[@id='accordion__panel-" + numberElement + "']/p");
    }

    public String getElementText(int numberElement) {
        driver.findElement(getElement(numberElement)).click();
        waitForLoadText(numberElement);
        return driver.findElement(getText(numberElement)).getText();
    }
    private void waitForLoadText(int numberElement) {
        new WebDriverWait(driver, 3).until(driver ->
                driver.findElement(By.id(format("accordion__panel-%s", numberElement))).isDisplayed());
    }
}
