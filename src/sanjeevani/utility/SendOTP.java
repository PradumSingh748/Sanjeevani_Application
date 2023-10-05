/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.utility;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;

/**
 *
 * @author PRADUM SINGH
 */
public class SendOTP implements Sender {

    @Override
    public boolean send(String no, String data) throws Exception {
        
            Unirest.setTimeouts(0,0);
            String mobNo=no;
            int otp=Integer.parseInt(data);
            String url = "https://2factor.in/API/V1/2f15a90f-ac78-11ed-813b-0200cd936042/SMS/"+mobNo+"/"+otp+"/OTP1";
            System.out.println("OTP is:"+otp);
            GetRequest gr=Unirest.get(url);
            HttpResponse<String>response=gr.asString();
            String result=response.getBody();
            return result.contains("Success");
        }
    
    
    
}
