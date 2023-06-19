package env;

import com.codeborne.selenide.WebDriverRunner;
import config.DataConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class Env_mobile{
    public AppiumDriver driver;
    File app;
    AppiumDriverLocalService service;
    protected static final DataConfig data = ConfigFactory.create(DataConfig.class, System.getProperties());
    @BeforeSuite
    //Passing parameters from a file testng.xml
   // @Parameters({"platform"})
    public void setup() throws MalformedURLException {
        app = new File(data.getPathToApk());
        // get the configuration for the driver
        getConfiguration(data.getPlatform());
        // driver installation for selenide
        WebDriverRunner.setWebDriver(driver);

        // Required to get a screenshot after each  unsuccessful test
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    }

    /**  close the driver after running all the tests
     * You can change the annotation to AfterMethod. In this case, the application will close at the end of each test.
     */
    @AfterSuite
    private void tearDown(){
        driver.quit();

        // used to stop the appium server after tests have been completed
      /**  if (service != null) {
            service.stop();
        } **/
    }

    /** getting the configuration for the desired platform
     */
    public void getConfiguration(String runType) throws MalformedURLException {

        switch (runType){
            case("android"):
               driver = getAndroidDriver();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
               break;
        }

    }

    /** define common capabilities
     */
    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "autotests.cloud");
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

    /**
     Getting configuration for android
     deviceName - device name (emulator or physical device). Can be obtained using the command - adb devices
     app - application - path to the .apk file
     appPackage and appActivity - Can be obtained from developers or via command adb shell
     */
    public AppiumDriver getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", data.getDeviceName());
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        // default path to android server http://127.0.0.1:4723/wd/hub"
        return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    /** method for starting appium server automatically **/
    public void upAppium(){
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder
                .usingAnyFreePort()
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload");
        appiumServiceBuilder.withAppiumJS(new File("/home/hany/appium/server/app/main.js"));
        service = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        service.start();

    }

}
