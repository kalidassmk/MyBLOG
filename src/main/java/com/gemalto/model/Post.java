package com.gemalto.model;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

/**
 * The type Post.
 */
@Document(collection = "post")
public class Post {

    @Id
    private ObjectId _id;

    private String postId;

    private String title;

    private String body;

    private Date createDate;

    private String status;

    private String userId;

    private Collection<Comment> commentId;

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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * Gets user id.
     *
     * @return the user id
     */
    @NotNull
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId( String userId) {
        this.userId = userId;
    }

    /**
     * Gets commentId.
     *
     * @return the commentId
     */
    public Collection<Comment> getCommentId() {
        return commentId;
    }

    /**
     * Sets commentId.
     *
     * @param commentId the commentId
     */
    public void setCommentId(Collection<Comment> commentId) {
        this.commentId = commentId;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
