package utility;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@Slf4j
public class SeleniumBase {

    public void clickElement(WebElement element){
        try {
            element.click();
        }catch (Exception e){
            Log.fail("element could not be clicked! "+e);
        }
    }

    public String getTextOfElement(WebElement element){

        String text = null;
        try {
            text=element.getText();
        }catch (Exception e){
            Log.fail("The text of the element could not be retrieved.",e);
        }
        return text;
    }

    public void navigateTo(Enum<?> url){
        try {
            Driver.getDriver().get(DataFinder.getValue(url));
        }catch (Exception e){
            Log.fail("The requested URL was not visited."+ e);
        }
    }

    public void selectBrowserVariety(String variety){
        Driver.setUp(variety);
    }

    public void refreshThePage(){
        Driver.getDriver().navigate().refresh();
    }

    public String getCurrentUrl(){
        return Driver.getDriver().getCurrentUrl();
    }

    public String getTitle(){
        return Driver.getDriver().getTitle();
    }

    public Boolean isDisplayed(WebElement element){
        boolean displayed = false;
        try {
            displayed=element.isDisplayed();
        }catch (Exception e){
            Log.fail("Element could not be displayed!!"+e);
        }

        return displayed;
    }

    public void control(boolean statement, String onTrue, String onFalse) {

        if (statement) {
            Log.pass(onTrue);
        } else {
            Log.fail(onFalse);
        }

    }

    public void Wait(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveElementAndClick(WebElement element){
        try {
            Actions actions=new Actions(Driver.getDriver());
            actions.moveToElement(element).build().perform();
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();", element);

        }catch (Exception e){
            Log.fail("A problem was encountered in the element",e);
        }
    }

    public void moveElement(WebElement element){
        try {
            Actions actions=new Actions(Driver.getDriver());
            actions.moveToElement(element).build().perform();

        }catch (Exception e){
            Log.fail("A problem was encountered in the element",e);
        }
    }

    public void sendKeys(WebElement element, String text){
        try {
            element.sendKeys(text);
        }catch (Exception e){
            Log.fail("Text could not be sent.");
        }
    }

    public void switchToIframe(WebElement element) {

        Driver.getDriver().switchTo().frame(element);
    }
}
