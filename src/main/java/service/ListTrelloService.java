package service;

import dto.ListTrelloDTO;
import io.restassured.http.Method;
import java.util.Map;
import util.URI;

public class ListTrelloService extends CommonService {

    public ListTrelloDTO createListTrello(Map<String, String> params) {
        return parseDTOTrello(requestWithParams(Method.POST, URI.ENDPOINT_LIST, params), ListTrelloDTO.class);
    }

    public ListTrelloDTO getListTrello(String idList) {
        return parseDTOTrello(requestNoParams(Method.GET, String.format(URI.ENDPOINT_LIST, idList)),
            ListTrelloDTO.class);
    }

    public ListTrelloDTO updateListTrello(Map<String, String> params, String idList) {
        return parseDTOTrello(requestWithParams(Method.PUT, URI.ENDPOINT_LIST + idList, params),
            ListTrelloDTO.class);
    }
}
