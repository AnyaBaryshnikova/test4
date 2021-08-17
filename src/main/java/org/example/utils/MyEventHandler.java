package org.example.utils;

import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestStepFinished;
import io.qameta.allure.Allure;
import org.example.managers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MyEventHandler implements EventHandler<TestStepFinished> {


    @Override
    public void receive(TestStepFinished testStepFinished) {

    }



}

