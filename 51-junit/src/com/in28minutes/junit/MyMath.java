package com.in28minutes.junit;

public class MyMath {

    public int calculateSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}


//Testing : Checking application behavior against expected behavior
//Option 1: Deploy the complete application and test
//->System Testing or Integration Testing
//Option 2:Test specific units of the application code independently
//i.e. test a specific method or a group of methods or an entire class-> Unit Testing

//ADVANTAGES OF UNIT TESTING
//~ Find bugs early(run under CI)
//~ Easy to fix bugs
//~ Reduces cost in Long Run

//POPULAR JAVA FRAMEWORKS ~ JUNIT & MOCKITO