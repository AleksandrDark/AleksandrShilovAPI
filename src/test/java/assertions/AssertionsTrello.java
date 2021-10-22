package assertions;

import dto.BoardTrelloDTO;
import dto.CardTrelloDTO;
import dto.ListTrelloDTO;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public class AssertionsTrello {

    public void checkBoardName(BoardTrelloDTO boardTrelloDTO, String expected) {
        Assertions.assertThat(boardTrelloDTO.getName()).isEqualTo(expected);
    }

    public void checkListName(ListTrelloDTO listTrelloDTO, String expected) {
        Assertions.assertThat(listTrelloDTO.getName()).isEqualTo(expected);
    }

    public void checkCardName(CardTrelloDTO cardTrelloDTO, String expected) {
        Assertions.assertThat(cardTrelloDTO.getName()).isEqualTo(expected);
    }

    public void checkResponseIsNull(Response expected) {
        Assertions.assertThat((Object) expected.path("_value")).isNull();
    }

    public void checkResponseIsEmpty(Response expected) {
        Assertions.assertThat(expected.path("limits").toString()).isEqualTo("{}");
    }
}
