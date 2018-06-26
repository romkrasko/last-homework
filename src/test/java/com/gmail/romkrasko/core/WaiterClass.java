package com.gmail.romkrasko.core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WaiterClass {

    public void WaitUntilElementIsEnable(WebElement element) {
        long startTime = System.currentTimeMillis();
        int toy=1;
        while (true) {
            if (System.currentTimeMillis() - startTime > 10000) {
                System.out.println("Time out(");
                break;
            }
            try {
                element.isEnabled();
                break;

            }catch (NoSuchElementException | StaleElementReferenceException e) {toy++;}
        }
    }

    public void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("lol((");
        }
    }
}
