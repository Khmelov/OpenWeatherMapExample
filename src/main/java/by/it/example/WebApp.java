package by.it.example;

import by.it.example.server.EmbeddedTomcat;
import org.apache.catalina.startup.Tomcat;

public class WebApp {

    public static void main(String... args) throws Exception {
        Tomcat tomcat = new EmbeddedTomcat();
        tomcat.start();
        tomcat.getServer().await();
    }

}
