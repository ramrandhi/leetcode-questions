package com.TillDateInterviewQuestions.Adpushup;

import java.util.Stack;

public class OpenCloseDifferentBraces {
    public static void main(String[] args) {
        boolean isCorrect = checkOpenCloseBrances("(())()())");
        System.out.println(isCorrect);
    }
    static boolean checkOpenCloseBrances(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == '[' && top != ']') || (c == '{' && top != '}')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
