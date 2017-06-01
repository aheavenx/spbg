package com.aheavenx.spbg.controller;

import com.aheavenx.spbg.model.BlogPost;
import com.aheavenx.spbg.service.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 2:33 PM
 */
@Controller
public class AllPostsController {

    private static final int POSTS_PER_PAGE = 5;
    @Autowired private PostService postService;

    @RequestMapping("posts/page/{pageNum}")
    public String view(@PathVariable("pageNum") Long pageNum, Model model) {

        List<BlogPost> allPosts = postService.findAll();

        if (pageNum < 1 || pageNum * POSTS_PER_PAGE - POSTS_PER_PAGE > allPosts.size())
            return "error/404";

        int lastIndex = pageNum.intValue() * POSTS_PER_PAGE > allPosts.size()
                ? allPosts.size()
                : pageNum.intValue() * POSTS_PER_PAGE;
        List<BlogPost> thisPagePosts = allPosts.subList(pageNum.intValue() * POSTS_PER_PAGE - POSTS_PER_PAGE, lastIndex);
        thisPagePosts.forEach(p -> p = postService.getContent(p));
        model.addAttribute("thisPagePosts", thisPagePosts);

        model.addAttribute("pageNum", pageNum);

        boolean isLastPage = pageNum.intValue() * POSTS_PER_PAGE > allPosts.size();
        model.addAttribute("isLastPage", isLastPage);

        return "posts/page";
    }
}
