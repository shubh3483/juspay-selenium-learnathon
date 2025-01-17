package com.juspay.pages.productorder;

import com.juspay.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TermsAndConditionsPopupPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div/button")
    private WebElement acceptTermsButton;

    public TermsAndConditionsPopupPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(acceptTermsButton));
        return this.acceptTermsButton.isDisplayed();
    }

    public void acceptTermsButtonClick() {
        this.acceptTermsButton.click();
    }
}
