package com.in28minutes.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) //To automate Creation, Mocking and Injection of Mocks
class SomeBusinessImplMockTest {

    @Mock //Creates a Mock for DataService
    private DataService dataServiceMock;

    @InjectMocks //Injects multiple mocks into the class under test
    private SomeBusinessImpl businessImpl;

    @Test
    void findTheGreatestFromAllData_basicScenario () {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25 , 15 , 5}); //When retrieveAllData() is called, return this array
        assertEquals(25 , businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_withOneValue () {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
        assertEquals(35 , businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_EmptyArray () {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE , businessImpl.findTheGreatestFromAllData());
    }

}

//Mocks Advantages:
//1.Simpler to write
//2.Easier to add Scenarios , just change the when().thenReturn() statement in the test method.
//3.No need to create multiple Stub classes for different scenarios.
//4.On adding new methods to DataService, no changes needed in the test class unless those methods are used in the test.


