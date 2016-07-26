package com.epam.spring.core;

/**
 * Created by Oleksandr_Kokhanyuk on 7/25/2016.
 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
