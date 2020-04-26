package com.pjwstk.MAS.beerapp;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    List<Bar> barList;
    private String name;
    private String email;
    private String password;

    public Owner(List<Bar> barList, String name, String email, String password) {
        this.barList = barList;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Owner(String name, String email, String password) {
        this.barList = new ArrayList<>();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public List<Bar> getBarList() {
        return barList;
    }

    public void setBarList(List<Bar> barList) {
        this.barList = barList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "barList=" + barList +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
