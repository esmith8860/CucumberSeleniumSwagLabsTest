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

import java.util.*;
import java.io.*;

public class BuyingSwagStepDfn {
    private WebDriver driver;
    private Double priceDouble;

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

    @Given("I am on the Swag Labs Home Page")
    public void i_am_on_the_swag_labs_home_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @Given("I am on the Swag Labs login page")
    public void i_am_on_the_swag_labs_login_page() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
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

    @When("I enter {string} as the username")
    public void I_enter_standard_user_as_the_username(String username) {
        driver.findElement(By.name("user-name")).sendKeys(username);
    }

    @And("I enter {string} as the password")
    public void I_enter_secret_sauce_as_the_password(String password) throws InterruptedException {
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);
    }

    //Using a list iterator
    @And("I enter the following data on Checkout Your Information page")
    public void I_enter_the_following_data_on_Checkout_Your_Information_page(List<String> yourInformation) throws InterruptedException {
        ListIterator<String> yourInformationIterator = yourInformation.listIterator();
        driver.findElement(By.name("firstName")).sendKeys(yourInformationIterator.next());
        driver.findElement(By.name("lastName")).sendKeys(yourInformationIterator.next());
        driver.findElement(By.name("postalCode")).sendKeys(yourInformationIterator.next());
        Thread.sleep(2000);

    }

    //Using an List
    @And("I input the following data on Checkout Your Information page")
    public void I_input_the_following_data_on_Checkout_Your_Information_page(List<String> yourInformation) throws InterruptedException {
        driver.findElement(By.name("firstName")).sendKeys(yourInformation.get(0));
        driver.findElement(By.name("lastName")).sendKeys(yourInformation.get(1));
        driver.findElement(By.name("postalCode")).sendKeys(yourInformation.get(2));
        Thread.sleep(2000);

    }

    //Using Stream
    @And("I complete the following data on Checkout Your Information page")
    public void I_complete_the_following_data_on_Checkout_Your_Information_page(List<String> yourInformation) throws InterruptedException {
        String target = "Marty";

        boolean found = yourInformation.stream().anyMatch(item -> item.equals(target));

        if (found) {
            System.out.print(target + " is in the list");
        } else {
            System.out.println(target + " is not in the list");
        }

        driver.findElement(By.name("firstName")).sendKeys(yourInformation.get(0));
        driver.findElement(By.name("lastName")).sendKeys(yourInformation.get(1));
        driver.findElement(By.name("postalCode")).sendKeys(yourInformation.get(2));

        Thread.sleep(2000);
    }

    @When("I click on all of the items")
    public void I_click_on_all_of_the_items() throws InterruptedException {
        List<WebElement> buttonList = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
        for (WebElement button: buttonList) {
            button.click();
        }
        //driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
        //driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"] | //button[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        //driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        //driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        //driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
        //driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        //driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
        //driver.findElement(By.xpath("//button[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();

        Thread.sleep(2000);
    }

    @And("I calculate the total cost of the items")
    public void I_calculate_the_total_cost_of_the_items() {
        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
        priceDouble = 0.0;
        for (WebElement price: priceList) {
            String priceNum = price.getText();
            int priceLength = priceNum.length();
            priceNum = priceNum.substring(1, priceLength);
            priceDouble += Double.parseDouble(priceNum);
        }
        System.out.println("Total Price: " + priceDouble);
    }

    @Then("I should be presented with the correct total")
    public void I_should_be_presented_with_the_correct_total() {
        WebElement total = driver.findElement(By.xpath("//div[@class=\"summary_subtotal_label\"]"));
        Assert.assertEquals(total.getText(), "Item total: $" + priceDouble);
    }

    @And("I remove all items from Your Cart")
    public void I_remove_all_items_from_Your_Cart() throws InterruptedException {
        List<WebElement> buttonList = driver.findElements(By.xpath("//button[contains(text(), 'Remove')]"));
        for (WebElement button: buttonList) {
            button.click();
        }
        /*
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"remove-test.allthethings()-t-shirt-(red)\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-onesie\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-fleece-jacket\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-bolt-t-shirt\"]")).click();
         */

        Thread.sleep(2000);
    }

    @And("I click Continue Shopping")
    public void I_click_Continue_Shopping() throws InterruptedException {
        //driver.findElement(By.cssSelector("[id=\"continue-shopping\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"continue-shopping\"]")).click();

        Thread.sleep(2000);
    }

    @Then("all items should show Add to cart")
    public void all_items_should_show_Add_to_cart() {
        List<WebElement> buttonList = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
        for (WebElement button: buttonList) {
            Assert.assertEquals(button.getText(), "Add to cart");
        }
        /*
        WebElement emptiedCart1 = driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        Assert.assertEquals(emptiedCart1.getText(), "Add to cart");
        WebElement emptiedCart2 = driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
        Assert.assertEquals(emptiedCart2.getText(), "Add to cart");
        WebElement emptiedCart3 = driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
        Assert.assertEquals(emptiedCart3.getText(), "Add to cart");
        WebElement emptiedCart4 = driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
        Assert.assertEquals(emptiedCart4.getText(), "Add to cart");
        WebElement emptiedCart5 = driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-onesie\"]"));
        Assert.assertEquals(emptiedCart5.getText(), "Add to cart");
        WebElement emptiedCart6 = driver.findElement(By.xpath("//button[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]"));
        Assert.assertEquals(emptiedCart6.getText(), "Add to cart");
         */
    }

    @When("I click on a random item")
    public void I_click_on_a_random_item() throws InterruptedException {
        List<WebElement> buttonList = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
        Random rand = new Random();
        int buttonSize = buttonList.size();
        int randomButton = rand.nextInt(buttonSize);
        WebElement button = buttonList.get(randomButton);
        button.click();

        System.out.println("Random number generated: " + randomButton);
        Thread.sleep(2000);
    }

    @When("I enter the listed usernames under Accepted usernames are")
    public void I_enter_the_listed_usernames_under_Accepted_usernames_are() throws InterruptedException {
        WebElement usernameList = driver.findElement(By.xpath("//div[@class='login_credentials']"));
        String splitString = usernameList.getText();
        String[] splitWithTitleUs = splitString.split("\n");
        List<String> usernames = new ArrayList<String>(Arrays.asList(splitWithTitleUs));
        usernames.removeFirst();

        WebElement passwordList = driver.findElement(By.xpath("//div[@class='login_password']"));
        String splitString2 = passwordList.getText();
        String[] splitWithTitlePa = splitString2.split("\n");

        for (String line : usernames) {
            driver.findElement(By.name("user-name")).sendKeys(line.trim());
            driver.findElement(By.name("password")).sendKeys(splitWithTitlePa[1]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='login-button']")).click();
            Thread.sleep(1000);
            try {
                driver.findElement(By.xpath("//input[@id='login-button']")).click();
            } catch (Exception e) {
                System.out.println("Exception Caught");
            } finally {
                System.out.println(driver.getCurrentUrl());
                if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
                    driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
                } else {
                    driver.findElement(By.name("user-name")).clear();
                    driver.findElement(By.xpath("//input[@id='password']")).clear();
                    Thread.sleep(1000);
                }
            }
            /*
            System.out.println(driver.getCurrentUrl());
            if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
                driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
            } else {
                driver.findElement(By.name("user-name")).clear();
                driver.findElement(By.name("password")).clear();
            }
             */
            /*
            driver.findElement(By.name("user-name")).sendKeys(line.trim());
            driver.findElement(By.name("password")).sendKeys(splitWithTitlePa[1]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='login-button']")).click();
            driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
            */
        }
    }

    @Then("I will see the inventory page")
    public void I_will_see_the_inventory_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
