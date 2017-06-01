package com.aheavenx.spbg.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 3:38 PM
 */
@Entity
@Table(name = "posts_contents", schema = "spbg", catalog = "")
public class PostsContents {
    private Integer id;
    private String body;
    private String summary;
    private Collection<BlogPost> blogPostsById;

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
    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostsContents that = (PostsContents) o;

        return (id != null ? id.equals(that.id) : that.id == null) && (body != null ? body.equals(that.body) : that.body == null) && (summary != null ? summary.equals(that.summary) : that.summary == null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PostsContents{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "postsContentsByContent")
    public Collection<BlogPost> getBlogPostsById() {
        return blogPostsById;
    }

    public void setBlogPostsById(Collection<BlogPost> blogPostsById) {
        this.blogPostsById = blogPostsById;
    }
}
