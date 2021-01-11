package com.trello.qa.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        //wd.findElement(locator).click();
        Actions action = new Actions(wd);
        action.moveToElement(wd.findElement(locator)).click().perform();
    }

    public void type(By locator, String text){
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void typeByScc(String cssSelector, String text) {
        if(text != null) {
            clickByCss(cssSelector);
            wd.findElement(By.cssSelector(cssSelector)).clear();
            wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
        }
    }

    public void clickByCss(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void clickYallaButton() {
        clickByCss(".let-carwork-style_let_car__submit__17482");
    }
}
