package com.juspay.pages.productorder;

import com.juspay.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductSelectPage extends AbstractPage {

    @FindBy(css = "#container .DOjaWF.YJG4Cf > div:nth-child(2) > div:nth-child(2)")
    private WebElement product;

    public ProductSelectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.product));
        return this.product.isDisplayed();
    }

    public void clickOnProduct() {
        this.product.click();
    }

}
