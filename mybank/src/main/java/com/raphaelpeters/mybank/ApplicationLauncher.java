package com.raphaelpeters.mybank;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import com.raphaelpeters.mybank.web.TransactionServlet;

public class ApplicationLauncher {
    public static void main(String[] args) {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8090);
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "TransactionServlet", new TransactionServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}