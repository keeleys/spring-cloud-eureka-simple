package cc.sitec.eureka.provider.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @GetMapping("/hello")
    public Object hello(@RequestParam String name) {
        return "Hello " + name ;
    }
}
