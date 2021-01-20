package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {
    public Map<String,HashSet<String>> map;

    PhoneBook(){
        this.map = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber){
        HashSet<String> numbers;
        if(map.containsKey(lastName)){
            numbers = map.get(lastName);
        }else{
            numbers = new HashSet<>();
        }
        numbers.add(phoneNumber);
        map.put(lastName,numbers);
    }

    public HashSet<String> get(String lastName) {
        return map.get(lastName);
    }
}
