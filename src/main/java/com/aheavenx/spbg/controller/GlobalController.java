package com.aheavenx.spbg.controller;

import com.aheavenx.spbg.model.BlogPost;
import com.aheavenx.spbg.service.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * @author Skovorodnikov
 *         Created on 6/1/2017 2:52 PM
 */
@ControllerAdvice
public class GlobalController {

    @Autowired private PostService postService;

    @ModelAttribute("trendingPosts")
    public List<BlogPost> populateTrendingBlogPosts() {
        return postService.findTopTrending(5);
    }

    @ModelAttribute("currentURIPrefix")
    public String getUrlPrefix() {
        return "http://localhost:8080";
    }
}
