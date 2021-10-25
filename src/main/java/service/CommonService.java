package service;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import util.PropertyReader;

public class CommonService {

    private final RequestSpecification REQUEST_SPECIFICATION;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri(PropertyReader.getBaseUrl())
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .addQueryParam("key", PropertyReader.getKey())
            .addQueryParam("token", PropertyReader.getToken())
            .build();
    }

    public Response requestNoParams(Method method, String uri) {
            Response res = given(REQUEST_SPECIFICATION)
            .when().request(method, uri);
        return getRes(res);
    }

    public Response requestWithParams(Method method, String uri, Map<String, String> params) {
            Response res = given(REQUEST_SPECIFICATION)
                .queryParams(params)
            .when()
                .request(method, uri);
        return getRes(res);
    }

    protected <T> T parseDTOTrello(Response response, Class<T> t) {
        return new GsonBuilder()
            .create()
            .fromJson(response.getBody().asString(), t);
    }

    private Response getRes(Response res) {
        return res.then().statusCode(SC_OK)
            .extract()
            .response();
    }
}
