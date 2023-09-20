package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenEnterprisePageFromSolutionsMenuTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void openEnterprisePageFromSolutionsMenu() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(byTagAndText("button", "Solutions")).hover();
        $(byText("Enterprise")).click();
        $(".enterprise-hero").shouldHave(text("Build like the best"));
    }
}
