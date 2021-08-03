package com.implemica.work.app_3;

import java.math.BigInteger;

public class Factorial {
    private static BigInteger bigInteger;

    //  write down the factorial number
    public static BigInteger factorial(Integer number) {
        bigInteger = new BigInteger(number.toString());
//      multiply the numbers
        for (int i = number - 1; i > 0; i--) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
//      return the factorial number
        return bigInteger;
    }

}
