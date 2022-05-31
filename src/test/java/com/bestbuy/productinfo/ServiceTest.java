package com.bestbuy.productinfo;

import com.bestbuy.model.ServicePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

    public class ServiceTest extends TestBase {
        @Test
        public void getAllServices() {
            Response response = given()
                    .when()
                    .get("/services");
            response.then().statusCode(200);
            response.prettyPrint();
        }

        @Test
        public void getAServiceOfID() {
            Response response = given()
                    .pathParam("id",9)
                    .when()
                    .get("/services/{id}");
            response.then().statusCode(200);
            response.prettyPrint();
        }

        @Test
        public void createANewService() {
            ServicePojo servicePojo = new ServicePojo();
            servicePojo.setName("QA tester");
            Response response = given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .when()
                    .body(servicePojo)
                    .post("/services");
            response.prettyPrint();
            response.then().statusCode(201);
        }

        @Test
        public void updateANewService() {
            ServicePojo servicePojo = new ServicePojo();
            servicePojo.setName("Scrum Master");
            Response response = given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .pathParam("id",25)
                    .when()
                    .body(servicePojo)
                    .patch("/services/{id}");
            response.prettyPrint();
            response.then().statusCode(200);
        }
        @Test
        public void deleteAService() {
            ServicePojo servicesPojo = new ServicePojo();
            Response response = given()
                    .pathParam("id",25)
                    .when()
                    .delete("/services/{id}");
            response.prettyPrint();
            response.then().statusCode(200);
        }

    }



