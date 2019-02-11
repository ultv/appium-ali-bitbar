
        import io.appium.java_client.TouchAction;
        import io.appium.java_client.android.Activity;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.nativekey.AndroidKey;
        import io.appium.java_client.android.nativekey.KeyEvent;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Dimension;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
        import java.net.MalformedURLException;
        import java.net.URL;
        import static io.appium.java_client.touch.offset.PointOption.point;

        public class AliExpressTest {

        private AndroidDriver driver;
        private WebDriverWait wait;

            @BeforeMethod
            public void setup () throws MalformedURLException {

                DesiredCapabilities capabilities = new DesiredCapabilities();

                capabilities.setCapability("bitbar_apiKey", "h2QhvR63kyZBxkiudC2Jfd4ErECIK6mC");
                capabilities.setCapability("bitbar_app", "1cff238d-f8c4-495b-8d99-c813794bb4c6/Ali.apk");
                capabilities.setCapability("deviceName", "Google Pixel 9.0 -US");
                capabilities.setCapability("platform", "Android");
                capabilities.setCapability("bitbar_project", "appium-ali-bitbar");
                capabilities.setCapability("bitbar_testrun", "test_1");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("bitbar_target", "Android");
                capabilities.setCapability("bitbar_device", "Google Pixel 9.0 -US");
                capabilities.setCapability("forceMjsonwp", "true");

                driver = new AndroidDriver(new URL("https://appium.bitbar.com/wd/hub"), capabilities);
                wait = new WebDriverWait(driver, 5, 1000);
            }

            @Test
            public void signInNegativeTest () throws InterruptedException {

                driver.startActivity(new Activity("com.alibaba.aliexpresshd", "com.aliexpress.module.home.MainActivity"));

                //Click to menu
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/left_action"))).click();

                //Click to account
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/chosen_account_view"))).click();

                //Click to sign_in
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/btn_sign_in"))).click();

                //Send email
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/et_email"))).sendKeys("tgdj@gmail.com");

                //Send pass
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/et_password"))).sendKeys("qqqqqqq");

                //Click to in
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/rl_ali_sign_in_btn"))).click();

                //Get message
                String expectedText = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("android:id/message"))).getAttribute("text");

                Assert.assertEquals(expectedText, "Account does not exist. Please register an account to start shopping.");
            }

            @Test
            public void openSideMenuBySwipeTest () throws InterruptedException {

                //wait home page
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.ImageView[1]")));

                Dimension size = driver.manage().window().getSize();

                int anchor = (int) (size.height * 0.5);
                int startPoint = (int) (size.width * 0.01);
                int endPoint = (int) (size.width * 0.7);

                TouchAction action = new TouchAction(driver)
                        .press(point(startPoint, anchor))
                        .moveTo(point(endPoint, anchor))
                        .release().perform();

                //wait to account
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/chosen_account_view")));

                action
                        .press(point(endPoint, anchor))
                        .moveTo(point(startPoint, anchor))
                        .release().perform();
            }

            @Test
            public void findAppleTest () throws InterruptedException {

                //Click find field
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/search_hint"))).click();

                //Send text
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/abs__search_src_text"))).sendKeys("apple");

                driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
            }

            @Test
            public void signOrderByTest() throws InterruptedException {

                //Click to all_categories
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ImageView"))).click();

                //Click to computers
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[7]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"))).click();


                //Click to periferials
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.FrameLayout[4]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"))).click();

                //Click to mouses
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ImageView"))).click();

                //Click to orders
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("com.alibaba.aliexpresshd:id/search_view_more_label"))).click();

                //Click to from high to small
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView"))).click();
            }

            @AfterMethod
            public void teardown(){
                driver.quit();
            }

}
