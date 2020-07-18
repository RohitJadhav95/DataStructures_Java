package com.techsolutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    private Map<Character,Integer> map = new HashMap<>();
    private Set<Character> set = new HashSet<>();
    private char[] chars;
    private String str;

    public CharFinder(String string) {
        str = new String(string);
        chars = str.toCharArray();
    }

    public Character firstNonRepeatedChar() {
        map.clear();

        for (char ch: chars){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (char ch : chars) {
            if (map.get(ch) == 1 && ch != ' '){
                return ch;
            }
        }

        return Character.MAX_VALUE;
    };

    public Character firstRepeatedChar() {
        for (char ch : chars) {
            if (set.contains(ch) && ch != ' ')
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    };


}
