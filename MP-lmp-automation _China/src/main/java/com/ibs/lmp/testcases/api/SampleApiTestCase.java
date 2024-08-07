package com.ibs.lmp.testcases.api;

import com.ibs.model.Params;
import com.ibs.utils.APIUtils;
import com.ibs.utils.ExtentReportUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class SampleApiTestCase extends ExtentReportUtils {
  @Test(groups={"Product_TestCases"})
  public void Product_TC_002() throws Exception{
    Params param = new Params("Authorization","eyJhbGciOiJIUzUxMiJ9.eyJmaXJzdE5hbWUiOiJKb2huIiwibGFzdE5hbWUiOiJTbWl0aCIsInN1YiI6IjgyMDIiLCJwcm92aWRlciI6bnVsbCwibmFtZSI6IkpvaG4gU21pdGgiLCJleHAiOjE3MTk0Njk1NTIsInVzZXJJZCI6IklNMDAwODAxMDQ1MSIsInVzZXJEZXRhaWxzIjp7InByb2dyYW1zIjpbeyJkZXRhaWwiOiJjb3Jwb3JhdGV8SUJTfFBSRzE1fElNMDAwODAxMDMzMHxOQXxub21pbmVlfElNMDAwODAxMDQ1MXw4MjAyIiwicHJpdmlsZWdlcyI6W3siTUFVIjoiRiJ9LHsiVkEiOiJGIn0seyJNVCI6IkYifSx7Ik1DIjoiRiJ9LHsiVlMiOiJGIn0seyJNUCI6IkYifSx7IkNQTCI6IkZBIn1dfSx7ImRldGFpbCI6ImluZGl2aWR1YWx8SUJTfFBSRzE0fElNMDAwODAxMDQ1MXw4MjAyIn1dfSwiaWF0IjoxNzE5NDYyMzUyLCJlbWFpbCI6ImpvaG4uc21pdGhAZ21haWwuY29tIn0.9SQTeIc4DaiAsD8febjM9n5bAVzS2H-7Ba5OIIxX4pAxnzx7qvB9jR5w1wsK9UTJy_npZF4x-NgaoRP2YK0wLQ");
    List<Params> myList = new ArrayList<Params>();
    myList.add(param);
 //APIUtils.API_GET_Request("https://reqres.in/api","/users",myList);
      String baseUrl="https://memberportal.ibsplc.org/lmpapi-demo1/api/business-config-service/v1/";
      String resource= "config/data/mileagecalculator/IBS/PRG14";


   Response response=APIUtils.API_GET_Request(baseUrl,resource,myList);

    System.out.println("Status Code::"+response.getStatusCode());
    System.out.println("Body::"+response.getBody().asPrettyString());
    APIUtils.validateSuccessStatusCode(response);
  }




 // Response response=APIUtils.API_GET_Requests("https://reqres.in/api","/users",new Arr);


}
