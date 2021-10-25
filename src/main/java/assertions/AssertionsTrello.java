package assertions;

import dto.BoardTrelloDTO;
import dto.CardTrelloDTO;
import dto.ListTrelloDTO;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public class AssertionsTrello {

    public void checkBoardName(BoardTrelloDTO boardTrelloDTO, String expected) {
        Assertions.assertThat(boardTrelloDTO.getName())
            .as("Actual name: \"%s\" differs from expected name: \"%s\"",
            boardTrelloDTO.getName(), expected).isEqualTo(expected);
    }

    public void checkListName(ListTrelloDTO listTrelloDTO, String expected) {
        Assertions.assertThat(listTrelloDTO.getName())
            .as("Actual name: \"%s\" differs from expected name: \"%s\"",
            listTrelloDTO.getName(), expected).isEqualTo(expected);
    }

    public void checkCardName(CardTrelloDTO cardTrelloDTO, String expected) {
        Assertions.assertThat(cardTrelloDTO.getName())
            .as("Actual name: \"%s\" differs from expected name: \"%s\"",
                cardTrelloDTO.getName(), expected).isEqualTo(expected);
    }

    public void checkResponseIsNull(Response expected) {
        Assertions.assertThat((Object) expected.path("_value"))
            .as("Expected response is not null").isNull();
    }

    public void checkResponseIsEmpty(Response expected) {
        Assertions.assertThat(expected.path("limits").toString())
            .as("Expected response is \"%s\"", expected.path("limits").toString()).isEqualTo("{}");
    }
}
