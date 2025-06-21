package com.bigInteger;

import java.math.BigInteger;

public class BigIntegerClass {
    public static void main(String[] args) {
        int a = 30;
        int b = 67;

        BigInteger bi1 = BigInteger.valueOf(a);
        BigInteger bi2 = BigInteger.valueOf(b);
        // int values should be passed as strings
        BigInteger str = new BigInteger("198854");
        System.out.println(str);

        BigInteger constants = BigInteger.TWO;
        System.out.println(constants);

        BigInteger sum = bi1.add(bi2);
        System.out.println(sum);

        BigInteger x = new BigInteger("5386476784864646749648648989");
        BigInteger y = new BigInteger("27868767868768767868767867878");

        BigInteger subtraction = x.subtract(y);
        System.out.println("subtraction : " + subtraction);
        BigInteger multiply = x.multiply(y);
        System.out.println("multiply : " + multiply);
        BigInteger division = x.divide(y);
        System.out.println("division : " + division);

        System.out.println(Factorial.factorial(5));
    }
}
