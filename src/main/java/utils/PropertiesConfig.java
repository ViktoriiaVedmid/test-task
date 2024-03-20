package utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:application.properties"})
public interface PropertiesConfig extends Config {
    @Config.Key("base.url")
    String baseUrl();

    @Key("user.login")
    String userLogin();

    @Key("user.password")
    String userPassword();
}
