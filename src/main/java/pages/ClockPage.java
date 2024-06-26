package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClockPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public ClockPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    public void clickOnClockTab(){
        driver.findElement(AppiumBy.id("com.google.android.deskclock:id/tab_menu_clock")).click();
    }

    public void clickOnAddCityButon(){
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Add city\"]\n")).click();
    }

    public void addCity(String city){
        WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText")));
        textarea.sendKeys(city);
        WebElement choosetown = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(4)")));
        choosetown.click();
    }

    public void checkAddedCity(String city){
        WebElement Town =  wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.deskclock:id/city_name")));
        String townIsEquals = Town.getAttribute("text");
        if (townIsEquals.equals(city)){
            System.out.println("The city was added correctly");
        } else System.out.println("Added city is not equal to expected city");
    }
}
