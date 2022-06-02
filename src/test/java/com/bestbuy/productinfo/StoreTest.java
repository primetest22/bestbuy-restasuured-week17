package com.bestbuy.productinfo;

import com.bestbuy.model.StorePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StoreTest extends TestBase {

       @Test
       public void getAllStores(){

           Response response = given()
                   .when()
                   .get("/stores");
           response.then().statusCode(200);
           response.prettyPrint();
       }
       @Test
       public void getStoreDetailWithId(){

           Response response = given()
                   .when()
                   .pathParam("id",4)
                   .get("/stores/{id}");
           response.then().statusCode(200);
           response.prettyPrint();

       }
       @Test
       public void createNewStore(){

              HashMap<Object, Object> servicesData = new HashMap<>();
               StorePojo storesPojo = new StorePojo();
               storesPojo.setName("Palace Toys");
               storesPojo.setType("Toys");
               storesPojo.setAddress("Pedder Road");
               storesPojo.setAddress2("Near Gymkhana");
               storesPojo.setCity("Mumbai");
               storesPojo.setState("MH");
               storesPojo.setZip("44551");
               storesPojo.setLat(45);
               storesPojo.setLng(44);
               storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");
               storesPojo.setServices(servicesData);

               Response response = given()
                       .header("Content-Type", "application/json")
                       .body(storesPojo)
                       .when()
                       .post("/stores");
               response.then().statusCode(201);
           response.prettyPrint();
       }
       @Test
       public void updateStore() {

           StorePojo storesPojo = new StorePojo();
           storesPojo.setName("Palace Toys");
           storesPojo.setType("Toys");
           storesPojo.setAddress("Pedder Road");
           storesPojo.setAddress2("Near Gymkhana");
           storesPojo.setCity("Ahmedabad");
           storesPojo.setState("MH");
           storesPojo.setZip("44551");
           storesPojo.setLat(45);
           storesPojo.setLng(44);
           storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

           Response response = given()
                   .header("Content-Type", "application/json")
                   .pathParam("id", 8925)
                   .body(storesPojo)
                   .when()
                   .patch("/stores/{id}");
           response.then().statusCode(200);
           response.prettyPrint();

       }
         @Test
         public void deleteStore(){

             Response response = given()
                     .header("Content-Type","application/json")
                     .pathParam("id",8925)
                     .when()
                     .delete("/stores/{id}");
             response.then().statusCode(404);
             response.prettyPrint();
         }

}
