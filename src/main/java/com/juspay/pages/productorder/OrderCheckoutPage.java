package com.juspay.pages.productorder;

import com.juspay.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OrderCheckoutPage extends AbstractPage {

    @FindBy(css = "#container > div > div.lloqNF > div > div.zuxjMQ > div:nth-child(2) > div > div > button")
    private WebElement changeBtn;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]")
    private WebElement addAdressBtn;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(name = "pincode")
    private WebElement pincodeInput;

    @FindBy(name = "addressLine2")
    private WebElement localityInput;

    @FindBy(name = "addressLine1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "state")
    private WebElement stateInput;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/" +
            "form/div/div[7]/div/div/label[1]/div[2]/span")
    private WebElement timeInput;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form" +
            "/div/div[8]/button[1]")
    private WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"CNTCT19E9BA85FFEC4CE9808EDDC19\"]/button")
    private WebElement deliverHereBtn;

    @FindBy(xpath = "//*[@id=\"to-payment\"]/button")
    private WebElement continueBtn;

    public OrderCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnChangeBtn() {
        this.changeBtn.click();
        this.addAdressBtn.click();
    }

    public void enterUserDetails(String name, String phone, String pincode, String locality, String address, String city, String state) {
        this.nameInput.sendKeys(name);
        this.phoneInput.sendKeys(phone);
        this.pincodeInput.sendKeys(pincode);
        this.addressInput.sendKeys(address);
        this.cityInput.sendKeys(city);
        this.localityInput.sendKeys(locality);
        Select select = new Select(this.stateInput);
        select.selectByValue(state);
    }

    public void clickOnSaveAddressBtn(){
        this.saveBtn.click();
    }

    public void clickOnDeliverHereBtn(){
        this.wait.until(ExpectedConditions.visibilityOf(this.deliverHereBtn));
        this.deliverHereBtn.click();
    }

    public void clickOnContinueBtn(){
        this.wait.until(ExpectedConditions.visibilityOf(this.deliverHereBtn));
        this.continueBtn.click();
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.saveBtn));
        return this.saveBtn.isDisplayed();
    }
}
