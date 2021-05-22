package com.metanit.hello;

import com.metanit.factorial.Factorial;

public class Hello {
    public static void main(String[] args){

        int a = 5;
        int b = Factorial.calculate(a);
        System.out.printf("Factorial of %d is equal to %d \n", a, b);
    }
}
