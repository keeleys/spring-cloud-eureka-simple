package cc.sitec.eureka.provider.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @GetMapping("/hello")
    public Object hello() {
        return "Hello Wolrd!" ;
    }
}
