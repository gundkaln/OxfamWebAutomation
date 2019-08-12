package WebTestAutomation;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.WithTag;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@WithTag("features:KeySupporter")
//@RunWith((SerenityRunner.class))
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/featuresSalesforce/KeySupporter/KeySupporterLevelA.feature"
)
 public class CucumberTestSuite {

 }



