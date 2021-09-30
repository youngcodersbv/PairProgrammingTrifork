package com.example.springboot.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCommute {
    @Test
    public void testFilter(){
        Commute commute = new Commute();
        commute.setHome("Amsterdam");
        commute.setWork("Rotterdam");

        assertTrue(Commute.filter("dam", commute));
        assertFalse(Commute.filter("haag", commute));

    }
}
