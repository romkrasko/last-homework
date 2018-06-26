package com.gmail.romkrasko.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static com.gmail.romkrasko.core.BrowserFactory.driver;

public class Utils {
    private Actions actions = new Actions(driver);
    private WaiterClass waiterClass = new WaiterClass();

    public void customMove(WebElement element){
        waiterClass.WaitUntilElementIsEnable(element);
        actions.moveToElement(element);
        actions.perform();
    }
    public void customMoveWithoutWait(WebElement element){
        actions.moveToElement(element);
        actions.perform();
    }
}
