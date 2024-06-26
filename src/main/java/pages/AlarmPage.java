package pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlarmPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public AlarmPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));

    }
    public void clickOnAlarmTab(){
        driver.findElement(AppiumBy.id("com.google.android.deskclock:id/tab_menu_alarm")).click();
    }
    public void clickOnAddButton(){
        driver.findElement(AppiumBy.id("com.google.android.deskclock:id/fab")).click();
    }
    public void setTimeForAlarm(String hour,String minutes, String amorpm){
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\""+hour+" o'clock\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\""+minutes+" minutes\"]")));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\""+minutes+" minutes\"]")).click();
        driver.findElement(AppiumBy.id("com.google.android.deskclock:id/material_clock_period_"+amorpm.toLowerCase()+"_button")).click();
        driver.findElement(AppiumBy.id("com.google.android.deskclock:id/material_timepicker_ok_button")).click();
    }
    public void isAlarmTurnedOn(){
        WebElement budik = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.deskclock:id/onoff\").instance(1)"));
        String isChecked = budik.getAttribute("checked");

        if (isChecked.equals("true")){
            System.out.println("Alarm is ON");
        } else {
            System.out.println("Alarm is OFF");
        }

        WebElement monday = driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc=\"Monday\"]"));
        String mon_checked = monday.getAttribute("checked");
        WebElement tuesday = driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc=\"Tuesday\"]"));
        String tue_checked = tuesday.getAttribute("checked");
        WebElement friday = driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc=\"Friday\"]"));
        String fri_checked = friday.getAttribute("checked");

        if ((mon_checked.equals("true")) && (tue_checked.equals("true")) && (fri_checked.equals("true"))){
            System.out.println("Days are set corectlly");
        } else {
            System.out.println("Days are not set corectlly");
        }
    }
    public void selectDay(String day){
        driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc=\""+day+"\"]")).click();
    }
}
