package runnner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import StepDef.LoginNew;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="resources/featuresFile",
               glue= {"StepDef"},
               dryRun = false)
              // tags= {"@regression","~@sanity"})

public class Runner {
	
@AfterClass 
public static void cleanUP() {
	System.out.println("At After");
	LoginNew.driver.quit();
   }
}
