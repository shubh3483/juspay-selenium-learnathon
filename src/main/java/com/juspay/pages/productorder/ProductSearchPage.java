package com.juspay.pages.productorder;
import com.juspay.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductSearchPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header" +
            "/div[1]/div[2]/form/div/button")
    private WebElement searchButton;

    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        return this.searchBox.isDisplayed();
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    public void enterProductInSearchBox(String productName) {
        searchBox.sendKeys(productName);
    }

    public void clickOnSearchButton() {
        this.searchButton.click();
    }
}
