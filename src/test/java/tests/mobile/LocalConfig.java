package tests.mobile;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:properties/localmobile.properties"
})

public interface LocalConfig extends Config {
    String deviceName();
    String osLocalVersion();
    String platformName();
    String localUrl();
    String appPath();
    String login();
    String password();
}
