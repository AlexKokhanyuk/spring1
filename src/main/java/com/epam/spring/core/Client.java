package com.epam.spring.core;

/**
 * Created by Oleksandr_Kokhanyuk on 7/25/2016.
 */
public class Client {
    public Client() {
    }

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    private String id;
    private String fullName;

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


}
