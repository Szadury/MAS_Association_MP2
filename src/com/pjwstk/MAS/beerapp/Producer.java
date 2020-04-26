package com.pjwstk.MAS.beerapp;

import java.util.ArrayList;
import java.util.List;

public class Producer {
    private List<Beer> beerList = new ArrayList<>();
    private String name;
    private String country;

    public Producer(String name, String country){
        this.name = name;
        this.country = country;
    }

    public void addBeer(Beer beer){
        if(!beerList.contains(beer)){
            beerList.add(beer);
        }
    }

    public List<Beer> getBeerList() {
        return beerList;
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "beerList=" + beerList +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
