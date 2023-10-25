package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private final Duration TIMEOUT = Duration.ofSeconds(60);
    private final Duration POLLING_TIMEOUT = Duration.ofMillis(200);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60, 200);
        PageFactory.initElements(driver, this);
    }
    protected boolean elementVisible(By locator, int timeOut) {
        boolean flag;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            flag = true;
        } catch (Exception ex) {
            flag = false;
        }
        return flag;
    }

    protected WebElement findElement(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(NoSuchElementException.class);
        return wait.until(d -> d.findElement(locator));
    }


    public void waitUntilItemDisappears(By item, int timeOut){
        elementVisible(item, 5);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(item));
    }
}
