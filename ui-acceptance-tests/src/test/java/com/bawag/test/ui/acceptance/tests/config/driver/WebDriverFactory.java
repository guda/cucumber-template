package com.bawag.test.ui.acceptance.tests.config.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private static WebDriver webDriver;
    public static String FIREFOX = "FIREFOX";
    public static String CHROME = "CHROME";
    public static String PHANTOM = "PHANTOM";
    public static String MSEDGE = "MSEDGE";
    public static String IE = "IE";
    private static String BROWSER = System.getProperty("browser");
    private static String TIMEOUT = System.getProperty("timeout");
    private static String POLLING = System.getProperty("polling");
    private static String SCREENHEIGHT = System.getProperty("height");
    private static String SCREENWIDTH = System.getProperty("width");
    private static String HEADLESS = System.getProperty("headless");
    private static String OSNAME = System.getProperty("os.name").toLowerCase();
    private static FluentWait fluentwait;
    private static WebDriverWait wait;

    public WebDriverFactory() {
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void createWebDriver() {
        if (BROWSER == null) {
            BROWSER = CHROME;
        }

        int timeout;
        try {
            timeout = Integer.parseInt(TIMEOUT);
        } catch (Exception var11) {
            timeout = 12;
        }

        int polling;
        try {
            polling = Integer.parseInt(POLLING);
        } catch (Exception var10) {
            polling = 500;
        }

        int height;
        try {
            height = Integer.parseInt(SCREENHEIGHT);
        } catch (Exception var9) {
            height = 1200;
        }

        int width;
        try {
            width = Integer.parseInt(SCREENWIDTH);
        } catch (Exception var8) {
            width = 1920;
        }

        if (webDriver == null) {
            String var4 = BROWSER;
            byte var5 = -1;
            switch (var4.hashCode()) {
                case -2011747229:
                    if (var4.equals("MSEDGE")) {
                        var5 = 4;
                    }
                    break;
                case -131469639:
                    if (var4.equals("FIREFOX")) {
                        var5 = 0;
                    }
                    break;
                case 2332:
                    if (var4.equals("IE")) {
                        var5 = 3;
                    }
                    break;
                case 109585133:
                    if (var4.equals("PHANTOM")) {
                        var5 = 2;
                    }
                    break;
                case 1987167866:
                    if (var4.equals("CHROME")) {
                        var5 = 1;
                    }
            }

            ChromeOptions chromeOptions;
            switch (var5) {
                case 0:
                    System.setProperty("webdriver.gecko.driver", "src/test/driver/gecko_driver.exe");
                    if (!OSNAME.contains("windows")) {
                        System.setProperty("webdriver.gecko.driver", "src/test/driver/geckodriver");
                    }

                    FirefoxOptions options = new FirefoxOptions();
                    options.addPreference("security.sandbox.content.level", 5);
                    if (HEADLESS != null) {
                        options.setHeadless(true);
                    }

                    webDriver = new FirefoxDriver(options);
                    break;
                case 1:
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
                    if (!OSNAME.contains("windows")) {
                        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
                    }

                    if (HEADLESS != null) {
                        chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments(new String[]{"--headless"});
                        chromeOptions.addArguments(new String[]{"--disable-gpu"});
                        webDriver = new ChromeDriver(chromeOptions);
                    } else {
                        webDriver = new ChromeDriver();
                    }
                    break;
                case 3:
                    System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
                    if (!OSNAME.contains("windows")) {
                        System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer");
                    }

                    webDriver = new InternetExplorerDriver();
                    break;
                case 4:
                    System.setProperty("webdriver.edge.driver", "src/test/resources/driver/MicrosoftWebDriver.exe");
                    if (!OSNAME.contains("windows")) {
                        System.setProperty("webdriver.edge.driver", "src/test/resources/driver/MicrosoftWebDriver");
                    }

                    webDriver = new EdgeDriver();
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
                    if (!OSNAME.contains("windows")) {
                        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
                    }

                    if (HEADLESS != null) {
                        chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments(new String[]{"--headless"});
                        chromeOptions.addArguments(new String[]{"--disable-gpu"});
                        webDriver = new ChromeDriver(chromeOptions);
                    } else {
                        webDriver = new ChromeDriver();
                    }
            }

            webDriver.manage().window().setSize(new Dimension(width, height));
            webDriver.manage().timeouts().implicitlyWait((long) timeout, TimeUnit.SECONDS);
            fluentwait = (new FluentWait(getWebDriver())).withTimeout(Duration.ofSeconds((long) timeout)).pollingEvery(Duration.ofMillis((long) polling)).ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
            wait = new WebDriverWait(getWebDriver(), (long) timeout);
        }

    }

    public static void createWebDriver(String browser) {
        BROWSER = browser;
        createWebDriver();
    }

    public static void createWebDriver(String browser, int width, int height, int timeout, boolean headless) {
        BROWSER = browser;
        TIMEOUT = "" + timeout;
        SCREENWIDTH = "" + width;
        SCREENHEIGHT = "" + height;
        if (headless) {
            HEADLESS = "1";
        }

        createWebDriver();
    }

    public static void closeWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }

    }

    public static FluentWait getFluentWait() {
        return fluentwait;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void createBrowserStackDriver(String user, String key, DesiredCapabilities options, int timeouts) {
        try {
            String URL = "https://" + user + ":" + key + "@hub-cloud.browserstack.com/wd/hub";
            webDriver = new RemoteWebDriver(new URL(URL), options);
            fluentwait = (new FluentWait(getWebDriver())).withTimeout(Duration.ofSeconds((long) timeouts)).pollingEvery(Duration.ofMillis(500L)).ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
            wait = new WebDriverWait(getWebDriver(), (long) timeouts);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }
}
