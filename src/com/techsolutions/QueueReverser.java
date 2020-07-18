package com.techsolutions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    public void reverser(Queue<Integer> queue, int k) {
      if (!queue.isEmpty() && k > 0 && k <= queue.size()) {
          Stack<Integer> stack1 = new Stack<>();
          Stack<Integer> stack2 = new Stack<>();

          for (int i = 0; i < k ; i++)
              stack1.push(queue.remove());

          while (!queue.isEmpty())
              stack2.push(queue.remove());

          for (int i = 0; i < k ; i++)
              queue.add(stack1.pop());

          while (!stack2.isEmpty())
              stack1.push(stack2.pop());

          while (!stack1.isEmpty())
              queue.add(stack1.pop());
      } else throw new IllegalArgumentException();
    };
}
