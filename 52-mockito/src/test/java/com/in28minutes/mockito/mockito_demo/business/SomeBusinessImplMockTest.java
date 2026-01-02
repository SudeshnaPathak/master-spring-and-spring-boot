package com.in28minutes.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessImplMockTest {

    @Test
    void findTheGreatestFromAllData_basicScenario () {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25 , 15 , 5}); //When retrieveAllData() is called, return this array
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceMock);
        int result = business.findTheGreatestFromAllData();
        assertEquals(25 , result);
    }

    @Test
    void findTheGreatestFromAllData_withOneValue () {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35}); //When retrieveAllData() is called, return this array
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceMock);
        int result = business.findTheGreatestFromAllData();
        assertEquals(35 , result);
    }

}

//Mocks Advantages:
//1.Simpler to write
//2.Easier to add Scenarios , just change the when().thenReturn() statement in the test method.
//3.No need to create multiple Stub classes for different scenarios.
//4.On adding new methods to DataService, no changes needed in the test class unless those methods are used in the test.


