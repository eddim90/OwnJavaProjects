package jsonDTO;

public class ConfigData {
    String webdriverConfig;
    public ConfigData(String webdriverConfig) {
        this.webdriverConfig = webdriverConfig;

    }
    public String getWebdriverConfig() {
        return webdriverConfig;
    }
    @Override
    public String toString() {
        return "ConfigData{" +
                "webdriverConfig='" + webdriverConfig + '\'' +
                '}';
    }
}

