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
        this.phonebook = null;
    }

    public PhoneBook() {
        this(new HashMap<>());
    }

    public void add(String name, String phoneNumber) {
        List <String> phoneNum = phonebook.get(name);
        if (phoneNum == null)
            phoneNum = new ArrayList<>();
        phoneNum.add(phoneNumber);
        phonebook.put(name,phoneNum);
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String str : phoneNumbers) {
            this.add(name,str);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.get(name)!=null;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String s:this.getAllContactNames()){
            if (lookup(s).toString().contains(phoneNumber))
                return s;
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
