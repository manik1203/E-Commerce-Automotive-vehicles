/*
 *Author Name : Manikandan
 *Date : 24-01-2023
 */
package com.stackroute.Authentication.Automotive.vehicles.service;

import com.stackroute.Authentication.Automotive.vehicles.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JWTTokenGeneratorImpl implements JWTTokenGenerator{
    @Override

    public Map<String, String> jwtGenerator(User user) {


      Map<String,String>result= new HashMap<String,String>();

      Map<String,Object>userdata= new HashMap<>();

      userdata.put("emailId",user.getEmailId());
        userdata.put("role",user.getRole());

      String jwtToken = Jwts.builder()
              .setClaims(userdata)
              .setIssuer("HYUNDAI.COM")
              .setIssuedAt(new Date())
              .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(50).toInstant()))
              .signWith(SignatureAlgorithm.HS512,"privacy")
              .compact();
               result.put("Token",jwtToken);
               result.put("Response","Successfully Login,Token Generated");
               result.put("Status", user.getStatus());
               result.put("Role", user.getRole());
        return result;
    }
}
