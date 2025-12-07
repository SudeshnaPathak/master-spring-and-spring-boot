package com.in28minutes.learn_spring_framework.examples.c1;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {
    // BusinessCalculationService depends on DataService and MongoDataService & MySqlDataService implement DataService
    private final DataService dataService;

    // Constructor Injection
    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }
    public int FindMax()
    {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

}
