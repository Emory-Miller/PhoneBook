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
        this.phonebook.put(name, new ArrayList<>());
        this.phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name, new ArrayList<String>(List.of(phoneNumbers)));

//        ArrayList<String> a = new ArrayList<>();
//        a.addAll(Arrays.asList(phoneNumbers));
//        this.phonebook.put(name,a);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber){
        if (this.phonebook.containsKey(name) && (this.phonebook.get(name).contains(phoneNumber))){
            return true;
        } else {
            return false;
        }
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
//        Set<String> keys = this.phonebook.keySet();
//        String result = "";
//        for (String key : keys){
//            if (this.phonebook.get(key).contains(phoneNumber)){
//                result = key;
//            }
//        }
//        return result;

        for (String name : this.getAllContactNames()){
            if (this.lookup(name).contains(phoneNumber)){
                return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
//        Set<String> keys = this.phonebook.keySet();
//        List<String> result = new ArrayList<>(keys);
//         return result;

        return new ArrayList<>(this.phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
