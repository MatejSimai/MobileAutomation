package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BedtimePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public BedtimePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }
    public void clickOnBedtimeTab(){
        driver.findElement(AppiumBy.id("com.google.android.deskclock:id/tab_menu_bedtime")).click();
    }
    public void clickOnGetStartedButton(){
        driver.findElement(AppiumBy.id("com.google.android.deskclock:id/fab_container")).click();
    }
    public void setBedTime(String hour, String minutes){
        WebElement time = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.deskclock:id/target_clock")));
        time.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\""+hour+" o'clock\"]")));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\""+hour+" o'clock\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\""+minutes+" minutes\"]")));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\""+minutes+" minutes\"]")).click();
        driver.findElement(By.xpath("//android.widget.CompoundButton[@resource-id=\"com.google.android.deskclock:id/material_clock_period_am_button\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.google.android.deskclock:id/material_timepicker_ok_button\"]")).click();
    }
    public void uncheckDays(String day){
        WebElement bedtime= driver.findElement(AppiumBy.xpath("//android.widget.CheckBox[@content-desc=\""+day+"\"]"));
        String dayStatus = bedtime.getAttribute("checked");
        if (dayStatus.equals("true")){
            bedtime.click();
        }
    }
    public void clickOnNextButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.deskclock:id/bedtime_onboarding_next")));
        driver.findElement(AppiumBy.id("com.google.android.deskclock:id/bedtime_onboarding_next")).click();
    }
    public void setWokeUpTime(String hour, String minutes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.deskclock:id/target_clock")));
        driver.findElement(AppiumBy.id("com.google.android.deskclock:id/target_clock")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\""+hour+" o'clock\"]")));
        driver.findElement(By.xpath("//android.widget.CompoundButton[@resource-id=\"com.google.android.deskclock:id/material_clock_period_pm_button\"]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\""+hour+" o'clock\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\""+minutes+" minutes\"]")));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\""+minutes+" minutes\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.google.android.deskclock:id/material_timepicker_ok_button\"]")).click();
    }
    public void checkTimes(){
        WebElement bedtime_clock = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.deskclock:id/bedtime_clock")));
        WebElement wakeuptime_clock = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.deskclock:id/wake_clock")));
        String BedTime = bedtime_clock.getAttribute("text");
        String Wakeup = wakeuptime_clock.getAttribute("text");
        if ((Wakeup.contains("7:30")) && (BedTime.contains("10:55"))){
            System.out.println("Badtime was set up correctly, I go to bad at "+BedTime+" o'clock and wake up at "+Wakeup+" o'clock ");
        } else System.out.println("Time is not equal to added times");
    }
}
