package com.leetcode.string;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char recent = '+';
        char[] array = s.toCharArray();
        stack.push(0);
        for (char ch : array) {
            if (ch >= '0' && ch <= '9') {
                stack.push(stack.pop()*10 + ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (recent == '+') {

                } else if (recent == '-') {
                    stack.push(-stack.pop());
                } else if (recent == '*') {
                    stack.push(stack.pop() * stack.pop());
                } else if (recent == '/') {
                    int divider = stack.pop();
                    stack.push(stack.pop()/divider);
                }
                recent = ch;
                stack.push(0);
            }
        }

        if (recent == '-') {
            stack.push(-stack.pop());
        } else if (recent == '*') {
            stack.push(stack.pop() * stack.pop());
        } else if (recent == '/') {
            int divider = stack.pop();
            stack.push(stack.pop()/divider);
        }

        int result = 0;
        while(!stack.isEmpty()) result += stack.pop();

        return result;

    }
}
