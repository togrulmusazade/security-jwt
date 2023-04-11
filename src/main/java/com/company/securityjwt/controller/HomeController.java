package com.company.securityjwt.controller;

import com.company.securityjwt.entity.AuthRequest;
import com.company.securityjwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String helloJwt(){
        return "Hello JWT!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch (Exception exception){
            throw new Exception("Invalid username or password !");
        }
        return jwtService.generateToken(authRequest.getUsername());
    }

}



