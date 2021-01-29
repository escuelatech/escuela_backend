package com.escuela.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PageResponseController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "index.html";
    }
}