package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<String, List<String>>());
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, new ArrayList<>());
        phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, new ArrayList<String>(List.of(phoneNumbers)));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber){
        if (phonebook.containsKey(name) && (phonebook.get(name).contains(phoneNumber))){
            return true;
        } else {
            return false;
        }
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        Set<String> keys = getMap().keySet();
        String result = "";
        for (String key : keys){
            if (phonebook.get(key).contains(phoneNumber)){
                result = key;
            }
        }
        return result;
    }

    public List<String> getAllContactNames() {
        Set<String> keys = getMap().keySet();
        List<String> result = new ArrayList<>(keys);
         return result;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
