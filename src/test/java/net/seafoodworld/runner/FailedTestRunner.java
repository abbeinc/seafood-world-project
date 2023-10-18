package net.seafoodworld.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//This Twst Runner has only one purpose
// to run failed scenario that stored inside rerun.txt
// it does nothing else!
@RunWith(Cucumber.class)
@CucumberOptions( glue = "net/seafoodworld/step_definition"
                 ,features = "@target/rerun.txt" )
// if we don't put @ before target @FailedTestRunner will think that this is a feature file

public class FailedTestRunner {

}
