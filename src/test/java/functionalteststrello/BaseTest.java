package functionalteststrello;

import assertions.AssertionsTrello;
import dto.BoardTrelloDTO;
import dto.CardTrelloDTO;
import dto.ListTrelloDTO;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import service.BoardTrelloService;
import service.CardTrelloService;
import service.ListTrelloService;
import data.DataTest;

public class BaseTest {

    protected BoardTrelloDTO boardTrelloDTO;
    protected ListTrelloDTO listTrelloDTO;
    protected CardTrelloDTO cardTrelloDTO;
    protected BoardTrelloService boardTrelloService = new BoardTrelloService();
    protected ListTrelloService listTrelloService = new ListTrelloService();
    protected CardTrelloService cardTrelloService = new CardTrelloService();
    protected Map<String, String> boardParams = new HashMap<>();
    protected Map<String, String> listParams = new HashMap<>();
    protected Map<String, String> cardParams = new HashMap<>();
    protected AssertionsTrello assertionsTrello = new AssertionsTrello();

    @BeforeMethod
    public void setUp() {
        boardParams.put("name", DataTest.BOARD_NAME);
        boardTrelloDTO = boardTrelloService.createBoardTrello(boardParams);
        assertionsTrello.checkBoardName(boardTrelloDTO, DataTest.BOARD_NAME);
    }

    @AfterMethod
    public void tearDown() {
        Response response = boardTrelloService.deleteBoardTrello(boardTrelloDTO.getId());
        assertionsTrello.checkResponseIsNull(response);
    }
}
