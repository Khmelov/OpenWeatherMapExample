package by.it.example;

import by.it.example.server.EmbeddedTomcat;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WebAppTest {

    private static final String CITY = "Minsk";
    private static WebDriver driver;
    private static Tomcat tomcat;


    /**
     * small sample, but it is just sample,
     * see better in google pattern Page Object
     */

    @BeforeAll
    public static void init() throws LifecycleException {
        Locale.setDefault(Locale.ENGLISH);
        tomcat = new EmbeddedTomcat();
        tomcat.start();

        ChromeOptions options = new ChromeOptions();
        //set silent mode
        //options.addArguments("--headless");
        // please, before testing, download and set path
        // for phantomjs[.exe] and/or chromedriver[.exe]
        driver = new ChromeDriver(options); // ChromeDriver() or PhantomJSDriver


        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        driver.get("http://localhost:8089/get?city=" + CITY);
    }


    @Test
    public void checkTitle() {
        String title = driver.getTitle();
        assertNotNull(title);
        assertTrue(title.contains(CITY));
    }

    @Test
    public void findCityInPage() {
        By byLead = By.cssSelector("body > div > div.jumbotron > p.lead");
        String stringWithCity = driver.findElement(byLead).getText();
        assertNotNull(stringWithCity);
        assertTrue(stringWithCity.contains(CITY));
    }

    @AfterAll
    public static void finish() throws LifecycleException {
        driver.close();
        tomcat.stop();
        tomcat.destroy();
    }

}
