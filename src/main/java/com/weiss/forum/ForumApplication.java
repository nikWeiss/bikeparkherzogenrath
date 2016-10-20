/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weiss.forum;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Niklas
 */
@SpringBootApplication
public class ForumApplication {

    private static final Logger LOGGER = Logger.getLogger(ForumApplication.class.getName());

    /**
     * start the springboot application
     *
     * @param args
     */
    public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(ForumApplication.class, args);
    }
}
