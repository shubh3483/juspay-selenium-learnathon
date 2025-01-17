package com.juspay.pages.productorder;

import com.juspay.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectPaymentMethodPage extends AbstractPage {

    @FindBy(css = "label[for='CREDIT'] div[class='VTUEC- NBup7D'] div[class='j+SSYu'] div[class='_9-suWS'] div span")
    private WebElement paymentMethod;

    public SelectPaymentMethodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        Actions action = new Actions(driver);
        action.scrollToElement(this.paymentMethod);
        this.wait.until(ExpectedConditions.visibilityOf(paymentMethod));
        return this.paymentMethod.isDisplayed();
    }

    public void selectPaymentMethod() {
        this.paymentMethod.click();
    }

}
