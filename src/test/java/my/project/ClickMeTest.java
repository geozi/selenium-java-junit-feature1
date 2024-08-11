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


@Order(1)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClickMeTest {

    private static ChromeDriver chromeDriver;
    private static Hoverer hoverer;
    private static Clicker clicker;
    private static Actions actions;
    private static WebDriverWait wait;
    private static WebElement element;

    @BeforeAll
    static void initializeFields() {
        System.out.println("\nRunning " + ClickMeTest.class.getSimpleName() + "...");

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
    @DisplayName("Hovering over 'click me' link")
    void hoverOverClickMe() {
        // Act
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("eu-cookie-compliance-banner")));
            element = wait.
                    until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"click here\"]")));
            System.out.println("Hovering over 'click me' link...");
            hoverer.hover(element, actions);
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Click on 'click me'")
    void clickOnClickMe() {
        // Act
        try {
            System.out.println("Clicking on 'click me' link...");
            clicker.click(element);
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(5)
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
