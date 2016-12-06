package com.ons.dp.frontend.test.core;

import com.ons.dp.frontend.test.util.Helper;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;
import java.util.logging.Logger;

public class Configuration {
    public static final int DEFAULT_TIMEOUT_VALUE = 25;
    public static int DEFAULT_TIME_OUT = 2000;
    private Logger log = Logger.getLogger(Configuration.class.getCanonicalName());
    private String onsURL;
    private String onsdevelop_URL;
    private String florence_develop;
    private String ermintrude_develop;
    private String florence_discovery;
    private String ermintrude_discovery;
    private String prototypes_discovery;
    private String browser;
    private String browserStackBrowser;
    private boolean browserStackTunnel;
    private String browserStackUsername;
    private String browserStackAuthkey;

    public Configuration() {
        loadConfig("/files/local_config.yml");
        overrideConfigFromEnvironmentVariables();

        log.info("Test environment " + this.toString());
    }

     public String getOnsURL() {
        return onsURL;
    }

    public String getOnsdevelop_URL() {
        return onsdevelop_URL;
    }
    public String getFlorence_develop() {
        return florence_develop;
    }
    public String getErmintrude_develop() {
        return ermintrude_develop;
    }


    public String getFlorence_discovery() {
        return florence_discovery;
    }


    public String getErmintrude_discovery() {
        return ermintrude_discovery;
    }


    public String getPrototypes_discovery() {
        return prototypes_discovery;
    }


    public String getBrowser() {
        return browser;
    }


    public String getBrowserStackBrowser() {
        return browserStackBrowser;
    }

    public String getBrowserStackUsername() {
        return browserStackUsername;
    }

    public String getBrowserStackAuthkey() {
        return browserStackAuthkey;
    }

    public boolean getBrowserStackTunnel() {
        return browserStackTunnel;
    }

    @SuppressWarnings("rawtypes")
    private void loadConfig(String filePath) {
        InputStream input = Configuration.class.getResourceAsStream(filePath);
        Yaml yaml = new Yaml();
        Map map = (Map) yaml.load(input);
        Map<String, Object> config = (Map<String, Object>) map.get("config");

        if (config.containsKey("ons_url")) {
            onsURL = (String) config.get("ons_url");
        }
        if (config.containsKey("ons_develop")) {
            onsdevelop_URL = (String) config.get("ons_develop");
        }
        if (config.containsKey("florence_develop")) {
            florence_develop = (String) config.get("florence_develop");
        }
        if (config.containsKey("ermintrude_develop")) {
            ermintrude_develop = (String) config.get("ermintrude_develop");
        }
        if (config.containsKey("florence_discovery")) {
            florence_discovery = (String) config.get("florence_discovery");
        }
        if (config.containsKey("ermintrude_discovery")) {
            ermintrude_discovery = (String) config.get("ermintrude_discovery");
        }
        if (config.containsKey("prototypes_discovery")) {
            prototypes_discovery = (String) config.get("prototypes_discovery");
        }
        if (config.containsKey("browser")) {
            browser = (String) config.get("browser");
        }
        if (config.containsKey("browserStackBrowser")) {
            browserStackBrowser = (String) config.get("browserStackBrowser");
        }
        if (config.containsKey("browserStackTunnel")) {
            browserStackTunnel = (boolean) config.get("browserStackTunnel");
        }
        if (config.containsKey("browserStackUsername")) {
            browserStackUsername = (String) config.get("browserStackUsername");
        }
        if (config.containsKey("browserStackAuthkey")) {
            browserStackAuthkey = (String) config.get("browserStackAuthkey");
        }
    }

    private void overrideConfigFromEnvironmentVariables() {

        String ons_url_value = Helper.getSetting("TEST_ONS_URL");
        if (ons_url_value != null) {
            onsURL = ons_url_value;
        }
        String onsdevelop_url_value = Helper.getSetting("TEST_ONSDEVELOP_URL");
        if (onsdevelop_url_value != null) {
            onsdevelop_URL = onsdevelop_url_value;
        }
        String florence_develop_value = Helper.getSetting("TEST_FLORENCE_DEV");
        if (florence_develop_value != null) {
            florence_develop = florence_develop_value;
        }

        String ermintrude_develop_value = Helper.getSetting("TEST_ERMINTRUDE_DEV");
        if (ermintrude_develop_value !=null) {
            ermintrude_develop = ermintrude_develop_value;
        }
        String florence_discovery_value = Helper.getSetting("TEST_FLORENCE_DISC");
        if (florence_discovery_value !=null) {
            florence_discovery = florence_discovery_value;
        }
        String ermintrude_discovery_value = Helper.getSetting("TEST_ERMINTRUDE_DISCO");
        if (ermintrude_discovery_value !=null) {
            ermintrude_discovery = ermintrude_discovery_value;
        }
        String prototypes_discovery_value = Helper.getSetting("TEST_PROTOTYPES_DISC");
        if (prototypes_discovery_value !=null) {
            prototypes_discovery = prototypes_discovery_value;
        }
        String browser_value = Helper.getSetting("TEST_BROWSER");
        if (browser_value !=null) {
            browser = browser_value;
        }
        String browserStackBrowser_value = Helper.getSetting("BROWSER_STACK_BROWSER");
        if (browserStackBrowser_value !=null) {
            browserStackBrowser = browserStackBrowser_value;
        }
        String browserStackUsername_value = Helper.getSetting("BROWSERSTACK_USERNAME");
        if (browserStackUsername_value !=null) {
            browserStackUsername = browserStackUsername_value;
        }

        String browserstack_authkey = Helper.getSetting("BROWSER_STACK_AUTH_KEY");
        if (browserstack_authkey != null) {
            browserStackAuthkey = browserstack_authkey;
        }

        boolean browserstackTunnelValue =  Boolean.valueOf(Helper.getSetting("BROWSER_STACK_TUNNEL"));
        browserStackTunnel = browserstackTunnelValue;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "onsURL=" + onsURL +
                "onsdevelop_URL=" + onsdevelop_URL +
                ", florence_develop=" + florence_develop +
                ", ermintrude_develop=" + ermintrude_develop +
                ", florence_discovery=" + florence_discovery +
                ", ermintrude_discovery='" + ermintrude_discovery +
                ", prototypes_discovery=" + prototypes_discovery +
                ", browser=" + browser +
                ", browserStackBrowser='" + browserStackBrowser +
                ", browserStackTunnel=" + browserStackTunnel +
                ", browserStackUserName=" + browserStackUsername +
                ", browserStackAuthKey=" + browserStackAuthkey +
               '}';
    }

    }
