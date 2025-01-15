package pl.coderslab.shop;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PurchasePage {
    private static WebDriver driver;

    @FindBy(id = "category-3")
    WebElement goToClothesButton;

    @FindBy(css = "a[content*='id_product=22']")
    WebElement chooseProductButton;

    @FindBy(id = "group_1")
    WebElement chooseSizeSelect;

    @FindBy(id = "quantity_wanted")
    WebElement chooseQuantityInput;

    @FindBy(css = "button.bootstrap-touchspin-up")
    WebElement quantityUpButton;

    @FindBy(css = "button.btn.btn-primary.add-to-cart")
    WebElement addToCartButton;

    @FindBy(css = "a.btn.btn-primary[href*=\'controller=cart\']")
    WebElement goToCartButton;

    @FindBy(css = "a.btn.btn-primary[href*=\'controller=order\']")
    WebElement goToCheckoutButton;

    @FindBy(name = "confirm-addresses")
    WebElement confirmAddressButton;

    @FindBy(name = "confirmDeliveryOption")
    WebElement chooseShippingMethodButton;

    @FindBy(css = "label[for=\'payment-option-1\']")
    WebElement choosePaymentMethodRadio;

    @FindBy(name = "conditions_to_approve[terms-and-conditions]")
    WebElement agreeTermsCheckbox;

    @FindBy(id = "payment-confirmation")
    WebElement confirmOrderButton;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToClothes() {
        goToClothesButton.click();
    }

    public void chooseProduct() {
        chooseProductButton.click();
    }

    public void chooseSize() {
        Select select = new Select(chooseSizeSelect);
        select.selectByVisibleText("M");
    }

    public void chooseQuantity() {
        int currentQuantity = Integer.parseInt(chooseQuantityInput.getAttribute("value"));

        while (currentQuantity < 5) {
            quantityUpButton.click();
            currentQuantity = Integer.parseInt(chooseQuantityInput.getAttribute("value"));
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        goToCartButton.click();
    }

    public void goToCheckout() {
        goToCheckoutButton.click();
    }

    public void confirmAddress() {
        confirmAddressButton.click();
    }

    public void chooseShippingMethod() {
        chooseShippingMethodButton.click();
    }

    public void choosePaymentMethod() {
        choosePaymentMethodRadio.click();
    }

    public void agreeTerms() {
        agreeTermsCheckbox.click();
    }

    public void confirmOrder() {
        confirmOrderButton.click();
    }

    public void takeScreenshot(String screenshotName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String desktopPath = System.getProperty("user.home") + "/Desktop";
            Path destination = Path.of(desktopPath, screenshotName + "_" + System.currentTimeMillis() + ".png");

            Files.copy(screenshot.toPath(), destination);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }
    }
}
