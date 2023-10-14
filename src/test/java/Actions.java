import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Actions {

    public static void clickon(WebElement element)//click once
    {
        element.click();
    }
    public static void clickon(WebElement element,int count)//click with count
    {
        for (int i=0;i<count;i++)
        {
            element.click();
        }
    }
    public static void SendInput(WebElement element, String text)//send inputs
    {
        element.sendKeys(text);
    }
    public static void SendInput_Enter(WebElement element, String text)//send inputs  and click enter
    {
        element.sendKeys(text);
        element.sendKeys(Keys.RETURN);
    }
}

