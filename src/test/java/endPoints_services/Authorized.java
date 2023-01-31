package endPoints_services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

public class Authorized {
    Response response;
    public void userAuthorized(){
        String password= ConfigurationReader.get("commonPassword");
        String username=ConfigurationReader.get("username");


        Map<String,Object> body=new HashMap<>();
        body.put("userName",username);
        body.put("password",password);


        Map<String,Object> token=new HashMap<>();
        body.put("Authorization", "Bearer" + ConfigurationReader.get("token"));

        response= RestAssured.given().contentType(ContentType.JSON)
                .headers(token)
                .body(body).log().all()
                .when()
                .post("/Account/v1/Authorized").prettyPeek();

    }
    public void verifyRegisterStatusCode(){
        response.then().statusCode(200);
    }


}

