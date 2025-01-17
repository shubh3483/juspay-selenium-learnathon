package com.juspay.pages.productorder;

import com.juspay.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSummaryPage extends AbstractPage {

    @FindBy(css = "#container div.cPHDOP.col-12-12.MfqIAz > div > form > button")
    private WebElement placeorder;

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.placeorder));
        return this.placeorder.isDisplayed();
    }

    public void clickPlaceOrder() {
        this.placeorder.click();
    }
}
