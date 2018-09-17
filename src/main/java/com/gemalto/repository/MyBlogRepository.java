package com.gemalto.repository;

import com.gemalto.model.Post;
import com.gemalto.response.PostResponse;
import org.bson.Document;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The interface Account repository.
 */
public interface MyBlogRepository {

    /**
     * Create new post completable future.
     *
     * @param post the post
     * @return the completable future
     */
    CompletableFuture<PostResponse> createNewPost(Post post);

    /**
     * Gets post.
     *
     * @param postId the post id
     * @return the post
     */
    CompletableFuture<List<Post>> getPost(String postId);

    /**
     * Delete completable future.
     *
     * @param postId the post id
     * @return the completable future
     */
    CompletableFuture<PostResponse> delete(String  postId);

    /**
     * Update post completable future.
     *
     * @param post the post
     * @return the completable future
     */
    CompletableFuture<PostResponse> updatePost(Post post);

}
