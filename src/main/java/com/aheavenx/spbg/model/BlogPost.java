package com.aheavenx.spbg.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 3:38 PM
 */
@Entity
@Table(name = "blog_post", schema = "spbg")
public class BlogPost {
    private Integer id;
    private String title;
    private Timestamp tsPosted;
    private Integer rating;
    private Byte isFeatured;
    private String uId;
    private Collection<PostsTags> postsTagsById;
    private PostsContents postsContentsByContent;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "ts_posted")
    public Timestamp getTsPosted() {
        return tsPosted;
    }

    public void setTsPosted(Timestamp tsPosted) {
        this.tsPosted = tsPosted;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "is_featured")
    public Byte getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Byte isFeatured) {
        this.isFeatured = isFeatured;
    }

    @Basic
    @Column(name = "u_id")
    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogPost blogPost = (BlogPost) o;

        if (id != null ? !id.equals(blogPost.id) : blogPost.id != null) return false;
        if (title != null ? !title.equals(blogPost.title) : blogPost.title != null) return false;
        if (tsPosted != null ? !tsPosted.equals(blogPost.tsPosted) : blogPost.tsPosted != null) return false;
        if (rating != null ? !rating.equals(blogPost.rating) : blogPost.rating != null) return false;
        if (isFeatured != null ? !isFeatured.equals(blogPost.isFeatured) : blogPost.isFeatured != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (tsPosted != null ? tsPosted.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (isFeatured != null ? isFeatured.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "blogPostByPostId")
    public Collection<PostsTags> getPostsTagsById() {
        return postsTagsById;
    }

    public void setPostsTagsById(Collection<PostsTags> postsTagsById) {
        this.postsTagsById = postsTagsById;
    }

    @ManyToOne
    @JoinColumn(name = "content", referencedColumnName = "id")
    public PostsContents getPostsContentsByContent() {
        return postsContentsByContent;
    }

    public void setPostsContentsByContent(PostsContents postsContentsByContent) {
        this.postsContentsByContent = postsContentsByContent;
    }
}
