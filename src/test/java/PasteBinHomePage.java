import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasteBinHomePage extends BasePage {

    public PasteBinHomePage(WebDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        driver.findElement(By.id("postform-text")).sendKeys(text);
    }

    public void setSyntax(String syntax) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-postform-format-container"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + syntax + "']"))).click();
    }

    public void setExpiration(String expiration) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-postform-expiration-container"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + expiration + "']"))).click();
    }

    public void enterTitle(String title) {
        driver.findElement(By.id("postform-name")).sendKeys(title);
    }

    public PasteResultPage createPaste() {
        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();
        return new PasteResultPage(driver);
    }
}
