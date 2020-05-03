package by.it.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.servlet.ServletException;
import java.util.concurrent.TimeUnit;


public class WebAppTest {

    private static final String CITY = "Minsk";
    private static WebDriver driver;
    private static Tomcat tomcat;


    @BeforeClass
    public static void init() throws ServletException, LifecycleException {
        tomcat = WebApp.getTomcat();
        tomcat.start();
        driver = new ChromeDriver(); //or PhantomJSDriver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8089/get?city=" + CITY);
    }

    @Test
    public void checkTitle() {
        String title = driver.getTitle();
        assertThat(title, notNullValue());
        assertThat(title, containsString(CITY));
    }

    @Test
    public void findCityInPage() {
        By byLead = By.cssSelector("body > div > div.jumbotron > p.lead");
        String stringWithCity = driver.findElement(byLead).getText();
        assertThat(stringWithCity, notNullValue());
        assertThat(stringWithCity, containsString(CITY));
    }

    @AfterClass
    public static void finish() throws LifecycleException {
        driver.close();
        tomcat.stop();
        tomcat.destroy();
    }

}
