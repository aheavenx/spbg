package com.aheavenx.spbg.controller;

import com.aheavenx.spbg.model.BlogPost;
import com.aheavenx.spbg.service.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 2:08 PM
 */
@Controller
public class PostViewController {

    @Autowired private PostService postService;

    @RequestMapping("posts/viewpost/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Integer totalPosts = postService.totalPosts();
        BlogPost post = postService.findById(id);
        if (id < 0 || id > totalPosts || post == null)
            return "error/404";
        model.addAttribute("post", post);
        model.addAttribute("totalPosts", totalPosts);
        return "posts/viewpost";
    }
}
