package org.apivalidation.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;

public class ProductList extends BaseClass{
    private Response response;

    @Test
    public void validateStatusCode(){
        given().when().get(returnURL()).then().assertThat().statusCode(200);
    }

    @Test
    public void validateTimeResponse(){
        given().when().get(returnURL()).then().assertThat().time(Matchers.lessThan(timeResponse));
    }

    @Test
    public void validateSchema(){
        InputStream schema = getClass().getClassLoader().getResourceAsStream("productlistschema.json");
        given().headers("Content-Type", "application/json").
                when().
                get(returnURL()).
                then().
                statusCode(200).
                and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));
    }

    public String returnURL() {
        return baseURL + "productsList";
    }

    public void sendProductList(){
        response = apiUtilities.sendGetRequest(returnURL());
    }

    public Response getResponse() {
        return response;
    }
}
