package com.epam.spring.core;

import java.util.List;

/**
 * Created by Oleksandr_Kokhanyuk on 7/27/2016.
 */
public class CacheFileEventLogger extends FileEventLogger {

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    private int cacheSize;
    private List<Event> cache;

    public void logEvent(Event event) {

        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventFromCache();
            cache.clear();
        }

    }

    public void destroy(){
        if (!cache.isEmpty()){
            writeEventFromCache();
        }
    }

    private void writeEventFromCache() {

        for (Event event : cache) {
            logEvent(event);
        }

    }


}
