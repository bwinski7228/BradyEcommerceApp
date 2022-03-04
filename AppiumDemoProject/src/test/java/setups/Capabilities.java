package setups;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities extends DesiredCapabilities {
    protected AndroidDriver androidDriver;
    private AppiumDriverLocalService service;
    
protected void preparation() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "/AppiumDemoProject/src/test/java/setups/app-debug.apk");
        capabilities.setCapability("appActivity", "com.example.ecommerceapp.MainActivity");
        //service = AppiumDriverLocalService.buildDefaultService();
        //service.start();
        //String service_url = service.getUrl().toString();
        String service_url = "http://127.0.0.1:4724/wd/hub";
        System.out.println("Appium Service Address: " + service_url);
        androidDriver = new AndroidDriver(new URL(service_url), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
public void stopServer() {
        service.stop();
    }
}