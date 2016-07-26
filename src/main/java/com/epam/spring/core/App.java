package com.epam.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Oleksandr_Kokhanyuk on 7/25/2016.
 */
public class App {

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = (ConsoleEventLogger) eventLogger;
    }

    Client client;
    ConsoleEventLogger eventLogger;

//    public App() {
//    }

    void logEvent(String msg) {
        //String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
       // System.out.println(message);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Event message= (Event) ctx.getBean("event");
        message.setMsg(msg);
        //System.out.println(message);
        eventLogger.logEvent(message);
    }

    public static void main(String[] arg) {

        //  App app = new App();
        //  app.client = new Client("1", "John Smith");
        //  app.eventLogger=new ConsoleEventLogger();
        //   app.logEvent("Some event for user 1");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");
        app.logEvent("Some event for 1");
        //app.logEvent("Some event for 2");
    }

}
