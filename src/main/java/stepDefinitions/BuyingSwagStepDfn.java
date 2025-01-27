package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class BuyingSwagStepDfn {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/java/drivers/msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the Swag Labs login page")
    public void i_am_on_the_swag_labs_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter an accepted username")
    public void i_enter_an_accepted_username() throws InterruptedException {
        driver.findElement(By.cssSelector("[name=\"user-name\"]")).sendKeys("standard_user");
    }

    @And("I enter a matching password")
    public void i_enter_a_matching_password() throws InterruptedException {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
    }

    @And("I click login")
    public void i_click_login() {
        driver.findElement(By.cssSelector("[value=\"Login\"]")).click();
    }

    @Then("the inventory page should be displayed")
    public void the_inventory_page_should_be_displayed() throws InterruptedException {
        WebElement productHeader = driver.findElement(By.xpath("//div[@id='header_container']"));
        Assert.assertEquals(productHeader.getText(), "Open Menu\n" +
                "Swag Labs\n" +
                "Products\n" +
                "Name (A to Z)\n" +
                "Name (A to Z)\n" +
                "Name (Z to A)\n" +
                "Price (low to high)\n" +
                "Price (high to low)");
        Thread.sleep(2000);
    }
}
