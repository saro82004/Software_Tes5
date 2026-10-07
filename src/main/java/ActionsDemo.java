import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        Actions actions = new Actions(driver);

        try {

            // =========================================
            // 1. MOUSE HOVER
            // =========================================

            driver.get(
                "https://the-internet.herokuapp.com/hovers"
            );

            WebElement userImage = driver.findElement(
                    By.xpath("(//div[@class='figure'])[1]")
            );

            actions.moveToElement(userImage)
                   .perform();

            System.out.println("Mouse hover completed.");

            // =========================================
            // 2. DOUBLE CLICK
            // =========================================

            driver.get(
                "https://the-internet.herokuapp.com/add_remove_elements/"
            );

            WebElement addButton = driver.findElement(
                    By.xpath("//button[text()='Add Element']")
            );

            // Double click
            actions.doubleClick(addButton)
                   .perform();

            System.out.println("Double-click completed.");

            // =========================================
            // 3. DRAG AND DROP
            // =========================================

            driver.get(
                "https://the-internet.herokuapp.com/drag_and_drop"
            );

            WebElement source = driver.findElement(
                    By.id("column-a")
            );

            WebElement target = driver.findElement(
                    By.id("column-b")
            );

            // Drag A to B
            actions.dragAndDrop(source, target)
                   .perform();

            System.out.println("Drag-and-drop completed.");

        } finally {

            driver.quit();
        }
    }
}