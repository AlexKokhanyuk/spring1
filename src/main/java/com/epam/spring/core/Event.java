package com.epam.spring.core;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Oleksandr_Kokhanyuk on 7/25/2016.
 */
public class Event {

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    private String msg;

    private Date date;

    private int id = new Random().nextInt();
    private DateFormat df;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "msg='" + msg + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}' + "\n";
    }
}
