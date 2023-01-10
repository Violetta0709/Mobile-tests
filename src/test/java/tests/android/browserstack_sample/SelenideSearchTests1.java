package tests.android.browserstack_sample;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.net.MalformedURLException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearchTests1 extends TestBase {
    @Disabled
    @Test
    void successSearchTest() throws MalformedURLException, InterruptedException {
        open();
        $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        $$(byClassName("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
    }
}
