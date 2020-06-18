package edu.bjtu.javaee.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/indexPage")
    public String indexPage(){
        return "index";
    }

    @RequestMapping("/failPage")
    public String failPage(){
        return "fail";
    }
}
