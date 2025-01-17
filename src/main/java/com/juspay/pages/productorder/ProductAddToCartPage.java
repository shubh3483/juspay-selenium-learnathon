package com.juspay.pages.productorder;

import com.juspay.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductAddToCartPage extends AbstractPage {

    @FindBy(css = "button[class='QqFHMw vslbG+ In9uk2']")
    private WebElement addToCartButton;

    public ProductAddToCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.addToCartButton));
        return true;
    }

    public void clickOnAddToCartButton() {
        this.addToCartButton.click();
    }
}
