package drivers;

import com.codeborne.selenide.WebDriverProvider;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new DesiredCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", "bsuser_drXmOQ");
        mutableCapabilities.setCapability("browserstack.key", "NA3q3jC2R3Y6xJhD4Ld8");

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", "bs://eaa86d7a195f73baf4cf0f94bc7cf15be3547159");

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", "Samsung Galaxy S22");
        mutableCapabilities.setCapability("os_version", "12.0");

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(new URL("http://hub.browserstack.com/wd/hub"), mutableCapabilities);
            }
}
