package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void softAssertionPageShouldBeInTheList() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(".wiki-more-pages-link").$("button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
    }

    @Test
    void jUnit5CodeShouldBeOnThePage() {
        open("/selenide/selenide/wiki/SoftAssertions");
        $("#wiki-body").shouldHave(text("Using JUnit5"));
    }
}
