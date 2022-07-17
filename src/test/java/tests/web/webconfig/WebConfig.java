package tests.web.webconfig;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties/credentials.properties")
public interface WebConfig extends Config {
    String login();
    String password();
}
