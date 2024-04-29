import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;

public class Execute {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");

        try {
            PasteBinHomePage homePage = new PasteBinHomePage(driver);
            String originalCode = "git config --global user.name \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";
            String title = "how to gain dominance among developers".replaceAll("[\\t\\n\\r]+", " ").trim();
            String syntax = "Bash";
            homePage.enterText(originalCode);
            homePage.setSyntax(syntax);
            homePage.setExpiration("10 Minutes");
            homePage.enterTitle(title);
            PasteResultPage resultPage = homePage.createPaste();
            //Making the original code comparable with the saved code
            String codeToCompare = originalCode.replaceAll("[\\t\\n\\r]+", " ").trim();

            // Validations
            assertEquals(title, resultPage.getPageTitle());
            assertEquals(syntax, resultPage.getSyntaxHighlighting());
            assertEquals(codeToCompare, resultPage.getEnteredCode());

        } catch (Exception e) {
            System.out.println("Error encountered: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
