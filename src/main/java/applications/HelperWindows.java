package applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class HelperWindows extends HelperBase {
    public HelperWindows(WebDriver wd) {
        super(wd);
    }

    public void selectBrowserWindows() {
        click(By.xpath("//span[.='Browser Windows']"));
    }


    public void clickOnNewTab() {
        click(By.id("tabButton"));
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
        System.out.println(wd.findElement(By.id("sampleHeading")).getText());

    }

    //click on button "new window" -> create list with new windows ->
// -> switch to new window index 1 -> print text from window and close window index 1 ->
// -> switch to main window index 0, close main window (can be closed with stop() from app manager).
    public void clickOnNewWindow() {
        click(By.id("windowButton"));
        List<String> windows = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(windows.get(1));
        System.out.println(wd.findElement(By.id("sampleHeading")).getText());
        wd.close();
        wd.switchTo().window(windows.get(0));
        wd.close();
    }

    public void catchNewWindowMessage() {
        click(By.id("messageWindowButton"));
        List<String> windows = new ArrayList<>(wd.getWindowHandles());


        wd.switchTo().window(windows.get(1));
        System.out.println(getAttribute("innerHTML"));//NULL


        System.out.println(wd.getPageSource());
        wd.close();
        wd.switchTo().window(windows.get(0));
        wd.close();
    }
}
