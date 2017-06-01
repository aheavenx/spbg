package com.aheavenx.spbg.dao;

import com.aheavenx.spbg.model.BlogPost;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 3:31 PM
 */
@Repository
public interface PostRepository extends CrudRepository<BlogPost, Integer> {
    @Query("SELECT p FROM BlogPost p ORDER BY p.tsPosted DESC")
    List<BlogPost> findLatestPosts(Pageable pageable);
    @Query("SELECT COUNT(p.id) FROM BlogPost p")
    Integer getTotalCount();
    @Query("SELECT p FROM BlogPost p JOIN FETCH p.postsTagsById WHERE p.id = ?1")
    BlogPost downloadContentToPost(Integer idVal);
    @Query("SELECT p FROM BlogPost p ORDER BY p.rating DESC")
    List<BlogPost> findTopTrending(Pageable pageable);
}
