package by.it.example;

import by.it.example.controller.WeatherServlet;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.util.Objects;

public class WebApp {

    public static final WeatherServlet WEATHER_SERVLET = new WeatherServlet();
    public static final String SERVLET_NAME = "Weather";
    public static final String URI_FOR_GET = "get";
    public static final File TOMCAT_ROOT = new File(System.getProperty("user.dir"));
    public static final File WEB_APP_FOLDER = new File(
            Objects.requireNonNull(
                    WebApp.class.getResource("/webapp")
            ).getPath()
    );

    public static void main(String... args) throws Exception {
        Tomcat tomcat = getTomcat();
        tomcat.start();
        tomcat.getServer().await();
    }

    static Tomcat getTomcat() {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(TOMCAT_ROOT.getAbsolutePath());
        tomcat.setPort(8089);
        tomcat.getHost().setAppBase(WEB_APP_FOLDER.getAbsolutePath());
        Context context = tomcat.addWebapp("", WEB_APP_FOLDER.getAbsolutePath());
        addWeatherServletServlet(tomcat, context);
        return tomcat;
    }

    private static void addWeatherServletServlet(Tomcat tomcat, Context context) {
        tomcat.getConnector();
        Wrapper wrapper = tomcat.addServlet("", SERVLET_NAME, WEATHER_SERVLET);
        wrapper.setLoadOnStartup(1);
        wrapper.addMapping("/" + URI_FOR_GET);    //map to "get?city=Minsk"
        context.addWelcomeFile(URI_FOR_GET);      //home == servlet
    }


}
