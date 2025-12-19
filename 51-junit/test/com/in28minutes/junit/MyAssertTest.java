package com.in28minutes.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {
    List<String> todos = Arrays.asList("AWS" , "Azure" , "GCP");
    @Test
    void testAsserts() {
        assertTrue(todos.contains("AWS") , "AWS not found");
        assertFalse(todos.contains("DevOps"));
        assertEquals(3 , todos.size() , "Size mismatch");
        assertNotNull(todos);
        assertArrayEquals(new String [] {"AWS" , "Azure" , "GCP"}, todos.toArray());
    }
}