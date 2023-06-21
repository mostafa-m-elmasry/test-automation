package runner;

import io.cucumber.testng.CucumberOptions;
import tests.BaseTest;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)
public class RunnerTest extends BaseTest {

}
