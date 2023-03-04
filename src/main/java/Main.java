import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; //для скролла страницы
public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(); //создание драйвера

        driver.get("https://qa-scooter.praktikum-services.ru/"); //открыть страницу






        driver.quit();
    }
}
