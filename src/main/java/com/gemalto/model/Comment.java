package com.gemalto.model;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * The type Comment.
 */
@Document(collection = "comment")
public class Comment {

    @Id
    private ObjectId _id;

    private String id;

    @NotEmpty(message = "*Please write something")
    private String body;

    private Date createDate;

    private String postId;

    private String userId;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets create date.
     *
     * @return the create date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Sets create date.
     *
     * @param date the date
     */
    public void setCreateDate(Date date) {
        this.createDate = date;
    }

    /**
     * Gets post id.
     *
     * @return the post id
     */
    public String getPostId() {
        return postId;
    }

    /**
     * Sets post id.
     *
     * @param postId the post id
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}

