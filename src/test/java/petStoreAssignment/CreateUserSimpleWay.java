package petStoreAssignment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class CreateUserSimpleWay {
    public static void main(String[] args) {
        //Register end-point of a restful service
        RestAssured.baseURI ="https://petstore.swagger.io/v2";
        //Define HTTP request with request body parameters and path parameters
        RequestSpecification req=RestAssured.given();

        req.contentType("application/json");
        JSONObject reqbodyparam= new JSONObject();
        reqbodyparam.put("id","0");
        reqbodyparam.put("username","apitest1");
        reqbodyparam.put("firstName","api");
        reqbodyparam.put("lastName","test1");
        reqbodyparam.put("email","apitest1@gmail.com");
        reqbodyparam.put("password","apitest1");
        reqbodyparam.put("phone","+91 9886234234");
        reqbodyparam.put("userStatus","0");
        req.body(reqbodyparam.toString());
        //Submit request to get response
        Response response=req.post("/user");
        //Validate response
        int statusCode = response.getStatusCode();
        System.out.println("The status code recieved: " + statusCode);
        System.out.println("Response body: " + response.body().asString());
    }
}
