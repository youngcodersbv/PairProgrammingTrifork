package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class HomeControllerTests {

    @Autowired
    private HomeController controller;

    @Test
    public void initializtionTest() {
        // Check the context is loaded
        assertThat(controller).isNotNull();
    }


}
