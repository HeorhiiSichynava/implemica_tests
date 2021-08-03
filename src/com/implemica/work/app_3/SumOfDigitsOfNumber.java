package com.implemica.work.app_3;

import java.math.BigInteger;

public class SumOfDigitsOfNumber {
    private static BigInteger bigInteger;

    //  we introduce the factorial number
    public static int sumOfDigits(BigInteger number) {
//      call the method for calculating the factorial and write it
        bigInteger =number;
        int sum = 0;
//      go through the digits of the number and write down the sum of the received digits
        for (int i = bigInteger.toString().length(); i > 0; i--) {
            sum = bigInteger.remainder(BigInteger.TEN).intValue() + sum;
            bigInteger = bigInteger.divide(BigInteger.TEN);
        }
        return sum;
    }
}
