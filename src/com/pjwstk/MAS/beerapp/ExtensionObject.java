package com.pjwstk.MAS.beerapp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtensionObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Map<Class<? extends ExtensionObject>, List<ExtensionObject>> extension = new HashMap<>();

    public ExtensionObject(){
        List<ExtensionObject> extensionList;
        Class<? extends ExtensionObject> extensionClass = this.getClass();

        if(extension.containsKey(extensionClass))
        {
            extensionList = extension.get(extensionClass);
        }
        else
        {
            extensionList = new ArrayList<>();
            extension.put(extensionClass, extensionList);
        }
        extensionList.add(this);
    }

    public static void saveExtension(ObjectOutputStream stream) throws IOException
    {
        stream.writeObject(extension);
    }

    public static void readExtension(ObjectInputStream stream) throws IOException, ClassNotFoundException
    {
        extension = (HashMap<Class<? extends ExtensionObject>, List<ExtensionObject>>) stream.readObject();
    }

    public static void showExtension(Class<? extends ExtensionObject> extensionClass) throws Exception
    {
        List<ExtensionObject> extensionList = null;

        if(extension.containsKey(extensionClass))
        {
            extensionList = extension.get(extensionClass);
        }
        else
        {
            throw new Exception("Unknown class " + extensionClass);
        }

        System.out.println("class extension: " + extensionClass.getSimpleName());

        for(Object obiekt : extensionList)
        {
            System.out.println(obiekt + "\n");
        }
    }

    public static <T extends ExtensionObject> void deleteObject(T obj) throws Exception {
        Class objectsClass = obj.getClass();
        if(extension.containsKey(objectsClass)) {
            if (extension.get(objectsClass).contains(obj)) {
                extension.get(objectsClass).remove(obj);
            } else {
                throw new Exception("Object does not exist in extension");
            }
        }
    }
}
