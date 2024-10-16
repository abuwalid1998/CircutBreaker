package com.example.circutbreaker.Controller;


import com.example.circutbreaker.Service.HandleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {


    @Autowired
    HandleServices handleServices;



    @GetMapping("/Welcome")
    public String Welcome() {
        return "Hello World!";
    }


    @GetMapping("/CallMethod")
    public String CallMethod() {
        return handleServices.performRemoteCall();
    }


}
