package service;

import dto.CardTrelloDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;
import util.URI;

public class CardTrelloService extends CommonService {

    public CardTrelloDTO createCardTrello(Map<String, String> params) {
        return parseDTOTrello(requestWithParams(Method.POST, URI.ENDPOINT_CARD, params), CardTrelloDTO.class);
    }

    public CardTrelloDTO getCardTrello(String idCard) {
        return parseDTOTrello(requestNoParams(Method.GET, String.format(URI.ENDPOINT_CARD, idCard)), CardTrelloDTO.class);
    }

    public Response deleteCardTrello(String idCard) {
        return requestNoParams(Method.DELETE, URI.ENDPOINT_CARD + idCard);
    }
}
