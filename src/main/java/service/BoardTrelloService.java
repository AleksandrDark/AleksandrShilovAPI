package service;

import com.google.gson.GsonBuilder;
import dto.BoardTrelloDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;
import util.URI;


public class BoardTrelloService extends CommonService {

    private BoardTrelloDTO parseBoardTrello(Response response) {
        return new GsonBuilder()
            .create()
            .fromJson(response.getBody().asString(), BoardTrelloDTO.class);
    }

    public BoardTrelloDTO createBoardTrello(Map<String, String> params) {
        return parseBoardTrello(requestWithParams(Method.POST, URI.ENDPOINT_BOARD, params));
    }

    public BoardTrelloDTO getBoardTrello(String idBoard) {
        return parseBoardTrello(requestNoParams(Method.GET, URI.ENDPOINT_BOARD + idBoard));
    }

    public BoardTrelloDTO updateBoardTrello(Map<String, String> params, String idBoard) {
        return parseBoardTrello(requestWithParams(Method.PUT, URI.ENDPOINT_BOARD + idBoard, params));
    }

    public Response deleteBoardTrello(String idBoard) {
        return requestNoParams(Method.DELETE, URI.ENDPOINT_BOARD + idBoard);
    }

}
