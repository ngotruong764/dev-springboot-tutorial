package com.mycompany._thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class DemoController {
    // create a mapping for "/hello"
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(Model model){
        model.addAttribute("theDate",java.time.LocalDateTime.now());
        return "helloworld";
    }

}
