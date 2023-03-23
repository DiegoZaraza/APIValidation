package org.apivalidation.utility;

import io.restassured.response.Response;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;

import static io.restassured.RestAssured.given;

public class ApiUtilities {
    private final PropertiesRead propertiesRead;
    public ApiUtilities(PropertiesRead propertiesRead){
        this.propertiesRead = propertiesRead;
    }

    /**
     * Method that contains base to send post request rest assured
     *
     * @param bodyRequest
     * @param URL
     * @return Response
     */
    public Response sendPostRequest(String bodyRequest, String URL){
        return  given()
                .header("Content-type", "application/json")
                .header("Connection", "keep-alive")
                .urlEncodingEnabled(false)
                .and()
                .body(bodyRequest)
                .when()
                .post(URL)
                .then()
                .extract().response();
    }

    /**
     *
     * @param URL
     * @return
     */
    public Response sendGetRequest(String URL){
        return given().headers("Content-Type", "application/json").
                when().
                get(URL).
                then().extract().response();
    }

    /**
     *
     * @param response
     * @param fieldName
     * @return
     */
    public String extractValueBody(Response response, String fieldName) {
        return response.body().jsonPath().get(fieldName).toString();
    }
}

