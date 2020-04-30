package com.pjwstk.MAS.beerapp;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        if (new File("barPlatformStorage").isFile()) {
            try {
                FileInputStream fileInput = new FileInputStream("barPlatformStorage");
                ObjectInputStream streamInput = new ObjectInputStream(fileInput);
                ExtensionObject.readExtension(streamInput);
                streamInput.close();
                fileInput.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Nie znaleziono klasy.");
                c.printStackTrace();
                return;
            }
        }

// binarna : Bar * - * Owner
        System.out.println("Asocjacja binarna");
        System.out.println("____________________________________________");
        Bar bar1 = new Bar("Piw Paw", "123456789");
        Bar bar2 = new Bar("BullDog", "123456783");

        Owner owner1 = new Owner("Wojciech Szadurski", "ws@gmail.com", "123");
        Owner owner2 = new Owner("Adam Testowy", "ws@gmail.com", "123");

        bar1.addOwner(owner1);
        owner2.addBar(bar1);
        bar1.deleteOwner(owner2);

        System.out.println(owner1);
        System.out.println(owner2);
        System.out.println(bar1);
        System.out.println(bar2);
        System.out.println();

// Kompozycja Producer 1 - 1..* Beer
        System.out.println("Kompozycja");
        System.out.println("____________________________________________");

        Producer producer1 = new Producer("Heineken", "Holandia");
        Producer producer2 = new Producer("Carlsberg", "Dania");

        Beer beer1 = Beer.createBeer(producer1, "Heineken", 4.9, "Lager");
        Beer beer2 = Beer.createBeer(producer2, "Carlsberg", 3.6, "Lager");
        Producer.deleteProducer(producer2);
        System.out.println(producer1);
        System.out.println(producer2);
        System.out.println(beer1);
        System.out.println(beer2);
        System.out.println();
//Asocjacja z Atrybutem

        System.out.println("Asocjacja z atrybutem");
        System.out.println("____________________________________________");
        BeerBar bb1 = new BeerBar(false, LocalDate.of(2019, 9, 11), bar1, beer1, 9.5);
        BeerBar bb2 = new BeerBar(true, LocalDate.now(), bar1, beer1, 11.0);
        BeerBar bb3 = new BeerBar(true, LocalDate.now(), bar1, beer2, 9.0);

        bb1.setBar(bar2);
        System.out.println(bb1);
        System.out.println(bb2);
        System.out.println(bb3);

//Asocjacja z kwalifikatorem
        System.out.println("Asocjacja kwalifikowana");
        System.out.println("____________________________________________");
        Event event1 = new Event("Piwolanda", bar2, LocalDateTime.of(2020, 3, 14, 18, 0), LocalDateTime.of(2020, 3, 14 ,20, 0));

        System.out.println(bar2.findEvent(event1.getName()));
        System.out.println(bar2);


        System.out.println("=========================================");
        try {
            ExtensionObject.showExtension(Bar.class);
            ExtensionObject.showExtension(Owner.class);
            ExtensionObject.showExtension(Producer.class);
            ExtensionObject.showExtension(Beer.class);
            ExtensionObject.showExtension(BeerBar.class);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            //miejsce docelowe pliku w workspace
            FileOutputStream fileOutput = new FileOutputStream("barPlatformStorage");
            ObjectOutputStream StreamOutput = new ObjectOutputStream(fileOutput);
            ExtensionObject.saveExtension(StreamOutput);
            StreamOutput.close();
            fileOutput.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
}
