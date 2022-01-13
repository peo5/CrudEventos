package com.crudeventos.crudeventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
//@RequestMapping("/")
@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
}
