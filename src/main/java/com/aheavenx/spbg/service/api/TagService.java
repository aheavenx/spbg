package com.aheavenx.spbg.service.api;

import com.aheavenx.spbg.model.PostsTags;

import java.util.List;

/**
 * @author Skovorodnikov
 *         Created on 6/1/2017 12:54 PM
 */
public interface TagService {
    List<PostsTags> findAll();
    List<PostsTags> findTop(Integer i);
    List<PostsTags> findLast(Integer i);
}
