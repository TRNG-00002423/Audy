package com.rev.collect;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
  public static void main(String[] args) {
    Map<String,Double> scores = new HashMap<>();

    scores.put("John",90.2);
    scores.put("Audy",91.2);
    scores.put("Curtis",89.3);
    scores.put("John",88.22);
    scores.put("Thomas",90.1);
    
    System.out.println(scores);

    for(Map.Entry<String, Double> entry: scores.entrySet()){
      System.out.println(entry.getKey() + " scored - " + entry.getValue());
    }
  }
  
}
