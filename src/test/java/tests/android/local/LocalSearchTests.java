package tests.android.local;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LocalSearchTests extends TestBase {
    @Tag("Mobile test")
    @DisplayName("Successfull search")
    @Owner("Veta Iuzykhovich")
    @Test
    void searchDockerWikiTest() {
        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Docker");
        });
        step("Check content found", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }

    @Tag("Mobile test")
    @DisplayName("Search Framework articles")
    @Owner("Veta Iuzykhovich")
    @Test
    void searchFrameworkPageTest() {
        back();
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Framework");
        });
        step("Verify content found", () -> {
            $$(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
        step("Checking page content is correct", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
            $(AppiumBy.className("android.webkit.WebView")).click();
            $(AppiumBy.className("android.widget.TextView")).shouldHave(text("Framework"));
        });
    }

    @Tag("Mobile test")
    @DisplayName("Onboarding screen")
    @Owner("Veta Iuzykhovich")
    @Test
    void getOnBoardingTest() {
        step("Check 'The Free Encyclopedia …in over 300 languages' text is visible", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Click on 'Сontinue'", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check 'New ways to explore' text is visible", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });

        step("Click on 'Сontinue'", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check 'Reading lists with sync' text is visible", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });

        step("Click on 'Сontinue'", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check 'Send anonymous data' text is visible", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
    }
}
