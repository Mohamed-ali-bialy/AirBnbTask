package Testing;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Actions {

    public static void clickon(WebElement element)
    {
        element.click();

    }
    public static void clickon(WebElement element,int count)
    {
       for (int i=0;i<count;i++)
       {
           element.click();
       }
    }
    public static void SendInput(WebElement element, String text)
    {
        element.sendKeys(text);

    }
    public static void SendInput_Enter(WebElement element, String text)
    {
        element.sendKeys(text);
        element.sendKeys(Keys.RETURN);
    }
}




