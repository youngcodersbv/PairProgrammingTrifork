package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@SpringBootTest
public class HomeControllerTests {

    @Autowired
    private UserController controller;

    @Test
    public void initializtionTest() {
        // Check the context is loaded
        assertThat(controller).isNotNull();
    }

    @Test
    public void testModelProperties() {
        Model model = new ConcurrentModel();
        controller.index(model);
        assertThat(model.getAttribute("users")).isNotNull();
    }

}
