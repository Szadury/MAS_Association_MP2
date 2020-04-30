package com.pjwstk.MAS.beerapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Kompozycja 1-* Beer
public class Producer extends ExtensionObject {
    private List<Beer> beerList = new ArrayList<>();
    private static Set<Beer> allBeers = new HashSet<>();
    private String name;
    private String country;

    public Producer(String name, String country){
        super();
        this.name = name;
        this.country = country;
    }

    public void addBeer(Beer beer) throws Exception {
        if(!beerList.contains(beer)) {
            if(allBeers.contains(beer)) {
                throw new Exception("Beer is already connected to another Producer.");
            }
            beerList.add(beer);
            allBeers.add(beer);
        }
    }

    public void deleteBeer(Beer beer){
        this.beerList.remove(beer);
    }

    public  void deleteAllBeers() throws Exception {
        for(Beer beer : beerList){
            Beer.deleteObject(beer);
            allBeers.remove(beer);
        }
        beerList.clear();
    }

    public static void deleteProducer(Producer producer) throws Exception {
        producer.deleteAllBeers();
        Producer.deleteObject(producer);
    }

    public List<Beer> getBeerList() {
        return beerList;
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
        StringBuilder info = new StringBuilder("Producer: " + name + "\n");
        for(Beer beer : beerList) {
            info.append(" ").append(beer.getName()).append("\n");
        }
        return info.toString();
    }

}
