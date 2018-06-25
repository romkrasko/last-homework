package com.gmail.romkrasko.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver driver;

    public static WebDriver getInstance() {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://www.yandex.by");
        return driver;
    }

    public static void falling(){
        if (driver != null)
            driver.quit();
    }
}

