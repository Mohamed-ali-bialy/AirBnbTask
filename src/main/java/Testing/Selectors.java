package Testing;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;


public class Selectors {
    private WebDriver driverofselector;
    public Selectors(WebDriver driver) {
        driverofselector = driver;
    }

    public List<WebElement> findAllByLocator(By locator) {
        return driverofselector.findElements(locator);
    }

    public WebElement findByCssSelector(String cssSelector) {
        return driverofselector.findElement(By.cssSelector(cssSelector));
    }
    public WebElement aria_label(String aria_value) {
        String cssSelector = String.format("[aria-label=\"%s\"]", aria_value);
        return driverofselector.findElement(By.cssSelector(cssSelector));
    }
    public WebElement data_testid(String data_testid) {
        String cssSelector = String.format("[data-testid=\"%s\"]", data_testid);
        return driverofselector.findElement(By.cssSelector(cssSelector));
    }
    public WebElement findById(String id) {
        return driverofselector.findElement(By.id(id));
    }
    public WebElement findByXPath(String xpath) {
        return driverofselector.findElement(By.xpath(xpath));
    }

    public WebElement findByName(String name) {
        return driverofselector.findElement(By.name(name));
    }
    public WebElement findByClassName(String className) {return driverofselector.findElement(By.className(className));}
    public WebElement findByLinkText(String linkText) {
        return driverofselector.findElement(By.linkText(linkText));
    }
    public WebElement findByPartialLinkText(String partialLinkText) {return driverofselector.findElement(By.partialLinkText(partialLinkText));}


        public WebElement waitForElementToBePresent(By locator) {
        WebDriverWait wait1 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
            return wait1.until(ExpectedConditions.presenceOfElementLocated(locator));
        }

    public WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait2 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
        return wait2.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait3 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
        return wait3.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeVisiblebycss(String css) {
        WebDriverWait wait4 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
        return wait4.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }

    public WebElement waitForElementToBeVisiblebyxpath(String xpath) {
        WebDriverWait wait5 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
        return wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


    public boolean TextContainsSubstring(WebElement element,String sub_string)
    {
        if(element.getText().contains(sub_string))
        {
            return true;
        }
        else {return false;}
    }
    public List<String> findListOfStrings(String Class_name)
    {
        List<String>temp =new ArrayList<>();
        List<WebElement> tempelements = driverofselector.findElements(By.className(Class_name));
        for(WebElement element :tempelements)
        {
            String ss=element.getText();
            temp.add(ss);
        }
        return temp;
    }


}
