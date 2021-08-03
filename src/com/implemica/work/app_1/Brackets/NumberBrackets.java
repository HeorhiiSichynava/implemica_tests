package com.implemica.work.app_1.Brackets;

import java.util.HashMap;
import java.util.LinkedList;

public class NumberBrackets {
    HashMap<Integer, Long> hashMap = new HashMap<Integer, Long>();

    //You must enter the size of the bracket expression. where 1 = a pair of brackets "()".
    public static void lengthBrackets(int maximumNumberOfParenthesisExpressions) throws BracketsLengthException{
        try {
            //throw an exception if the maximum expression length is exceeded
            if (maximumNumberOfParenthesisExpressions > 35) throw new BracketsLengthException("The length of the expression in parentheses must not exceed 35 (opening and closing) parentheses");

            Long numberOfCorrectParentheses = null;
            if (maximumNumberOfParenthesisExpressions != 0) {
                int[] optionsForTheNumberOfOpenBracketsForTheSecondHalfOfTheLength = new int[1 + maximumNumberOfParenthesisExpressions / 2];
                numberOfCorrectParentheses = sumOfCorrectParentheses(optionsForTheNumberOfOpenBracketsForTheSecondHalfOfTheLength, maximumNumberOfParenthesisExpressions);
                System.out.println(numberOfCorrectParentheses);
            } else System.out.println(0);
        }
        catch (BracketsLengthException e){
            System.err.println(e);
        }
    }
// sum of squares of correct parenthesis expressions
    private static long sumOfCorrectParentheses(int[] optionsForTheNumberOfOpenBracketsForTheSecondHalfOfTheLength, int maximumNumberOfParenthesisExpressions) {
        long result = 0;
        for (int i = 0; i < optionsForTheNumberOfOpenBracketsForTheSecondHalfOfTheLength.length; i++) {
            optionsForTheNumberOfOpenBracketsForTheSecondHalfOfTheLength[i] = 1 + maximumNumberOfParenthesisExpressions - (2 * i);
            result += squareOfSumNumberOfCorrectExpressions(i, optionsForTheNumberOfOpenBracketsForTheSecondHalfOfTheLength[i]);
        }
        return result;
    }
// the square of the sum of correct parentheses
    private static long squareOfSumNumberOfCorrectExpressions(int numberBrackets, int numberOfShifts) {
        LinkedList list = new LinkedList<Long>();
        if (numberBrackets != 0) {
            for (int i = 0; i < numberBrackets; i++) {
                list.addFirst(numberOfShifts + i);
            }
            return (long) Math.pow(sumNumberOfCorrectExpressions(list), 2);
        }

        return 1;
    }
// sum of correct parentheses per 1 opening parenthesis of the second half of the length of the expression
    private static long sumNumberOfCorrectExpressions(LinkedList list) {
        long result = 0;
        int length = list.size();
        for (; ; ) {
            if (list.isEmpty()) {
                break;
            }
            int number = (int) list.peek();
            if (list.size() < length) {
                if (number < 2) {
                    if (list.size() == 1) {
                        break;
                    } else {
                        list.pop();
                    }
                    continue;
                } else {
                    list.pop();
                    for (int i = 0; list.size() < length; i++) {
                        list.addFirst(number + i - 1);
                    }
                }
            } else if (list.size() == length) {
                result += (int) list.pop();
            }
        }
        return result;
    }
}
