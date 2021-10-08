import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.alert().selectItemAlert();
        app.windows().selectBrowserWindows();
    }

    @Test
    public void newTabButtonTest() {
        app.windows().clickOnNewTab();
    }

    @Test
    public void newWindowTest() {
        app.windows().clickOnNewWindow();
    }

//+++++++++++++++++IT DOESN'T WORK+++++++++++++++++
    @Test
    public void NewWindowMessageTest() {
        app.windows().catchNewWindowMessage();
        app.stop();
    }
}
