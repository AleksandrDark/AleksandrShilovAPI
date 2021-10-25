package service;

import dto.BoardTrelloDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;
import util.URI;

public class BoardTrelloService extends CommonService {

    public BoardTrelloDTO createBoardTrello(Map<String, String> params) {
        return parseDTOTrello(requestWithParams(Method.POST, URI.ENDPOINT_BOARD, params), BoardTrelloDTO.class);
    }

    public BoardTrelloDTO getBoardTrello(String idBoard) {
        return parseDTOTrello(requestNoParams(Method.GET, String.format(URI.ENDPOINT_BOARD_GET, idBoard)),
            BoardTrelloDTO.class);
    }

    public BoardTrelloDTO updateBoardTrello(Map<String, String> params, String idBoard) {
        return parseDTOTrello(requestWithParams(Method.PUT, URI.ENDPOINT_BOARD + idBoard, params),
            BoardTrelloDTO.class);
    }

    public Response deleteBoardTrello(String idBoard) {
        return requestNoParams(Method.DELETE, URI.ENDPOINT_BOARD + idBoard);
    }
}
