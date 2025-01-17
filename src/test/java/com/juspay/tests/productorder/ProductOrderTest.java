package com.juspay.tests.productorder;
import com.juspay.pages.productorder.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductOrderTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchProduct() {

        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.goTo("https://www.flipkart.com");
        Assert.assertTrue(productSearchPage.isAt());

        productSearchPage.enterProductInSearchBox("samsung s24");
        productSearchPage.clickOnSearchButton();
    }

    @Test(dependsOnMethods = "searchProduct")
    public void clickOnProduct(){
        ProductSelectPage productSelectPage = new ProductSelectPage(driver);
        Assert.assertTrue(productSelectPage.isAt());
        productSelectPage.clickOnProduct();
    }

    @Test(dependsOnMethods = "clickOnProduct")
    public void addProductToCart() {
        ProductAddToCartPage productAddToCartPage = new ProductAddToCartPage(driver);
        Assert.assertTrue(productAddToCartPage.isAt());
        productAddToCartPage.clickOnAddToCartButton();
    }

    @Test(dependsOnMethods = "addProductToCart")
    public void orderSummary() {
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
        Assert.assertTrue(orderSummaryPage.isAt());
        orderSummaryPage.clickPlaceOrder();
    }

    @Test(dependsOnMethods = "orderSummary")
    public void checkoutProduct() {
        OrderCheckoutPage orderCheckoutPage = new OrderCheckoutPage(driver);
        orderCheckoutPage.clickOnChangeBtn();
        orderCheckoutPage.enterUserDetails("Shubh", "1234567890", "12346", "qwerty","asdfgh","delhi","delhi");
        orderCheckoutPage.clickOnSaveAddressBtn();
        orderCheckoutPage.clickOnDeliverHereBtn();
        orderCheckoutPage.clickOnContinueBtn();
    }

    @Test(dependsOnMethods = "checkoutProduct")
    public void acceptTermsAndConditions() {
        TermsAndConditionsPopupPage termsAndConditionsPopupPage = new TermsAndConditionsPopupPage(driver);
        Assert.assertTrue(termsAndConditionsPopupPage.isAt());
        termsAndConditionsPopupPage.acceptTermsButtonClick();
    }

    @Test(dependsOnMethods = "acceptTermsAndConditions")
    public void selectPaymentMethod() {
        SelectPaymentMethodPage selectPaymentMethodPage = new SelectPaymentMethodPage(driver);
        Assert.assertTrue(selectPaymentMethodPage.isAt());
        selectPaymentMethodPage.selectPaymentMethod();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
