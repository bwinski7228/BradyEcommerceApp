package steps;


import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import setups.Capabilities;

public class RemoveItemTest extends Capabilities {
	
	/*
	 * @Before({"@RaraliQATeam"}) public void setup()throws Exception{
	 * preparation(); }
	 */
	
	@When("^Launch eCommerceApp home page$")
    public void launchApp() {
		File apkFile = new File("setups");
		File fs = new File(apkFile,"app-debug.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appiumVersion", "1.22.1");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.example.ecommerceapp");
        capabilities.setCapability("appActivity", ".MainActivity");
        //capabilities.setCapability("app", "/work-practice/bdd_testing/AppiumDemoProject/src/test/java/setups/app-debug.apk");
        //service = AppiumDriverLocalService.buildDefaultService();
        //service.start();
        //String service_url = service.getUrl().toString();
        String service_url = "http://127.0.0.1:4723/wd/hub";
        System.out.println("Appium Service Address: " + service_url);
        try {
			androidDriver = new AndroidDriver(new URL(service_url), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	
	
	@And("^Add item to cart$")
	public void addItem() {
		androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button")).click();
	}
	
	@And("^Navigate to cart page$")
	public void navToCart() {
		androidDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Cart\"]")).click();
	}
	
	@And("^Remove item from cart$")
	public void removeItem() {
		androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.Button\r\n"))
			.click();
	}
	
	@Then("^The toast should show item removed$")
	public void checkCart() {
		/*
		 * androidDriver.findElement(By.xpath("/hierarchy/android.widget.Toast" +
		 * "[contains(@text, 'Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops')]")
		 * ).isDisplayed();
		 */
		this.retryingFindClick(By.xpath("/hierarchy/android.widget.Toast" +
		  "[contains(@text, 'Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops')]"));
	}
	
	public boolean retryingFindClick(By by) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            androidDriver.findElement(by).click();
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}

}