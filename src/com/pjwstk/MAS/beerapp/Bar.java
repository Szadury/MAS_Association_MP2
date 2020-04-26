package com.pjwstk.MAS.beerapp;

import java.util.List;
import java.util.Map;

public class Bar extends ExtensionObject{

    private String name;

    private String phoneNumber;

    private List<Owner> owners;

    Map<String, Event> eventMap;

    public Bar(String name, String phoneNumber, List<Owner> owners) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.owners = owners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", owners=" + owners +
                ", eventMap=" + eventMap +
                '}';
    }
}
