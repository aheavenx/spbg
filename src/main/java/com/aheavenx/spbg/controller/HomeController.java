package com.aheavenx.spbg.controller;


import com.aheavenx.spbg.model.BlogPost;
import com.aheavenx.spbg.service.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;

@Controller
public class HomeController {

    @Autowired private PostService postService;
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("latestPost", postService.findAll().stream().sorted(Comparator.comparing(BlogPost::getTsPosted)).limit(1).findFirst().orElse(null));
        return "index";
    }
}