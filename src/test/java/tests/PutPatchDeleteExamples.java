package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

//import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.given;

public class PutPatchDeleteExamples {


  @Test
  public void testPut() {

    JSONObject request = new JSONObject();
    request.put("name", "Valentinovich");
    request.put("job", "QA Ingineer");
    System.out.println(request.toJSONString());

    baseURI = "https://reqres.in/api";

    given().
            header("Content-Type", "application/json").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
    when().
            put("/users/2").
    then().
            statusCode(200).
            log().all();
    //     "id": "4",
    //    "createdAt": "2021-08-30T12:29:51.924Z"
    //    "id": "241",
    //    "createdAt": "2021-08-30T12:42:26.235Z"

  }
  @Test
  public void testDelete() {

    baseURI = "https://reqres.in";

    when().
            delete("/api/users/2").
    then().
            statusCode(204).
            log().all();
  }

}
