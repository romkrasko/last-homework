package com.gmail.romkrasko.pages;

import com.gmail.romkrasko.core.WaiterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class MarketPage {

    private Actions actions;

    public MarketPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions =  new Actions(driver);
    }
    public WebDriver driver;

    private String[] firstPhoneNames = new String[2];
    private String[] secondPhoneNames = new String[2];

    WaiterClass waiter = new WaiterClass();



    @FindBy(css = ".input__control")
    public WebElement inputMarket;

    @FindBy(css = ".search2__button")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*[1]")
    public WebElement firstPhone;

    @FindBy(xpath = "//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*[2]")
    public WebElement secondPhone;

    @FindBy(xpath ="//div[@class='n-product-toolbar__item link link_theme_minor hint n-user-lists_type_compare i-bem n-user-lists_type_compare_in-list_no n-user-lists_type_compare_js_inited'][1]")
    public WebElement firstCompareButton;

    @FindBy(xpath ="//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*[2]/div/div/div/div/*[1]")
    public WebElement secondCompareButton;

    @FindBy(css = ".popup-informer__controls")
    public WebElement compareButton;

    @FindBy(xpath = "//div[@class='n-compare-content__line i-bem n-compare-content__line_js_inited']/*[1]")
    public WebElement firstPhoneInCompare;

    @FindBy(xpath = "//div[@class='n-compare-content__line i-bem n-compare-content__line_js_inited']/*[2]")
    public WebElement secondPhoneInCompare;

    @FindBy(xpath = "//div[@class='layout layout_type_maya layout_context_compare']/*[3]/div")
    public WebElement noProducts;

    @FindBy(xpath = "//ul[@class='topmenu__list']/*[1]")
    public WebElement electronicButton;

    @FindBy(xpath = "//ul[@class='topmenu__list']/*[3]")
    public WebElement techniqueButtom;

    @FindBy(xpath = "//div[@class='catalog-menu i-bem catalog-menu_js_inited']/*[4]//div/*[3]")
    public WebElement actionCamerasButton;

    @FindBy(xpath = "//div[@class='catalog-menu i-bem catalog-menu_js_inited']/*[2]//div/*[1]")
    public WebElement refrigeratorButton;


    public String getMarketPageTitle(){
        String marketPageTitle = driver.getTitle();
        return marketPageTitle;
    }

    public void sendValueInInput(){
        waiter.WaitUntilElementIsEnable(inputMarket);
        inputMarket.sendKeys("Note 8");
    }

    public void pressSearch(){
        waiter.WaitUntilElementIsEnable(searchButton);
        searchButton.click();
    }

    public void moveToFirstPhone(){
        waiter.WaitUntilElementIsEnable(firstPhone);
        actions.moveToElement(firstPhone);
        actions.perform();
        firstPhoneNames[0] = driver.
                findElement
                        (By.xpath("//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*[1]/*[4]/*[2]/a")).
                getAttribute("href");
        firstPhoneNames[0]=firstPhoneNames[0].substring(33,43);
        System.out.println(firstPhoneNames[0]);
    }

    public void moveToSecondPhone(){
        waiter.WaitUntilElementIsEnable(secondPhone);
        actions.moveToElement(secondPhone);
        actions.perform();
        secondPhoneNames[0] = driver.
                findElement
                        (By.xpath("//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*[2]/*[4]/*[2]/a")).
                getAttribute("href");
        secondPhoneNames[0]=secondPhoneNames[0].substring(33,43);
        System.out.println(secondPhoneNames[0]);
    }

    public void addToCompareFirstPhone(){
        firstCompareButton.click();
    }

    public void addToCompareSecondPhone(){
        secondCompareButton.click();
    }

    public void clickToCompareButton(){
        waiter.WaitUntilElementIsEnable(compareButton);
        waiter.wait(1000);
        compareButton.click();
    }

    public boolean compareProducts(){
        firstPhoneNames[1]= driver.findElement(By.xpath("//div[@class='n-compare-content__line i-bem n-compare-content__line_js_inited']/*[2]/a")).getAttribute("href");
        firstPhoneNames[1]=firstPhoneNames[1].substring(33,43);
        System.out.println(firstPhoneNames[1]);

        secondPhoneNames[1]= driver.findElement(By.xpath("//div[@class='n-compare-content__line i-bem n-compare-content__line_js_inited']/*[1]/a")).getAttribute("href");
        secondPhoneNames[1]=secondPhoneNames[1].substring(33,43);
        System.out.println(secondPhoneNames[1]);

        boolean comp= false;
        boolean i,i2;
        String first = new String(firstPhoneNames[1]);
        String second = new String(secondPhoneNames[1]);

        i=firstPhoneNames[0].equals(first);
        i2=secondPhoneNames[0].equals(second);
        if((i)&&(i2)) comp=true;
        return comp;
    }

    public void deleteFirst(){
        actions.moveToElement(firstPhoneInCompare);
        actions.perform();
        waiter.wait(1000);
        driver.findElement(By.xpath("//div[@class='n-compare-content__line i-bem n-compare-content__line_js_inited']/div/*[3]/*[2]")).click();
        waiter.wait(10000);
    }

    public void deleteSecond(){
        actions.moveToElement(secondPhoneInCompare);
        actions.perform();
        waiter.wait(1000);
        driver.findElement(By.xpath("//div[@class='n-compare-content__line i-bem n-compare-content__line_js_inited']/*[2]/div/*[2]")).click();
        waiter.wait(10000);
    }

    public String getNoProductsText(){
        waiter.WaitUntilElementIsEnable(noProducts);
        String prod = noProducts.getText();
        return prod;
    }

    public void clickToElectronicButton(){
        waiter.WaitUntilElementIsEnable(electronicButton);
        electronicButton.click();
    }

    public void clickToTechniqueButton(){
        waiter.WaitUntilElementIsEnable(techniqueButtom);
        techniqueButtom.click();
    }

    public void clickToActionCamerasButton(){
        waiter.WaitUntilElementIsEnable(actionCamerasButton);
        actions.moveToElement(actionCamerasButton);
        actions.perform();
        actionCamerasButton.click();
    }

    public void clickToRefrigeratorButton(){
        waiter.WaitUntilElementIsEnable(refrigeratorButton);
        actions.moveToElement(refrigeratorButton);
        actions.perform();
        refrigeratorButton.click();
    }
}
