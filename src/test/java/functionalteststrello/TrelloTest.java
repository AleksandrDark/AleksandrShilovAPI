package functionalteststrello;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import data.DataTest;

public class TrelloTest extends BaseTest {

    @Test
    public void checkBoardCreated() {
        boardParams.put("name", DataTest.BOARD_NAME);
        boardTrelloDTO = boardTrelloService.createBoardTrello(boardParams);
        assertionsTrello.checkBoardName(boardTrelloDTO, DataTest.BOARD_NAME);
    }

    @Test
    public void checkUpdatedBoard() {
        boardParams.put("name", DataTest.BOARD_NAME);
        boardTrelloDTO = boardTrelloService.createBoardTrello(boardParams);
        String idBoard = boardTrelloDTO.getId();
        boardTrelloService.getBoardTrello(idBoard);
        System.out.println(boardTrelloService);
        boardParams.put("name", DataTest.NEW_NAME_BOARD);
        boardTrelloDTO = boardTrelloService.updateBoardTrello(boardParams, idBoard);
        assertionsTrello.checkBoardName(boardTrelloDTO, DataTest.NEW_NAME_BOARD);
    }

    @Test
    public void checkCreatedList() {
        boardParams.put("name", DataTest.BOARD_NAME);
        boardTrelloDTO = boardTrelloService.createBoardTrello(boardParams);
        String idBoard = boardTrelloDTO.getId();
        listParams.put("name", DataTest.LIST_NAME);
        listParams.put("idBoard", idBoard);
        listTrelloDTO = listTrelloService.createListTrello(listParams);
        assertionsTrello.checkListName(listTrelloDTO, DataTest.LIST_NAME);
    }

    @Test
    public void checkUpdatedList() {
        boardParams.put("name", DataTest.BOARD_NAME);
        boardTrelloDTO = boardTrelloService.createBoardTrello(boardParams);
        String idBoard = boardTrelloDTO.getId();
        listParams.put("name", DataTest.LIST_NAME);
        listParams.put("idBoard", idBoard);
        listTrelloDTO = listTrelloService.createListTrello(listParams);
        String idList = listTrelloDTO.getId();
        listParams.put("name", DataTest.NEW_NAME_LIST);
        listTrelloDTO = listTrelloService.updateListTrello(listParams, idList);
        assertionsTrello.checkListName(listTrelloDTO, DataTest.NEW_NAME_LIST);
    }

    @Test
    public void checkCreatedListAndCardDeleteCard() {
        boardParams.put("name", DataTest.BOARD_NAME);
        boardTrelloDTO = boardTrelloService.createBoardTrello(boardParams);
        String idBoard = boardTrelloDTO.getId();
        listParams.put("name", DataTest.LIST_NAME);
        listParams.put("idBoard", idBoard);
        listTrelloDTO = listTrelloService.createListTrello(listParams);
        String idList = listTrelloDTO.getId();
        cardParams.put("name", DataTest.CARD_NAME);
        cardParams.put("idList", idList);
        cardTrelloDTO = cardTrelloService.createCardTrello(cardParams);
        assertionsTrello.checkCardName(cardTrelloDTO, DataTest.CARD_NAME);

        String idCard = cardTrelloDTO.getId();
        Response exc = cardTrelloService.deleteCardTrello(idCard);
        assertionsTrello.checkResponseIsEmpty(exc);
    }
}
