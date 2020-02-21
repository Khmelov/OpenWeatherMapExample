package org.example;

import java.io.File;
import java.net.MalformedURLException;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {

    public static void main(String[] args) throws Exception, LifecycleException {
        new Main().start();
    }

    public void start() throws ServletException, LifecycleException, MalformedURLException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);

        Context context = tomcat.addWebapp("/", new File(".").getAbsolutePath());

        tomcat.addServlet(context, "jersey-container-servlet", resourceConfig());

        context.addServletMappingDecoded("/*", "jersey-container-servlet");

        tomcat.start();
        tomcat.getServer().await();
    }

    private ServletContainer resourceConfig() {
//        return new ServletContainer(new ResourceConfig(new ResourceLoader().getClasses()));
        return new ServletContainer(new ResourceConfig(HelloWorldRestResource.class));
    }

}