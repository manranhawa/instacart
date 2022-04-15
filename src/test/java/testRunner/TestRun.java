package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (
             
                features={".//features/Deleiveydetails.feature"},
                
                glue="stepDefinitions",
                dryRun=false,
                
                monochrome = true,
                plugin= {"pretty",
                        "html:reports/myreport.html",
                        "rerun:target/rerun.txt",    //Mandatory to capture failures
                       },

                       publish=true
        )

public class TestRun {
}
