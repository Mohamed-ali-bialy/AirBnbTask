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
    }// list of webelelments using By locator

    public WebElement findByCssSelector(String cssSelector) {
        return driverofselector.findElement(By.cssSelector(cssSelector));
    }//find webelement (cssSelector)
    
    public WebElement aria_label(String aria_value) {
        String cssSelector = String.format("[aria-label=\"%s\"]", aria_value);
        return driverofselector.findElement(By.cssSelector(cssSelector));
    }//find webelement (aria_label)
    
    public WebElement data_testid(String data_testid) {
        String cssSelector = String.format("[data-testid=\"%s\"]", data_testid);
        return driverofselector.findElement(By.cssSelector(cssSelector));
    }//find webelement (data_testid)
    
    public WebElement findById(String id) {
        return driverofselector.findElement(By.id(id));
    }//find webelement (id)
    
    public WebElement findByXPath(String xpath) {
        return driverofselector.findElement(By.xpath(xpath));
    }//find webelement (xpath)

    public WebElement findByName(String name) {
        return driverofselector.findElement(By.name(name));
    }//find webelement (findByName)
    
    public WebElement findByClassName(String className) {
        return driverofselector.findElement(By.className(className));
    }//find webelement (className)
    
    public WebElement findByLinkText(String linkText) {
        return driverofselector.findElement(By.linkText(linkText));
    }//find webelement (linkText)
    
    public WebElement findByPartialLinkText(String partialLinkText) {
        return driverofselector.findElement(By.partialLinkText(partialLinkText));
    }//find webelement (partialLinkText)


        public WebElement waitForElementToBePresent(By locator) {
        WebDriverWait wait1 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
            return wait1.until(ExpectedConditions.presenceOfElementLocated(locator));
        }//find webelement By locator and ExpectedConditions(presenceOfElementLocated)

    public WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait2 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
        return wait2.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }//find webelement By locator and ExpectedConditions(visibilityOfElementLocated)

    public WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait3 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
        return wait3.until(ExpectedConditions.elementToBeClickable(locator));
    }//find webelement By locator and ExpectedConditions(elementToBeClickable)

    public WebElement waitForElementToBeClickable(String classname) {
        WebDriverWait wait4 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
        return wait4.until(ExpectedConditions.elementToBeClickable(By.className(classname)));
    }//find webelement (classname) and ExpectedConditions(elementToBeClickable)

    public WebElement waitForElementToBeVisiblebycss(String css) {
        WebDriverWait wait5 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
        return wait5.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }//find webelement (cssSelector) and ExpectedConditions(visibilityOfElementLocated)

    public WebElement waitForElementToBeVisiblebyxpath(String xpath) {
        WebDriverWait wait6 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
        return wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }//find webelement (xpath) and ExpectedConditions(visibilityOfElementLocated)

    public WebElement waitForElementToBeVisiblebyxpathWithException(String xpath) throws Exception {
       try {
           WebDriverWait wait7 = new WebDriverWait(driverofselector, Duration.ofSeconds(25));
           return wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
       }catch (Exception e)
       {
           throw new Exception("",e);
       }
    }//find webelement (xpath) and ExpectedConditions(visibilityOfElementLocated) and Exception handler


    public boolean TextContainsSubstring(WebElement element,String sub_string)
    {
        if(element.getText().contains(sub_string))
        {
            return true;
        }
        else {return false;}
    }//check the subsrting inside element 
    
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
    }//find list of Strings using class name


    public List<String> findListOfTexts(String Parentclasses,String InternalCssRoute)
    {
        List <String>temp=new ArrayList<>();
            List<WebElement> innerDivs =driverofselector.findElements(By.className(Parentclasses));
            for(WebElement element:innerDivs)
            {
                try {
                    String str = (element.findElement(By.cssSelector(InternalCssRoute))).getText();
                    temp.add(str);
                }catch (Exception e){
                    temp.add("NotFoundElement");//add "NotFoundElement" when webelement is not found
                }
            }
        return temp;
    }
}//find list of Strings using class name and cssSelector for internal path
