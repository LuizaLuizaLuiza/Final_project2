package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MakePurchaseSteps {
    PurchasePage purchasePage;
    WebDriver driver;

    @Given("^I'm logged in to My Store shop$")
    public void ImLoggedInToMyStoreShop() {
        System.setProperty("webdriver.chrome.driver", "/Users/luiza/Desktop/WebDrivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("nhpetpkjzraodylvuw@nbmbb.com", "test123");

    }

    @When("^I go to clothes tab$")
    public void IGoToClothesTab() {
        purchasePage = new PurchasePage(driver);
        purchasePage.goToClothes();
    }

    @And("^I choose product$")
    public void IChooseProduct() {
        purchasePage.chooseProduct();
    }

    @And("^I choose size$")
    public void IChooseSize() {
        purchasePage.chooseSize();
    }

    @And("^I choose quantity$")
    public void IChooseQuantity() {
        purchasePage.chooseQuantity();
    }

    @And("^I add product to the cart$")
    public void IAddProductToTheCart() {
        purchasePage.addToCart();
    }

    @And("^I go to cart$")
    public void IGoToCart() {
        purchasePage.goToCart();
    }

    @And("^I go to checkout$")
    public void IGoToCheckout() {
        purchasePage.goToCheckout();
    }

    @And("^I confirm the address$")
    public void IConfirmTheAddress() {
        purchasePage.confirmAddress();
    }

    @And("^I choose shipping method$")
    public void IChooseShippingMethod() {
        purchasePage.chooseShippingMethod();
    }

    @And("^I choose payment method$")
    public void IChoosePaymentMethod() {
        purchasePage.choosePaymentMethod();
    }

    @And("^I agree terms$")
    public void IAgreeTerms() {
        purchasePage.agreeTerms();
    }

    @And("^I confirm order$")
    public void IConfirmOrder() {
        purchasePage.confirmOrder();
    }

    @Then("^make screenshot$")
    public void makeScreenshot() {
        purchasePage.takeScreenshot("order_confirmation");
    }

    @And("^close browser$")
    public void closeBrowser() {
        driver.quit();
    }

}
