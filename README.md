# Mobile Automation Appium
Tests were created to test functionality of built-in Clock app on Android mobile device

## Setup
1. Clone the repository from git:
  ```sh
   git clone https://github.com/MatejSimai/MobileAutomation.git
  ```

## Requirements:
- Android studio
  - Android Virtual Device:
      1. **Medium Phone**
           - Size - 6.4
           - Resolutin - 1080x2400
           - Density - 420dpi
      2. **Release Name** - UpsideDownCake
      3. **Android Version** - Android 14.0 x86_64
      4. **API version** - 34
      5. **ABI version** - x86_64
      6. **RAM - 2048 MB**
      7. **Internal storage** - 6144 MB
      8. **SD card** - 512 MB
- Appium server - http://0.0.0.0:4723/wd/hub/
- IntelliJ Idea (created maven project)
- Appium Inspector

### Run test from cmd
  ```sh
mvn test
  ```

# Test Cases
### 1. Set up alarm 
- **Desc:** Set up alarm clock to 9.30 AM for 3 days of week (Monday, Tuesday, Friday)
- **Steps**
   1. Open Clock app
   2. Navigate to alarm clock tab
   3. Click on Add button
   4. Set up hour
   5. Set up minutes
   6. Set up if it is AM or PM
   7. Click on OK button
   8. Click on Monday
   9. Click on Tuesday
   10. Click on Friday
   11. Verify that the alarm is set for specific days and time
 
### 2. Add hometown time location
- **Desc:** Add hometown time location to clock app
- **Steps**
  1. Open Clock app
  2. Go to Clock tab
  3. Click on search field
  4. Add town "Košice"
  5. Choose "Košice" from listed dropdown
  6. Verify that hometown location was successfuly added to locations (cities) list
 
  ### 3. Set up Bedtime for working days
- **Desc:** Set up time when mobile app informs about time to sleep and wake up
- **Steps**
  1. Open Clock app
  2. Click on Get started button
  3. Click on time and set up wake up time
  4. Check if Sunday and Saturday are unchecked
  5. Click on next button
  6. Click on time and set up bed time
  7. Check if Sunday and Saturday are unchecked
  8. Click on done button
  9. Verify if bedtime and woke up time are set corectlly
