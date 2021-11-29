package petStoreAssignment;

import io.restassured.RestAssured;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;

public class CreateUserTest {

    //Create one User
        @Test
        public void createUser()
        {
            UserData userData=new UserData(1,"Apitest1","Api1","Test1","Apitest1@gmail.com","Apitestpwd","9898767114",0);
            RestAssured.baseURI="https://petstore.swagger.io/v2";
            given().log().all().
                    header("Content-Type","application/json")
                    .body(userData).when().log().
                    body().post("/user").then().log().body().assertThat().statusCode(200);
        }

        //fetch the user (username:Apitest) details created
    @Test
    public void getUsercreated(){
        given().
                when().
                get("https://petstore.swagger.io/v2/user/Apitest1").
                then().assertThat().statusCode(200);
        System.out.println("statusCode = 200");
    }

    //Create 2 Users
        @Test
        public void createUserWithArray(){
            List<UserData> userData=new ArrayList<>();
            UserData userData1=new UserData(2,"Apitest2","Api2","Test2","Apitest2@gmail.com","Apitestpwd2","9898767654",0);
            UserData userData2=new UserData(3,"Apitest3","Api3","Test3","Apitest3@gmail.com","Apitestpwd3","4567876543",0);
            userData.add(userData1);
            userData.add(userData2);
            RestAssured.baseURI="https://petstore.swagger.io/v2";
            given().log().all().
                    header("Content-Type","application/json")
                    .body(userData).when().log().
                    body().post("/user/createWithArray").then().log().body().assertThat().statusCode(200);
        }

    //fetch the user (username:Apitest1) details created
    @Test
    public void getUser1created(){
        given().
                when().
                get("https://petstore.swagger.io/v2/user/Apitest2").
                then().assertThat().statusCode(200);
        System.out.println("statusCode = 200");
    }

    }
