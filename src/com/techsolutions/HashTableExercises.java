package com.techsolutions;

import java.util.*;

public class HashTableExercises {
//
//    public int mostFrequentIntegers(int[] numbers) {
////        if (numbers.length == 0) throw new IllegalArgumentException();
//
////        Map<Integer, Integer> map = new HashMap<>();
////        int max = 0;
////        int result = numbers[0];
////
////        for (int number : numbers) {
////            int count = map.getOrDefault(number,0);
////            map.put(number, count + 1);
////        }
////
////        for (var object : map.entrySet()) {
////            if (object.getValue() > max) {
////                max = object.getValue();
////                result = object.getKey();
////            }
////        }
////
////        return result;
////    };
////
////    public Character mostFrequentCharacters(String str) {
////        if (str == null || str.length() == 0) throw new IllegalArgumentException();
////
////        Map<Character, Integer> map = new HashMap<>();
////        int max = 0;
////        char result = Character.MIN_VALUE;
////
////        for (char ch : str.toCharArray()) {
////            if (ch == ' ') continue;
////            int count = map.getOrDefault(ch, 0);
////            map.put(ch, count + 1);
////        }
////
////        for (var object : map.entrySet()) {
////            if (object.getValue() > max) {
////                max = object.getValue();
////                result = object.getKey();
////            }
////        }
////
////        return result;
////    };
//
//    public int countPairsWithDiff(int[] numbers, int difference) {
//        if (numbers.length < 2) return 0;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        int count = 0;
//
//        for (int number : numbers) {
//            map.put(number + difference, number);
//        }
//
//        for (var pair : map.entrySet()) {
//            if (map.containsValue(pair.getKey()))
//                count++;
//        }
//
//        return count;
//    };
//
//    public String twoSum(int[] numbers, int target) {
//        int[] result = new int[2];
//
//        Set<Integer> set = new HashSet<>();
//
//        for (int number : numbers)
//            set.add(target - number);
//
//        int count = 0;
//        for (int i = 0; i < numbers.length ; i++) {
//            if (set.contains(numbers[i])) {
//                result[count++] = i;
//            }
//            set.remove(numbers[i]);
//        }
//
//        return Arrays.toString(result);
//    };
}
