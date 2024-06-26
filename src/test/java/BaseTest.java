import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://0.0.0.0:4723/wd/hub/";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:appPackage", "com.google.android.deskclock");
        dc.setCapability("appium:appActivity", "com.android.deskclock.DeskClock");
        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
    }
    @AfterTest
    public void quit(){
        driver.quit();
    }
}
