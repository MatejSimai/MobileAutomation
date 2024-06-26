import org.testng.annotations.Test;
import pages.AlarmPage;
import pages.BedtimePage;
import pages.ClockPage;

public class ClockTest extends BaseTest {
    @Test
    public void test1(){

        AlarmPage alarmPage = new AlarmPage(driver);

        alarmPage.clickOnAlarmTab();
        alarmPage.clickOnAddButton();
        alarmPage.setTimeForAlarm("9","30","AM");
        alarmPage.selectDay("Monday");
        alarmPage.selectDay("Tuesday");
        alarmPage.selectDay("Friday");
        alarmPage.isAlarmTurnedOn();
    }
    @Test
    public void test2(){

        ClockPage clockPage = new ClockPage(driver);

        clockPage.clickOnClockTab();
        clockPage.clickOnAddCityButon();
        clockPage.addCity("Košice");
        clockPage.checkAddedCity("Košice");
    }
    @Test
    public void test3(){

        BedtimePage bedtimePage = new BedtimePage(driver);

        bedtimePage.clickOnBedtimeTab();
        bedtimePage.clickOnGetStartedButton();
        bedtimePage.setBedTime("7","30");
        bedtimePage.uncheckDays("Sunday");
        bedtimePage.uncheckDays("Saturday");
        bedtimePage.clickOnNextButton();

        bedtimePage.setWokeUpTime("10","55");
        bedtimePage.uncheckDays("Sunday");
        bedtimePage.uncheckDays("Saturday");
        bedtimePage.clickOnNextButton();
        bedtimePage.checkTimes();
    }
}
