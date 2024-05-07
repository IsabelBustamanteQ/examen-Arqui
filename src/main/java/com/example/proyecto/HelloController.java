package com.example.proyecto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements IHelloApi{
    @GetMapping("/")
    public String index() {

        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
//            Sentry.captureException(e);
        }
        return "Greetings from Spring boot";
    }

}
