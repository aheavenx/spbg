package com.aheavenx.spbg.model;

import javax.persistence.*;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 3:38 PM
 */
@Entity
@Table(name = "posts_tags", schema = "spbg", catalog = "")
public class PostsTags {
    private Integer id;
    private BlogPost blogPostByPostId;
    private Tags tagsByTagId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostsTags postsTags = (PostsTags) o;

        if (id != null ? !id.equals(postsTags.id) : postsTags.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    public BlogPost getBlogPostByPostId() {
        return blogPostByPostId;
    }

    public void setBlogPostByPostId(BlogPost blogPostByPostId) {
        this.blogPostByPostId = blogPostByPostId;
    }

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    public Tags getTagsByTagId() {
        return tagsByTagId;
    }

    public void setTagsByTagId(Tags tagsByTagId) {
        this.tagsByTagId = tagsByTagId;
    }
}
