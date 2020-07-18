package com.techsolutions;

import java.util.Stack;

public class StringReverser {

    public String reverser(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray())
            stack.push(ch);

        StringBuffer reverse = new StringBuffer();

        while (!stack.empty())
            reverse.append(stack.pop());

        return reverse.toString();
    };

}
