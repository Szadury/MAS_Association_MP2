package com.pjwstk.MAS.beerapp;

import java.util.ArrayList;
import java.util.List;

//Asocjacja zwykła poprzez referencje Owner *-* Bar
public class Owner extends ExtensionObject{
    private List<Bar> barList = new ArrayList<>();
    private String name;
    private String email;
    private String password;


    public Owner(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void addBar(Bar bar) {
        if(!barList.contains(bar)) {
            barList.add(bar);
            bar.addOwner(this);
        }
    }

    public void deleteBar(Bar bar){
        if(barList.contains(bar)){
            barList.remove(bar);
            bar.deleteOwner(this);
        }
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
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
