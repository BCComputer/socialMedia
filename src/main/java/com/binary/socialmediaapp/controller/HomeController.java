package com.binary.socialmediaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"/list", "postlist"})
    public String homePage(Model m) {
        return "index/postIndex";
    }
}
