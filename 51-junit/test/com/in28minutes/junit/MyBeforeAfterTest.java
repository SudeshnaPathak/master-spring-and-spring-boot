package com.in28minutes.junit;

import org.junit.jupiter.api.*;

class MyBeforeAfterTest {

    @BeforeAll //Class level setup - runs once before all tests , Hence static
    static void beforeAll() {
        //Set up before all tests
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach() {
        //Set up before each test
        System.out.println("Before Each");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test
    void test3() {
        System.out.println("test3");
    }

    @AfterEach
    void afterEach() {
        //Clean Up after each test
        System.out.println("After Each");
    }

    @AfterAll //Class level clean up - runs once after all tests , Hence static
    static void afterAll() {
        //Clean Up after all tests
        System.out.println("After All");
    }
}