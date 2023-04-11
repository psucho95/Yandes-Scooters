package YandexScooters.UI;

import Scooter_Data.UI.POM.MainPage;
import Scooter_Data.UI.Static.Answers;
import Scooter_Data.UI.Static.BasePage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnswersTest extends BasePage {

    @Test
    public void AllAnswerIsCorrect_true() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();
        objMainPage.scrollQuestionList();
        assertEquals("Answers isn't equals ",
        Answers.getExpectedAnswers(),
        objMainPage.getActualAnswers());
    }
}
