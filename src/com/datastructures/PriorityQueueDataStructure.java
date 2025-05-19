package com.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// priority queue is used to give data based on its priority
public class PriorityQueueDataStructure {
    public static void main(String[] args) {
        String s = "cjca";
        System.out.println(priorityQueue(s));
    }
    public static String priorityQueue(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> list = new PriorityQueue<>(
                (a,b) -> b.getValue().compareTo(a.getValue()));
        list.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()) {
            Map.Entry<Character, Integer> entry = list.poll();
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return sb.toString();
    }
}
