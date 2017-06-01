package com.aheavenx.spbg.service.api;

import com.aheavenx.spbg.model.BlogPost;

import java.util.List;

/**
 * @author Skovorodnikov
 *         Created on 31.05.2017 11:11
 */
public interface PostService {
    List<BlogPost> findAll();
    BlogPost findLatest();
    Integer totalPosts();
    BlogPost getContent(BlogPost post);
    List<BlogPost> findTopTrending(Integer i);
    BlogPost findById(Integer id);
    BlogPost create(Integer post);
    BlogPost edit(Integer post);
    void deleteById(Long id);
}
