
package WebTestAutomation.navigation;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@RunWith(SerenityRunner.class)
public class NavigateToWebTest {

    @Test
    @Screenshots(beforeAndAfterEachStep=true)
    /*public void LogintoSalesforce(WebDriver driver) {

      //  String salesforceURL = getConfigurationDetails("WebTest.URL");
        driver.get("https://secure-staging.oxfam.org.au");
        driver.findElement(By.xpath("//div[contains(@class,'flex-nowrap')]//a[contains(text(),'Register')]")).click();
        insertRecordRegister(driver,"Title ","xyz");
        insertRecordRegister(driver,"First Name ","Oxfam");
        insertRecordRegister(driver,"Surname ","Australia");
        insertRecordRegister(driver,"Email ","xyz@oxfam.org.au");
        driver.findElement(By.xpath("//div[contains(@class,'form-group')]//button[contains(text(),'Continue')]")).click();

    }*/

    public void insertRecordRegister(WebDriver driver,String fieldTitle,String filedValue) {
        driver.findElement(By.xpath("//div[contains(@class,'form-group')]//label[contains(text(),'"+fieldTitle+"')]/..//input")).sendKeys(filedValue);
    }

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }

    public void navigateToWebApp(WebDriver driver) {
        driver.get("https://secure-staging.oxfam.org.au");
    }

    public void loginWebApp(WebDriver driver) {
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void enterGivenUsernameAndPassword(WebDriver driver) {
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("sumas@oxfam.org.au");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Oxfam@132");
    }

    public void enterUsernameAndPassword(WebDriver driver, String username, String password) {
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
    }

    public void clickOnLogin (WebDriver driver) {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void verifyHomePage (WebDriver driver) {
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isDisplayed();
    }

    public void navigateToContactAndInfo(WebDriver driver) {
        driver.findElement(By.xpath("//a[contains(text(),'Update Info & Contact')]")).click();
    }

    public void updateContact(WebDriver driver, String title, String mobile, String home, String work, String street, String city, String postcode, String state, String country) {
        updateTitle(driver, title);
        updateMobilePhone(driver, mobile);
        updateHomePhone(driver, home);
        updateWorkPhone(driver, work);
        updateMailingStreet(driver, street);
        updateMailingCity(driver, city);
        updateMailingPostalCode(driver, postcode);
        updateMailingState(driver, state);
        updateMailingCountry(driver, country);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private void updateMailingCountry(WebDriver driver, String country) {
        driver.findElement(By.xpath("//*[@name='contact[mailingcountry]']")).sendKeys(country);
    }

    private void updateMailingState(WebDriver driver, String state) {
        driver.findElement(By.xpath("//*[@name='contact[mailingstate]']")).clear();
        driver.findElement(By.xpath("//*[@name='contact[mailingstate]']")).sendKeys(state);
    }

    private void updateMailingPostalCode(WebDriver driver, String postcode) {
        driver.findElement(By.xpath("//*[@name='contact[mailingpostalcode]']")).clear();
        driver.findElement(By.xpath("//*[@name='contact[mailingpostalcode]']")).sendKeys(postcode);
    }

    private void updateMailingCity(WebDriver driver, String city) {
        driver.findElement(By.xpath("//*[@name='contact[mailingcity]']")).clear();
        driver.findElement(By.xpath("//*[@name='contact[mailingcity]']")).sendKeys(city);
    }

    private void updateMailingStreet(WebDriver driver, String street) {
        driver.findElement(By.xpath("//*[@name='contact[mailingstreet]']")).clear();
        driver.findElement(By.xpath("//*[@name='contact[mailingstreet]']")).sendKeys(street);
    }

    private void updateWorkPhone(WebDriver driver, String work) {
        driver.findElement(By.xpath("//*[@name='contact[npe01__workphone__c]']")).clear();
        driver.findElement(By.xpath("//*[@name='contact[npe01__workphone__c]']")).sendKeys(work);
    }

    private void updateHomePhone(WebDriver driver, String home) {
        driver.findElement(By.xpath("//*[@name='contact[homephone]']")).clear();
        driver.findElement(By.xpath("//*[@name='contact[homephone]']")).sendKeys(home);
    }

    private void updateMobilePhone(WebDriver driver, String mobile) {
        driver.findElement(By.xpath("//*[@name='contact[mobilephone]']")).clear();
        driver.findElement(By.xpath("//*[@name='contact[mobilephone]']")).sendKeys(mobile);
    }

    private void updateTitle(WebDriver driver, String title) {
        driver.findElement(By.xpath("//*[@name='contact[salutation]']")).clear();
        driver.findElement(By.xpath("//*[@name='contact[salutation]']")).sendKeys(title);
    }

    public void detailsUpdatedBanner(WebDriver driver) {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Your details are updated')]")).isDisplayed());
    }

    public void navigateToHomeScreen(WebDriver driver) {
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
    }

    public void detailsUpdated(WebDriver driver, String title, String mobile, String home, String work, String street, String city, String postcode, String state, String country) {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='contact[salutation]']")).getAttribute("value"), title);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='contact[mobilephone]']")).getAttribute("value"), mobile);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='contact[homephone]']")).getAttribute("value"), home);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='contact[npe01__workphone__c]']")).getAttribute("value"), work);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='contact[mailingstreet]']")).getAttribute("value"), street);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='contact[mailingcity]']")).getAttribute("value"), city);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='contact[mailingpostalcode]']")).getAttribute("value"), postcode);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='contact[mailingstate]']")).getAttribute("value"), state);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@name='contact[mailingcountry]']")).getAttribute("value"), country);
    }

    public void verifyLoginErrorMessage(WebDriver driver) {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Wrong email or password')]")).isDisplayed());
    }
}
    
   

    
