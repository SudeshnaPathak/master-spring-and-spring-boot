package com.in28minutes.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    @Test
    void calculateSum() {
        //Absence of failure is a success
        //Test Conditions or Asserts

        int[] numbers = {1, 2, 3};
        MyMath math = new MyMath();
        int result = math.calculateSum(numbers);
        System.out.println(result);
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }
}