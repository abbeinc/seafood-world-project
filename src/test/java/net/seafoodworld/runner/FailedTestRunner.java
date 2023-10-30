package net.seafoodworld.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions( glue = "net/seafoodworld/step_definition"
                 ,features = "@target/rerun.txt" )


public class FailedTestRunner {

}
