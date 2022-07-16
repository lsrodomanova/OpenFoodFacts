package tests.mobile;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static BrStackConfig mconfig = ConfigFactory.create(BrStackConfig.class);

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", mconfig.login());
        mutableCapabilities.setCapability("browserstack.key", mconfig.key());


        mutableCapabilities.setCapability("app", mconfig.appURL());


        mutableCapabilities.setCapability("device", mconfig.device());
        mutableCapabilities.setCapability("os_version", mconfig.osVersion());


        mutableCapabilities.setCapability("project", mconfig.project());
        mutableCapabilities.setCapability("build", mconfig.build());
        mutableCapabilities.setCapability("name", mconfig.name());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(mconfig.baseURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

