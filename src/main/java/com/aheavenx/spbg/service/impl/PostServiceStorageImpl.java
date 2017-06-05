package com.aheavenx.spbg.service.impl;

import com.aheavenx.spbg.dao.PostRepository;
import com.aheavenx.spbg.model.BlogPost;
import com.aheavenx.spbg.service.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 3:29 PM
 */
@Service
@Primary
public class PostServiceStorageImpl implements PostService {

    @Autowired private PostRepository postRepository;

    @Override
    public List<BlogPost> findAll() {
        return postRepository.findLatestPosts(new PageRequest(0, Integer.MAX_VALUE));
    }

    @Override
    public BlogPost findLatest() {
        return postRepository.findLatestPosts(new PageRequest(0, 1)).get(0);
    }

    @Override
    public Integer totalPosts() {
        return postRepository.getTotalCount();
    }

    @Override
    public BlogPost getContent(BlogPost post) {
        return postRepository.downloadContentToPost(post.getId());
    }

    @Override
    public List<BlogPost> findTopTrending(Integer i) {
        return postRepository.findTopTrending(new PageRequest(0, i));
    }

    @Override
    public BlogPost findById(Integer id) {
        return postRepository.findOne(id);
    }
}
