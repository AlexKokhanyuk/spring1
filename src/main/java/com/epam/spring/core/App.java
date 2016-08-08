package com.epam.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by Oleksandr_Kokhanyuk on 7/25/2016.
 */
public class App {

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    Client client;
    EventLogger eventLogger;
    Map<EventType, EventLogger> loggers;

//    public App() {
//    }

    void logEvent(EventType type, String msg) {
        //String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        // System.out.println(message);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Event message = (Event) ctx.getBean("event");
        message.setMsg(client.getGreeting());


        EventLogger logger=loggers.get(type);
        //System.out.println(message);
        //eventLogger.logEvent(message);
        if(logger==null){
            logger=eventLogger;
        }
        logger.logEvent(message);

    }

    public static void main(String[] arg) {

        //  App app = new App();
        //  app.client = new Client("1", "John Smith");
        //  app.eventLogger=new ConsoleEventLogger();
        //   app.logEvent("Some event for user 1");

        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.logEvent(EventType.INFO, "Some event for 1");

        app.logEvent(EventType.ERROR,"This Error");

        app.logEvent(null,"Console logger");



       // ctx.close();
        //app.logEvent("Some event for 2");
    }

}
