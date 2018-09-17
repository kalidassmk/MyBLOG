package com.gemalto.response;

/**
 * The type Post response.
 */
public class PostResponse {

    private String postId;

    private PostState status;

    /**
     * Instantiates a new Post response.
     */
    public PostResponse() {
    }

    /**
     * Instantiates a new Post response.
     *
     * @param postId the post id
     * @param status the status
     */
    public PostResponse(String postId, PostState status) {
        this.postId = postId;
        this.status = status;
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
     * Gets status.
     *
     * @return the status
     */
    public PostState getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(PostState status) {
        this.status = status;
    }
}
