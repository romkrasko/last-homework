package com.gmail.romkrasko.pages;

import com.gmail.romkrasko.core.Utils;
import com.gmail.romkrasko.core.WaiterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

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

    private WaiterClass waiter = new WaiterClass();
    private Utils utils = new Utils();


    @FindBy(css = ".input__control")
    public WebElement inputMarket;

    @FindBy(css = ".search2__button")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']")
    public WebElement firstPhone;

    @FindBy(xpath = "//a[@class='button button_size_m button_theme_normal i-bem button_js_inited']")
    public WebElement compareButton;

    @FindBy(xpath = "//div[@class='n-filter-sorter i-bem n-filter-sorter_js_inited n-filter-sorter_sort_desc n-filter-sorter_state_select']")
    public WebElement sordDescButton;

    @FindBy(xpath = "//div[@class='n-filter-sorter i-bem n-filter-sorter_js_inited n-filter-sorter_sort_asc n-filter-sorter_state_select']")
    public WebElement sordAscButton;

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

    @FindBy(xpath = "//div[@class='n-filter-block_pos_left i-bem']/*[3]")
    public WebElement sortByPriceButton;

    @FindBy(xpath = "//div[@class='price']")
    public List<WebElement> listElements;

    @FindBy(xpath = "//div[@style='height: auto;']")
    public WebElement checkerOfStyleForCheckSortCameras;

    @FindBy(xpath = "//div[@class='stickers__sticker stickers__sticker_type_discount']")
    public List<WebElement> listElementsRef;

    @FindBy(xpath = "//div[@class='layout layout_type_maya']/*[1]/*[2]/*[1]/*[1]/*[6]")
    public WebElement sortByDiscountButton;


    public void addPhoneToCompare(int number){
        moveToPhone(firstPhoneNames,number);
        getCompareElement(number).click();

    }

    public WebElement getComparedPhone2(int number){
        WebElement element = driver.findElement(By.xpath(
                "//div[@class='n-compare-content__line i-bem n-compare-content__line_js_inited']/*["+number+"]/a"
        ));
        return element;
    }

    public void moveToComparedPhone(String[] stringArr){
        waiter.WaitUntilElementIsEnable(getComparedPhone2(1));
        utils.customMove(getComparedPhone2(1));
        stringArr[0] = getComparedPhone2(2).getAttribute("href");
        stringArr[0]=stringArr[0].substring(33,43);

        stringArr[1] = getComparedPhone2(1).getAttribute("href");
        stringArr[1]=stringArr[1].substring(33,43);
    }

    public WebElement getPhoneElement(int number){
        WebElement element = driver.findElement(By.xpath(
                "//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*["+number+"]/*[4]/*[2]/a"
        ));
        return element;
    }

    public WebElement getCompareElement(int number){
        WebElement element = driver.findElement(By.xpath(
                "//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*["+number+"]/*[1]/div/div/div"
        ));
        return element;
    }

    public WebElement getComparedPhoneDeleteButton(int number){
        WebElement element = driver.findElement(By.xpath(
                "//div[@class='n-compare-content__line i-bem n-compare-content__line_js_inited']/*["+number+"]/*[3]/*[2]"
        ));
        return element;
    }

    public void sendValueInInput(){
        waiter.WaitUntilElementIsEnable(inputMarket);
        inputMarket.sendKeys("Note 8");
    }

    public void pressSearch(){
        waiter.WaitUntilElementIsEnable(searchButton);
        searchButton.click();
    }

    public void moveToPhone(String[] stringArr, int number){
        waiter.WaitUntilElementIsEnable(firstPhone);
        utils.customMove(getPhoneElement(number));
        stringArr[number-1] = getPhoneElement(number).getAttribute("href");
        stringArr[number-1]=stringArr[number-1].substring(33,43);
    }

    public void clickToCompareButton() {
        utils.customMove(compareButton);
        compareButton.click();
    }

    public boolean compareProducts() {

        moveToComparedPhone(secondPhoneNames);

        boolean comp = false;
        boolean i, i2;
        String first = new String(secondPhoneNames[0]);
        String second = new String(secondPhoneNames[1]);

        i = firstPhoneNames[0].equals(first);
        i2 = firstPhoneNames[1].equals(second);
        if ((i) && (i2)) comp = true;
        return comp;
    }

    public void deleteComparedPhone(int number) {
        waiter.WaitUntilElementIsEnable(getComparedPhoneDeleteButton(number));
        utils.customMove(getComparedPhoneDeleteButton(number));
        getComparedPhoneDeleteButton(number).click();
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
        utils.customMove(actionCamerasButton);
        actionCamerasButton.click();
    }

    public void clickToRefrigeratorButton(){
        waiter.WaitUntilElementIsEnable(refrigeratorButton);
        utils.customMove(refrigeratorButton);
        refrigeratorButton.click();
    }

    public void sortDesc() {
        waiter.WaitUntilElementIsEnable(sortByPriceButton);
        try {
            utils.customMoveWithoutWait(sordDescButton);
        } catch (NoSuchElementException ex){
            sortByPriceButton.click();
            sortDesc();
        }
    }

    public void sortAsc() {
        waiter.WaitUntilElementIsEnable(sortByPriceButton);
        try {
            utils.customMove(sordAscButton);
        } catch (NoSuchElementException ex){
            sortByPriceButton.click();
            sortDesc();
        }
    }

    public boolean checkSortCameras() {
        waiter.WaitUntilElementIsEnable(checkerOfStyleForCheckSortCameras);
        double[] prices = getArrOfPrices(listElements);
        return checkSort(prices);
    }

    public boolean checkSortRefrigerators(){
        double[] discounts = getArrOfDiscounts(listElementsRef);
        return checkSort(discounts);

    }

    public void sortByDiscount(){
        waiter.WaitUntilElementIsEnable(sortByDiscountButton);
        sortByDiscountButton.click();
    }

    public boolean checkSort(double[] array) {
        boolean result = true;
        for (int j = 1; j < array.length; j++)
            if (array[j] > array[j - 1]) {
                result = false;
            }
        return result;
    }

    public double[] getArrOfPrices(List<WebElement> listElements){
        int size = listElements.size();
        String[] strPrices = new String[size];
        double[] prices = new double[size];
        int i = 0;
        for (WebElement element : listElements) {
            strPrices[i] = element.getText();
            strPrices[i] = strPrices[i].substring(0, strPrices[i].length() - 5);
            strPrices[i] = strPrices[i].replace(",", ".");
            strPrices[i] = strPrices[i].replace(" ", "");
            prices[i] = Double.parseDouble(strPrices[i]);
            i++;
        }
        return prices;
    }

    public double[] getArrOfDiscounts(List<WebElement> listElements){
        int size = listElements.size();
        String[] strPrices = new String[size];
        double[] prices = new double[size];
        int i = 0;
        for (WebElement element : listElements) {
            strPrices[i] = element.getText();
            strPrices[i] = strPrices[i].substring(1, strPrices[i].length() - 1);
            prices[i] = Double.parseDouble(strPrices[i]);
            i++;
        }
        return prices;
    }
}