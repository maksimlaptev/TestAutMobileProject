package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/data.properties"
})

/** data for tests.
 path config/data.properties **/
public interface DataConfig extends Config {
    @Key("pathToApk")
    String getPathToApk();

    @Key("platform")
    String getPlatform();

    @Key("deviceName")
    String getDeviceName();
}

