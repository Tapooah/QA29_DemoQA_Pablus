import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.alert().selectItemAlert();
        app.alert().selectAlerts();
    }


    @Test
    public void alertTestButton1() {
        app.alert().clickButton1();


    }

    @Test
    public void alertTestButton2() {
        app.alert().clickButton2();

    }

    @Test
    public void alertTestButton3Cancel() {
        app.alert().clickButton3Cancel();

    }

    @Test
    public void alertTestButton3Ok() {
        app.alert().clickButton3Ok();
    }

    @Test
    public void AlertSendTextTest() {
        app.alert().clickButton4TypeAndOk();

    }
}
