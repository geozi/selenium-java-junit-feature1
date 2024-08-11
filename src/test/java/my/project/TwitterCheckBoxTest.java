package my.project;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;


@Order(3)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TwitterCheckBoxTest {

    private static ChromeDriver chromeDriver;
    private static Hoverer hoverer;
    private static Clicker clicker;
    private static Actions actions;
    private static WebDriverWait wait;
    private static WebElement element;

    @BeforeAll
    static void initializeFields() {
        System.out.println("\nRunning " + TwitterCheckBoxTest.class.getSimpleName() + "...");

        // Arrange
        chromeDriver = new ChromeDriver();
        actions = new Actions(chromeDriver);
        clicker = new Clicker(chromeDriver);
        hoverer = new Hoverer(chromeDriver);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

    }

    @BeforeEach
    void setUpWaiting() {
        actions.pause(Duration.ofSeconds(3)).perform();
    }

    @Test
    @Order(1)
    @DisplayName("Opening the website")
    void openWebsite() {

        System.out.println("Opening the website...");

        // Act
        try {
            chromeDriver.get("https://www.netcompany-intrasoft.com/");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Maximizing browser window")
    void maximizeBrowserWindow() {

        System.out.println("Maximizing browser window...");

        // Act
        try {
            chromeDriver.manage().window().maximize();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Hovering over the twitter checkbox")
    void hoverOverCheckBox() {
        // Act
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("eu-cookie-compliance-banner")));
            element = wait.
                    until(ExpectedConditions.elementToBeClickable(By.id("cookie-category-twitter")));
            System.out.println("Hovering over the twitter checkbox...");
            hoverer.hover(element, actions);
        } catch(NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Clicking the twitter checkbox")
    void clickTheCheckBox() {
        // Act
        try {
            System.out.println("Clicking the twitter checkbox...");
            clicker.click(element);
        } catch(NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(5)
    @DisplayName("Hovering over the 'Save Preferences' button")
    void hoverOverSavePreferencesBtn() {
        // Act
        try {
            element = wait.
                    until(ExpectedConditions.elementToBeClickable(By.className("eu-cookie-compliance-save-preferences-button")));
            System.out.println("Hovering over the 'Save Preferences' button...");
            hoverer.hover(element, actions);

        } catch(NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(6)
    @DisplayName("Clicking the 'Save Preferences' button")
    void clickSavePreferencesButton() {
        //Act
        try {
            System.out.println("Clicking the 'Save Preferences' button...");
            clicker.click(element);
        } catch(NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(7)
    @DisplayName("Quitting the browser")
    void closeBrowser() {
        try {
            System.out.println("Quitting the browser...");
            chromeDriver.quit();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
