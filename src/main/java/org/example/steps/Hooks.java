package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.managers.DriverManager;
import org.example.managers.InitManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before
    public void before() {
        InitManager.initFramework();
    }


//
//    @AfterStep
//    public void afterStep(Scenario scenario){
//        if(scenario.isFailed()){
//            final byte[] screen = ((TakesScreenshot) DriverManager.getDriverManager().getDriver())
//                    .getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screen, "image/png", "Screen");
//        }
//
//    }


    @After
    public void after() {

        InitManager.quitFramework();
    }
}