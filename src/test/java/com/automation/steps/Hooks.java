package com.automation.steps;

import com.automation.utils.DriverManager;
import io.cucumber.java.AfterAll;


public class Hooks {

@AfterAll
public static void after_all() {
       DriverManager.tearDown();
    }
}