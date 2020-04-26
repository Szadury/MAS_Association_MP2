package com.pjwstk.MAS.beerapp;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    private String name;
    private Double percentage;
    private String beerType;
    Producer producer;
    List<BeerBar> beerBarList;

    private Beer(Producer producer, String name, Double percentage, String beerType) {
        this.name = name;
        this.percentage = percentage;
        this.beerType = beerType;
        this.producer = producer;
        this.beerBarList = new ArrayList<>();
    }
    public static Beer createBeer(Producer producer, String name, Double percentage, String beerType, List<BeerBar> beerBarList) throws Exception{
        if(producer == null){
            throw new Exception("Given producer does not exist!");
        }
        Beer beer = new Beer(producer, name, percentage, beerType);
        producer.addBeer(beer);
        return beer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public List<BeerBar> getBeerBarList() {
        return beerBarList;
    }

    public void setBeerBarList(List<BeerBar> beerBarList) {
        this.beerBarList = beerBarList;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", percentage=" + percentage +
                ", beerType='" + beerType + '\'' +
                ", producer=" + producer +
                ", beerBarList=" + beerBarList +
                '}';
    }
}
