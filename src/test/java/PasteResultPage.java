import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteResultPage extends BasePage {

    public PasteResultPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='info-top']/h1")));
        return titleElement.getText();
    }


    public String getSyntaxHighlighting() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement syntaxHighlighting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/archive/bash']")));
        return syntaxHighlighting.getText();
    }

    public String getEnteredCode() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enteredCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@style=\"font-size: px; line-height: px;\"]/ol")));
        return enteredCode.getText().replaceAll("\\s+", " ").trim();
    }
}
