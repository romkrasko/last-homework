package com.gmail.romkrasko.pages;

        import com.gmail.romkrasko.core.WaiterClass;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.interactions.Actions;

        import java.util.List;

public class RefrigeratorsPages {

    private Actions actions;

    public RefrigeratorsPages(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions =  new Actions(driver);
    }
    public WebDriver driver;


    WaiterClass waiter = new WaiterClass();


    @FindBy(xpath = "//div[@class='layout layout_type_maya']/*[1]/*[2]/*[1]/*[1]/*[6]")
    public WebElement sortByDiscountButton;

    //div[@class='layout layout_type_maya']/*[2]/*[1]/*[2]/*[1]/*[1]


    public void sortDesc(){
        waiter.WaitUntilElementIsEnable(sortByDiscountButton);
        sortByDiscountButton.click();
        waiter.wait(1000);
    }

    public boolean checkSort() {
        List<WebElement> listElements =
                driver.findElements
                        (By.xpath("//div[@class='stickers__sticker stickers__sticker_type_discount']"));
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
        boolean result = true;
        for (int j = 1; j < size; j++)
            if (prices[j] > prices[j - 1]) {
                result = false;
            }
        waiter.wait(100);
        return result;
    }


}

