package com.bestbuy.productinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductTest extends TestBase {

    @Test
    public void getAllProducts(){
        Response response = given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getById(){
        Response response = given()
                .when()
                .pathParam("id",43900)
                .get("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void createProduct(){

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Iphone 13");
        productPojo.setType("Smart Phone");
        productPojo.setPrice(1000);
        productPojo.setUpc("041333424");
        productPojo.setShipping(5);
        productPojo.setDescription("Compatible with all networks");
        productPojo.setManufacturer("Apple");
        productPojo.setModel("Iphone 13");
        productPojo.setUrl("www.apple.co.uk");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/apple-iphone-13.jpg");

        Response response = given()
                .header("Content-Type","application/json")
                .body(productPojo)
                .when()
                .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
