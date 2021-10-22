package service;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import org.hamcrest.Matchers;
import util.PropertyReader;
import util.URI;

public class CommonService {

    private final RequestSpecification REQUEST_SPECIFICATION;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri(URI.BASE_URL)
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .addQueryParam("key", PropertyReader.getProperties().get("trelloKey").toString())
            .addQueryParam("token", PropertyReader.getProperties().get("trelloToken").toString())
            .build();
    }

    public Response requestNoParams(Method method, String uri) {
        return
            given(REQUEST_SPECIFICATION)
            .when()
                .request(method, uri)
            .then()
                .statusCode(Matchers.equalTo(SC_OK))
                .extract().response();
    }

    public Response requestWithParams(Method method, String uri, Map<String, String> params) {
        return
            given(REQUEST_SPECIFICATION)
                .queryParams(params)
            .when()
                .request(method, uri)
            .then()
                .statusCode(SC_OK)
                .extract()
                .response();
    }

}
