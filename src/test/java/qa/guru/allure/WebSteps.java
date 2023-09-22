package qa.guru.allure;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

public void openMainPage(){
    open("https://github.com/");
}

public void searchForRepository (String repository){
    $(".search-input-container").click();
    $("[id='query-builder-test']").sendKeys("eroshenkoam/allure-example");
    $("[id='query-builder-test']").submit();
}

public void openRepositoryLink(String REPOSITORY){
    $(linkText("eroshenkoam/allure-example")).click();
}

    public void openIssueTab() {
        $("#issues-tab").click();;
    }

    public void checkIssueWithName(Integer issueNumber) {
        $(withText("#" + issueNumber)).should(Condition.exist);
    }
}
