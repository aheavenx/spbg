package com.aheavenx.spbg.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Skovorodnikov
 *         Created on 5/31/2017 3:38 PM
 */
@Entity
public class Tags {
    private Integer id;
    private String tagName;
    private Collection<PostsTags> postsTagsById;

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
    @Column(name = "tag_name")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tags tags = (Tags) o;

        if (id != null ? !id.equals(tags.id) : tags.id != null) return false;
        if (tagName != null ? !tagName.equals(tags.tagName) : tags.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tagsByTagId")
    public Collection<PostsTags> getPostsTagsById() {
        return postsTagsById;
    }

    public void setPostsTagsById(Collection<PostsTags> postsTagsById) {
        this.postsTagsById = postsTagsById;
    }
}
