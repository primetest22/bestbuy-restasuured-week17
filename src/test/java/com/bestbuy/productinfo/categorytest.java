package com.bestbuy.productinfo;

import com.bestbuy.model.CategoryPojo;
import com.bestbuy.testbase.TestBase;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class categorytest  extends TestBase {

    @Test
    public void getAllServices() {
        Response response = given()
                .queryParams("$limit",2)
                .queryParams("$skip",1)
                .when()
                .get("/categories");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getAServiceOfID() {
        Response response = given()
                .pathParam("id","abcat0020001")
                .when()
                .get("/categories/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createANewService() {
         CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setName("Gift Cards");
        categoryPojo.setId("abcat0010001");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .body(categoryPojo)
                .post("/categories");
        response.prettyPrint();
        response.then().statusCode(201);
    }

    @Test
    public void updateANewService() {
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setName("Gift Cards - 10 Euros");
        categoryPojo.setId("abcat0010011");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .pathParam("id","abcat0010001")
                .when()
                .body(categoryPojo)
                .patch("/categories/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void deleteAService() {
        CategoryPojo categoriesPoJo = new CategoryPojo();
        Response response = given()
                .pathParam("id","abcat0010001")
                .when()
                .delete("/categories/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }


}
