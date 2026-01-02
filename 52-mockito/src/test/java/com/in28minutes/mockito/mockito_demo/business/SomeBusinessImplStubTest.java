package com.in28minutes.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplStubTest {

    @Test
    void findTheGreatestFromAllData_basicScenario () {
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(25 , result);
    }

    @Test
    void findTheGreatestFromAllData_withOneValue () {
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(35, result);
    }

}

//Here, Business Layer talks to a stub of Data Layer
//Creating a Stub class to simulate DataService, rather than using real DataService
class DataServiceStub1 implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {25 , 15 , 5};
    }
}

class DataServiceStub2 implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {35};
    }
}

//Problems with Stubs:
//1. If DataService has multiple methods, we need to implement all of them in the Stub class, even if we only need one method for the test.
//2. If we need different data for different tests, we need to create multiple Stub classes.