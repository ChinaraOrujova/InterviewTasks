package com.tasks.step_definitions;

import com.tasks.utilities.Driver;
import io.cucumber.java.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class Hook {

    @Before
    public void setupMethod(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDownMethod(){
        Driver.getDriver().quit();
    }


}
