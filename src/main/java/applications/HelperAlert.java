package applications;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperAlert extends HelperBase {
    public HelperAlert(WebDriver wd) {
        super(wd);
    }

    public void selectItemAlert() {
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div/h5[.='Alerts, Frame & Windows']"));

    }

    public void selectAlerts() {
        hideFooter();
        click(By.xpath("//span[text()='Alerts']"));
    }

    public void clickButton1() {
        click(By.id("alertButton"));
        wd.switchTo().alert().accept();
    }

    public void clickButton2() {
        click(By.id("timerAlertButton"));
        WebDriverWait wait = new WebDriverWait(wd, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }

    public void clickButton3Cancel() {
        click(By.id("confirmButton"));
        WebDriverWait wait = new WebDriverWait(wd, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    public void clickButton3Ok() {
        click(By.id("confirmButton"));
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.accept();
        wd.switchTo().alert().accept();
    }

    public void clickButton4TypeAndOk() {
        click(By.id("promtButton"));
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.sendKeys("Pablus the Great");
//        alert.accept();
        wd.switchTo().alert().sendKeys("Pablus the Great");
        wd.switchTo().alert().accept();
    }


}
