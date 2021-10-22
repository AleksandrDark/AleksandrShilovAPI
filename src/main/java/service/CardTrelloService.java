package service;

import com.google.gson.GsonBuilder;
import dto.CardTrelloDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;
import util.URI;

public class CardTrelloService extends CommonService {

    private CardTrelloDTO parseCardTrello(Response response) {
        return new GsonBuilder()
            .create()
            .fromJson(response.getBody().asString(), CardTrelloDTO.class);
    }

    public CardTrelloDTO createCardTrello(Map<String, String> params) {
        return parseCardTrello(requestWithParams(Method.POST, URI.ENDPOINT_CARD, params));
    }

    public CardTrelloDTO getCardTrello(String idCard) {
        return parseCardTrello(requestNoParams(Method.GET, URI.ENDPOINT_CARD + idCard));
    }

    public Response deleteCardTrello(String idCard) {
        return requestNoParams(Method.DELETE, URI.ENDPOINT_CARD + idCard);
    }
}
