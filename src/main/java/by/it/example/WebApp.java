package by.it.example;

import by.it.example.beans.Weather;
import by.it.example.helpers.TemperatureExtractor;
import by.it.example.helpers.TemperatureFormatter;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WebApp {

    public static void main(String... args) throws Exception {
        runTomcat();
    }

    public static class WeatherServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException, ServletException {

            String city = req.getParameter("city");
            if (city == null || city.isEmpty()) {
                city = "Minsk";
            }

            Weather weather = App.weatherService.getWeather(city);
            double celsius = TemperatureExtractor.getCelsius(weather);
            String value = TemperatureFormatter.humanize(celsius, 'C');

            req.setAttribute("city", city);
            req.setAttribute("value", value);

            RequestDispatcher dispatcher = req.getRequestDispatcher("weather.jsp");
            dispatcher.forward(req, resp);
        }

    }


    private static void runTomcat() throws ServletException, LifecycleException {
        File tomcatRoot = new File(System.getProperty("user.dir"));
        File webAppFolder = new File(WebApp.class.getResource("/webapp").getPath());

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(tomcatRoot.getAbsolutePath());
        tomcat.setPort(8089);
        tomcat.getHost().setAppBase(webAppFolder.getAbsolutePath());
        Context context = tomcat.addWebapp("", webAppFolder.getAbsolutePath());
        context.addWelcomeFile("get");

        tomcat.getConnector();
        Wrapper wrapper = tomcat.addServlet("", "Weather", new WeatherServlet());
        wrapper.setLoadOnStartup(1);
        wrapper.addMapping("/get");

        tomcat.start();
        tomcat.getServer().await();
    }


}
