package service;

import com.google.gson.GsonBuilder;
import dto.ListTrelloDTO;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Map;
import util.URI;

public class ListTrelloService extends CommonService {

    private ListTrelloDTO parseBoardTrello(Response response) {
        return new GsonBuilder()
            .create()
            .fromJson(response.getBody().asString(), ListTrelloDTO.class);
    }

    public ListTrelloDTO createListTrello(Map<String, String> params) {
        return parseBoardTrello(requestWithParams(Method.POST, URI.ENDPOINT_LIST, params));
    }

    public ListTrelloDTO getListTrello(String idList) {
        return parseBoardTrello(requestNoParams(Method.GET, URI.ENDPOINT_LIST + idList));
    }

    public ListTrelloDTO updateListTrello(Map<String, String> params, String idList) {
        return parseBoardTrello(requestWithParams(Method.PUT, URI.ENDPOINT_LIST + idList, params));
    }

}
