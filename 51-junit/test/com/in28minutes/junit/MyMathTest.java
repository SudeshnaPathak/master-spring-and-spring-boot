package com.in28minutes.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    private final MyMath math = new MyMath();

    @Test
    void calculateSum_ThreeMemberArray() {
        //Absence of failure is a success
        //Test Conditions or Asserts
        assertEquals(6, math.calculateSum(new int[]{1, 2, 3}));
    }

    @Test
    void calculateSum_EmptyArray() {
        assertEquals(0, math.calculateSum(new int[]{}));
    }
}