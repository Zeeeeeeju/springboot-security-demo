package securitydemo.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class HelloController {

    @GetMapping
    public String hello(){
        return "hello";
    }

    @GetMapping("/ha")
    public String hello2(){
        return "hello2";
    }

}
