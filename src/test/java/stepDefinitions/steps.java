package stepDefinitions;

import java.time.Duration;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AccountRegistrationPage;


public class steps {

    WebDriver driver;
   
    AccountRegistrationPage ar;
    
    ResourceBundle rb; // for reading properties file
    String br;

    @Before
    public void setup()
    {
       
        rb=ResourceBundle.getBundle("config");
        br=rb.getString("browser");
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());
        }
    }

    @Given("User Launch browser")
    public void user_launch_browser() {
        if(br.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("opens URL {string}")
    public void opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

   @When("User see the alert, clicks on the cross icon")
    public void user_navigate_to_my_account() throws InterruptedException {
        ar=new AccountRegistrationPage(driver);
        ar.checkifalertpresent();
       
    }
    @When("user is on homepage")
    public void Getallstorenames() throws InterruptedException {
    	ar=new AccountRegistrationPage(driver);
        ar.storenames();
        
    }
    @Then("user quits the browser")
    public void quitbrowser() {
    	driver.quit();
    }

    


}
