package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    public void chooseQuantity(String quantity) {
        chooseQuantityInput.click();
        chooseQuantityInput.clear();
        chooseQuantityInput.sendKeys(quantity);
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
}
