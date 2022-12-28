package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class productExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);

    }


   //1.	Extract the title
    @Test
    public void test001() {
        List<String> title =response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("list of title are: "+title );
        System.out.println("------------------End of Test---------------------------");
    }
    //2.	Extract the total number of record
    @Test
    public void test002() {
        List<String> record =response.extract().path("record");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("list of record are: "+record );
        System.out.println("------------------End of Test---------------------------");
    }
    //3.	Extract the body of 15th record
    @Test
    public void test003() {
        String record =response.extract().path("[15].body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("list of record are: "+record );
        System.out.println("------------------End of Test---------------------------");
    }
    //4.	Extract the user_id of all the records
    @Test
    public void test004() {
        List<Integer>user_id =response.extract().path("user_id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("list of record are: "+user_id );
        System.out.println("------------------End of Test---------------------------");
    }
    //5.	Extract the title of all the records
    @Test
    public void test005() {
        List<String> title =response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("list of title are: "+title );
        System.out.println("------------------End of Test---------------------------");
    }

    //6.	Extract the title of all records whose user_id = 5456
    @Test
    public void test006() {
        List<String> title=response.extract().path("findAll{it.user_id == 5323}.title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("list of title are: "+title);
        System.out.println("------------------End of Test---------------------------");
    }
//7.	Extract the body of all records whose id = 2671


    @Test
    public void test007() {
        List<String>body=response.extract().path("findAll{it.id == 2617}.body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("list of title are: "+body);
        System.out.println("------------------End of Test---------------------------");
    }
}

