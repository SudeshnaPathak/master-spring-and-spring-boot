package com.in28minutes.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    public int[] retrieveData() throws InterruptedException {
        Thread.sleep(30);
        return new int[] {111,222,333,444,555};
    }
}
