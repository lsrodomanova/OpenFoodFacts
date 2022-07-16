package tests.mobile;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalDriver implements WebDriverProvider {
    static LocalConfig localConfig = ConfigFactory.create(LocalConfig.class);
    String platformName = localConfig.platformName();
    String deviceName = localConfig.deviceName();
    String osLocalVersion = localConfig.osLocalVersion();

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(platformName);
        options.setDeviceName(deviceName);
        options.setPlatformVersion(osLocalVersion);
        options.setApp(app.getAbsolutePath());
        options.setAppPackage("org.openfoodfacts.scanner");
        options.setAppActivity("openfoodfacts.github.scrachx.openfood.features.splash.SplashActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private File getApp() {
        String appUrl = "https://github.com/openfoodfacts/openfoodfacts-androidapp/releases/tag/v3.8.1";
        String appPath = "src/test/resources/apk/off.apk";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app;
    }
}
