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
        alarmPage.setTimeForAlarm("11","30","AM");
        alarmPage.isAlarmTurnedOn();
        alarmPage.selectDay("Monday");
        alarmPage.selectDay("Tuesday");
        alarmPage.selectDay("Friday");
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

        bedtimePage.clickOnBadtimeTab();
        bedtimePage.clickOnGetStartedButton();
        bedtimePage.setBadTime("7","30");
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