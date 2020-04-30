package com.pjwstk.MAS.beerapp;

import java.util.*;

//Asocjacja zwykła Bar *-* Owner
//Asocjacja z atrybutem Bar *-1 BarBeer 1-* Beer
//Asocjacja kwalifikowana Bar 1-* Event
public class Bar extends ExtensionObject{

    private String name;
    private String phoneNumber;
    private List<Owner> owners = new ArrayList<>();
    private List<BeerBar> beerBarList = new ArrayList<>();
    private Map<String, Event> eventMap = new TreeMap<>();

    public Bar(String name, String phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void addOwner(Owner owner) {
        if(!owners.contains(owner)) {
            owners.add(owner);
            owner.addBar(this);
        }
    }

    public void deleteOwner(Owner owner){
        if(owners.contains(owner)){
            owners.remove(owner);
            owner.deleteBar(this);
        }
    }

    public void addBeerRelation(BeerBar beerBar) {
        if(!beerBarList.contains(beerBar)) {
            beerBarList.add(beerBar);
        }
    }

    public void deleteBeerRelation(BeerBar beerBar){
            beerBarList.remove(beerBar);
    }

    public void addEvent(Event event) throws Exception {
        if(!eventMap.containsKey(event.getName())) {
            eventMap.put(event.getName(), event);
            event.setBar(this);
        }
    }

    public Event findEvent(String name) throws Exception {
        if(!eventMap.containsKey(name)) {
            throw new Exception("Can't find Event: " + name);
        }
        return eventMap.get(name);
    }

    public void deleteEvent(String name) throws Exception {
        if(!eventMap.containsKey(name)) {
            throw new Exception("Can't find Event: " + name);
        }
        eventMap.remove(name);
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

    public List<BeerBar> getBeerBarList() {
        return beerBarList;
    }

    public void setBeerBarList(List<BeerBar> beerBarList) {
        this.beerBarList = beerBarList;
    }

    public Map<String, Event> getEventMap() {
        return eventMap;
    }

    public void setEventMap(Map<String, Event> eventMap) {
        this.eventMap = eventMap;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", owners=" + owners +
                ", beerBarList=" + beerBarList +
                ", eventMap=" + eventMap +
                '}';
    }
}
