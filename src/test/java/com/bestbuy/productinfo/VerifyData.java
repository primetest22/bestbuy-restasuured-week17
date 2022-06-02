package com.bestbuy.productinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class VerifyData extends TestBase {

         static ValidatableResponse response;

         @BeforeClass
         public static void inIt(){
             RestAssured.baseURI = "http://localhost";
             RestAssured.port = 3030;
             response = given()
                     .when()
                     .get("/Stores")
                     .then().statusCode(200);
         }

    @Test
    public void test01(){
        int total = response.extract().path("total");
        System.out.println(total); }

    @Test
    public void test02(){
        int limit = response.extract().path("limit");
        System.out.println(limit);   }

    @Test
    public void test03() {
        String store=  response.extract().path("data[4].name");
        System.out.println("Fifth store : "+store);
    }

    @Test
    public void test04() {
        List<String> stores=  response.extract().path("data.name");
        System.out.println("List of  stores : "+stores);
    }
    @Test
    public void test05(){
        List<Integer> storeid = response.extract().path("data.id");
        System.out.println("Stores ids : " + storeid);
    }
    @Test
    public void test06(){
        int size = response.extract().path("data.size");
        System.out.println("Data lists : " + size);
    }
    @Test
    public void test07() {

            List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");
            System.out.println("The values for store name 'St Cloud' are: " + values);
        }

        @Test
        public void test08 () {
            List<String> address = response.extract().path("data.findAll{it.name=='Rochester'}.address");
            System.out.println("The address of stores with  name 'Rochester' is : " + address);
        }

        @Test
        public void test09 () {
            List<String> service = response.extract().path("data[7].services");
            System.out.println("The services provided by the store are: " + service);
        }

        @Test
        public void test10 () {
            List<List<String>> storeServices = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices");
            System.out.println("The services of Windows Store are: " + storeServices);
        }

        @Test
        public void test11 () {
            List<String> storeId = response.extract().path("data.services.storeservices.storeId");
            System.out.println("The storeId of all the store : " + storeId);
        }

        @Test
        public void test12 () {
            List<Integer> id = response.extract().path("data.id");
            System.out.println("The ID of all the store : " + id);
        }
        @Test
        public void test13 () {
            List<String> storeNames = response.extract().path("data.findAll{it.state=='ND'}.name");
            System.out.println("Name of the store where state = ND : " + storeNames);
        }
        @Test
        public void test014 () {
            List<List<Integer>> totalServices = response.extract().path("data.findAll{it.name=='Rochester'}.services.id");
            System.out.println("Total number of services for the store where store name is Rochester : " + totalServices.get(0).size());
        }

        @Test
        public void test15 () {
            List<?> created = response.extract().path("data.find{it.services}.services.findAll{it.name='Windows Store'}.storeservices.createdAt");
            System.out.println("Total createdAt for all services whose name is “Windows Store” : " + created);
        }
        @Test
        public void test16 () {
            List<String> services = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
            System.out.println("Total services Where store name = “Fargo” : " + services);
        }
        @Test
        public void test17 () {
            List<String> zip = response.extract().path("data.zip");
            System.out.println("Zip of all the store : " + zip);
        }
        @Test
        public void test18 () {
            String zip = response.extract().path("data[2].zip");
            System.out.println("Zip of Roseville store : " + zip);
        }
        @Test
        public void test19 () {
            List<?> services = response.extract().path("data.find{it.services}.services.findAll{it.name='Magnolia Home Theater'}");
            System.out.println("Storeservices of Magnolia Home Theater : " + services);
        }
        @Test
        public void test20 () {
            List<String> lat = response.extract().path("data.lat");
            System.out.println(" lat of all the stores : " + lat);
        }
    }




