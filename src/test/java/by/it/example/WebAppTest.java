package by.it.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.servlet.ServletException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class WebAppTest {

    private static final String CITY = "Minsk";
    private static WebDriver driver;
    private static Tomcat tomcat;


    /**
     * small sample, but it is just sample,
     * see better in google pattern Page Object
     */

    @BeforeClass
    public static void init() throws ServletException, LifecycleException {
        Locale.setDefault(Locale.ENGLISH);
        tomcat = WebApp.getTomcat();
        tomcat.start();
        //please, before testing, download and set path for PhantomJSDriver.exe and/or ChromeDriver.exe
        driver = new PhantomJSDriver(); // ChromeDriver() or PhantomJSDriver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    @AfterClass
    public static void finish() throws LifecycleException {
        driver.close();
        tomcat.stop();
        tomcat.destroy();
    }

}
