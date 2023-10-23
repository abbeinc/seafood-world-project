package net.seafoodworld.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/features" //"classpath:features"
                ,glue = "net/seafoodworld/step_definition"
                ,publish = true// it will give you public link of your local html report (free)
                ,plugin = {"pretty",  "html:target/cucumber.html" // html page report
                            , "rerun:target/rerun.txt"// store the failed scenario into rerun.txt
                            }
                            ,dryRun = false


               //,tags="@single"
                ,tags="@regression"
                //,tags="@smoke"
                // ,tags="@sanity"
               // ,tags = "@ui"
            )

public class TestRunner {

}
