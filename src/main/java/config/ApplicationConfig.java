package config;

import org.aeonbits.owner.ConfigFactory;
import utils.Browsers;
import utils.PropertiesConfig;

public class ApplicationConfig {
    private static PropertiesConfig propertiesConfig = ConfigFactory.create(PropertiesConfig.class);
    public static final Integer IMPLICIT_WAIT_TIMEOUT = 10;
    public static final Browsers BROWSER = Browsers.CHROME;
    public static final String BASE_URL = propertiesConfig.baseUrl();
    public static final String USER_LOGIN = propertiesConfig.userLogin();
    public static final String USER_PASSWORD = propertiesConfig.userPassword();

}
