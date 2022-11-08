package by.it.example.server;

import by.it.example.WebApp;
import by.it.example.controller.WeatherServlet;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.util.Objects;

public class EmbeddedTomcat extends Tomcat {

    //need move to configuration
    public static final WeatherServlet WEATHER_SERVLET = new WeatherServlet();
    public static final String SERVLET_NAME = "Weather";
    public static final String URI_FOR_GET = "get";
    public static final File TOMCAT_ROOT = new File(".");
    public static final File WEB_APP_FOLDER = new File(
            Objects.requireNonNull(
                    WebApp.class.getResource("/webapp")
            ).getPath()
    );

    public EmbeddedTomcat() {
        setBaseDir(TOMCAT_ROOT.getAbsolutePath());
        setPort(8089);
        getHost().setAppBase(WEB_APP_FOLDER.getAbsolutePath());
        Context context = addWebapp("", WEB_APP_FOLDER.getAbsolutePath());
        addWeatherServletServlet(context);
    }

    private void addWeatherServletServlet(Context context) {
        getConnector();
        Wrapper wrapper = addServlet("", SERVLET_NAME, WEATHER_SERVLET);
        wrapper.setLoadOnStartup(1);
        wrapper.addMapping("/" + URI_FOR_GET);    //map to "get?city=Minsk"
        context.addWelcomeFile(URI_FOR_GET);      //home == servlet
    }
}
