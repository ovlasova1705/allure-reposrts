package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStep {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final Integer issueNumber = 80;


    @Test
    void lambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу github", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий по имени " + REPOSITORY, () -> {
            $(".search-input-container").click();
            $("[id='query-builder-test']").setValue(REPOSITORY);
            $("[id='query-builder-test']").submit();
        });
        step("В результатах поиска кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Кликаем на Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем что существует Issue с номером " + issueNumber, () -> {
            $(withText("#" + issueNumber)).should(Condition.exist);
        });
    }


}
