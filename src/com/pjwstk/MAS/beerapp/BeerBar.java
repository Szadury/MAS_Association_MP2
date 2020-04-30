package com.pjwstk.MAS.beerapp;

import java.time.LocalDate;

//Atrybut w asocjacji z atrybutem
public class BeerBar extends ExtensionObject{
    private boolean isBeingSold;
    private Double price;
    private LocalDate addedDate;
    private Bar bar;
    private Beer beer;

    public BeerBar(boolean isBeingSold, LocalDate addedDate, Bar bar, Beer beer, Double price) {
        super();
        this.isBeingSold = isBeingSold;
        this.addedDate = addedDate;
        this.price = price;
        this.bar = bar;
        this.bar.addBeerRelation(this);
        this.beer = beer;
        this.beer.addBeerRelation(this);
    }

    public void setBar(Bar bar){
        if(this.bar != null){
            bar.deleteBeerRelation(this);
        }
        this.bar = bar;
        this.bar.addBeerRelation(this);
    }

    public void setBeer(Beer beer){
        if(this.beer!=null) {
            beer.deleteBarRelation(this);
        }
        this.beer = beer;
        this.beer.addBeerRelation(this);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isBeingSold() {
        return isBeingSold;
    }

    public void setBeingSold(boolean beingSold) {
        isBeingSold = beingSold;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public Bar getBar() {
        return bar;
    }

    public Beer getBeer() {
        return beer;
    }

    @Override
    public String toString() {
        return "BeerBar{" +
                "isBeingSold=" + isBeingSold +
                ", addedDate=" + addedDate +
                ", bar=" + bar.getName() +
                ", beer=" + beer.getName() +
                ", price=" + price +
                '}';
    }
}
