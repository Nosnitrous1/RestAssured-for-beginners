package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {

  @Test
  public void testGet() {
    baseURI = "https://reqres.in/api";
    given().
      get("/users?page=2").
    then().
      statusCode(200).
      body("data[4].first_name", equalTo("George")).
      body("data.first_name", hasItems("George", "Rachel", "Byron"));
  }
  @Test
  public void testPost() {
    Map<String, Object> map = new HashMap<String, Object>();
    /* map.put("name", "Vladimir");
    map.put("job", "QA Specialist");
    System.out.println(map); */

    JSONObject request = new JSONObject(map);
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
      post("/users").
    then().
      statusCode(201).
      log().all();
    //     "id": "4",
    //    "createdAt": "2021-08-30T12:29:51.924Z"
    //    "id": "241",
    //    "createdAt": "2021-08-30T12:42:26.235Z"

  }

}
