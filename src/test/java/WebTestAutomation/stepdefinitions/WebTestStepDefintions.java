
package WebTestAutomation.stepdefinitions;

import  WebTestAutomation.navigation.NavigateToWebTest;
import cucumber.api.java.en.Given;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//import static org.assertj.core.api.Assertions.assertThat;

public class WebTestStepDefintions {

    @Steps
    //NavigateToWebTest navigateTo1;
    NavigateToWebTest navigateTo1;
    WebDriver driver;
    String firstName, lastName, Salutation;
    String expectedString;
    String enteredSupporterLevel, expectedSupporterLevel, expectedLevelOfService, expectedSelectService, expectedchoosedSupporter, enteredSelectService;
    String Opportunity_name, Close_date, Stage, Primary_compaign_source, Amount;
    String Supporter_Level, Levels_Of_Service;
    String Phone;

    public WebTestStepDefintions() {
        driver = initialize();
    }

    public WebDriver initialize() {
        //String saleforceNotifications = getConfigurationDetails("webdriver.base.disable_notifications");
        //String driverName = getConfigurationDetails("webdriver.name.chrome");
        //String driverPath = getConfigurationDetails("webdriver.chrome.driver");
        //String WebTestURL = getConfigurationDetails("WebTest.URL");
        //System.out.println("-----------URL-----\n" + WebTestURL + "\n");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(option);
        driver = new ChromeDriver(option);
        return driver;
    }

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }

    //WebDriver driver = initialize();


    @Screenshots(beforeAndAfterEachStep=true)

    /*@Given("^I login to Salesforce URLt$")
    //@Step("I login to Salesforce URL$")
    public void i_login_to_Salesforce_URL() throws Throwable {

        driver = initialize();
       // navigateTo.LogintoSalesforce(driver);
        navigateTo1.LogintoSalesforce(driver);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/

    @Given("^I navigate to Web Application$")
    public void navigateToWebApp() throws Throwable {
        navigateTo1.navigateToWebApp(driver);
    }

    @Given("^I click on Login button$")
    public void loginWebApp() throws Throwable {
        navigateTo1.loginWebApp(driver);
    }

    @Given("^I enter username and password under sign in page$")
    public void enterGivenUsernameAndPassword() throws Throwable {
        navigateTo1.enterGivenUsernameAndPassword(driver);
    }
    @Given("^I enter (.*) and (.*) to login$")
    public void enterUsernameAndPassword(String username, String password) throws Throwable {
        navigateTo1.enterUsernameAndPassword(driver, username, password);
    }

    @Given("^I click log in button$")
    public void clickOnLogin() throws Throwable {
        navigateTo1.clickOnLogin(driver);
    }

    @Given("^I see the Heroku home page$")
    public void verifyHomePage() throws Throwable {
        navigateTo1.verifyHomePage(driver);
    }

    @Given("^I see incorrect credentials error message$")
    public void verifyLoginErrorMessage() throws Throwable {
        navigateTo1.verifyLoginErrorMessage(driver);
    }

    @Given("I navigate to Update Info & Contact$")
    public void navigateToContactAndInfo() throws Throwable {
        navigateTo1.navigateToContactAndInfo(driver);
    }

    @Given("I update the (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) and click on Update$")
    public void updateContact(String title, String mobile, String home, String work, String street, String city, String postcode, String state, String country) throws Throwable {
        navigateTo1.updateContact(driver, title, mobile, home, work, street, city, postcode, state, country);
    }

    @Given("^I see updated banner on the screen$")
    public void detailsUpdatedBanner() throws Throwable {
        navigateTo1.detailsUpdatedBanner(driver);
    }

    @Given("I navigate to Home screen$")
    public void navigateToHomeScreen() throws Throwable {
        navigateTo1.navigateToHomeScreen(driver);
    }

    @Given("^I see new updated (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) on screen$")
    public void detailsUpdated(String title, String mobile, String home, String work, String street, String city, String postcode, String state, String country) throws Throwable {
        navigateTo1.detailsUpdated(driver, title, mobile, home, work, street, city, postcode, state, country);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}


