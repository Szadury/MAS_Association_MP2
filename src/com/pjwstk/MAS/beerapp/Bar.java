package com.pjwstk.MAS.beerapp;

import java.util.List;

public class Bar extends ExtensionObject{

    private String name;

    private List<Owner> owners;

    public Bar(String name, List<Owner> owners) {
        super();
        this.name = name;
        this.owners = owners;
    }

}
