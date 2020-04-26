package com.pjwstk.MAS.beerapp;

import java.time.LocalDate;

public class BeerBar {
    private boolean isBeingSold;
    private LocalDate addedDate;
    private Bar bar;
    private Beer beer;

    public BeerBar(boolean isBeingSold, LocalDate addedDate, Bar bar, Beer beer) {
        this.isBeingSold = isBeingSold;
        this.addedDate = addedDate;
        this.bar = bar;
        this.beer = beer;
    }

    public BeerBar(Bar bar, Beer beer) {
        isBeingSold = true;
        addedDate = LocalDate.now();
        this.bar = bar;
        this.beer = beer;
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

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    @Override
    public String toString() {
        return "BeerBar{" +
                "isBeingSold=" + isBeingSold +
                ", addedDate=" + addedDate +
                ", bar=" + bar +
                ", beer=" + beer +
                '}';
    }
}
