package com.pjwstk.MAS.beerapp;

import java.util.ArrayList;
import java.util.List;

//Asocjacja z atrybutem Beer *-1 BeerBar 1-* Bar
//Kompozycja Piwo *-1 Producent

public class Beer extends ExtensionObject{
    private String name;
    private Double percentage;
    private String beerType;
    private Producer producer;
    private List<BeerBar> beerBarList = new ArrayList<>();

    private Beer(Producer producer, String name, Double percentage, String beerType) {
        super();
        this.name = name;
        this.percentage = percentage;
        this.beerType = beerType;
        this.producer = producer;
    }

    public static Beer createBeer(Producer producer, String name, Double percentage, String beerType) throws Exception{
        if(producer == null){
            throw new Exception("Given producer does not exist!");
        }
        Beer beer = new Beer(producer, name, percentage, beerType);
        producer.addBeer(beer);
        return beer;
    }

    public void addBeerRelation(BeerBar beerBar) {
        if(!beerBarList.contains(beerBar)) {
            beerBarList.add(beerBar);
        }
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
                ", beerBarList=" + beerBarList +
                ", producer=" + producer.getName() +
                '}';
    }

    public void deleteBarRelation(BeerBar beerBar) {
        beerBarList.remove(beerBar);
    }
}
