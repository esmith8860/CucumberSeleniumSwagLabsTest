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
    public void i_enter_an_accepted_username() {
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

    @Given("I successfully login")
    public void i_successfully_login() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[value=\"Login\"]")).click();
        Thread.sleep(1000);
    }
    @When("I click on Add to cart")
    public void i_click_on_add_to_cart() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        Thread.sleep(2000);
    }
    @And("I click on Your Cart")
    public void i_click_on_your_cart() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"shopping_cart_container\"]")).click();
        Thread.sleep(1000);
    }
    @And("I click on Checkout")
    public void i_click_on_checkout() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"checkout\"]")).click();
        Thread.sleep(2000);
    }
    @And("I enter a first name")
    public void i_enter_a_first_name() {
        driver.findElement(By.name("firstName")).sendKeys("John");
    }
    @And("I enter a last name")
    public void i_enter_a_last_name() {
        driver.findElement(By.name("lastName")).sendKeys("Doe");
    }
    @And("I enter a zip code")
    public void i_enter_a_zip_code() throws InterruptedException {
        driver.findElement(By.name("postalCode")).sendKeys("00000");
        Thread.sleep(2000);
    }
    @And("I click Continue")
    public void i_click_continue() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"continue\"]")).click();
        Thread.sleep(2000);
    }
    @And("I click Finish")
    public void i_click_finish() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=\"finish\"]")).click();
        Thread.sleep(2000);
    }
    @Then("I should be presented with a Thank You message")
    public void i_should_be_presented_with_a_thank_you_message() {
        WebElement thankYouHeader = driver.findElement(By.xpath("//div[@id=\"checkout_complete_container\"]"));
        Assert.assertEquals(thankYouHeader.getText(), "Thank you for your order!\n" +
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!\n" +
                "Back Home");
    }
}
