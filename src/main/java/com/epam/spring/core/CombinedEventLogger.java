package com.epam.spring.core;

import java.util.Collection;

/**
 * Created by Oleksandr_Kokhanyuk on 7/27/2016.
 */
public class CombinedEventLogger {

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }
}
