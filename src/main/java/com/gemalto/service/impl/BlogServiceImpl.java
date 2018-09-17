package com.gemalto.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.gemalto.model.Post;
import com.gemalto.response.PostResponse;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemalto.repository.MyBlogRepository;
import com.gemalto.service.BlogService;

/**
 * The type Account service.
 */
@Service("BlogService")
public class BlogServiceImpl implements BlogService {

	/**
	 * The Account repository.
	 */
	@Autowired
    MyBlogRepository myBlogRepository;

	/**
	 * Create new post completable future.
	 *
	 * @param post the post
	 * @return the completable future
	 */
	@Override
	public CompletableFuture<PostResponse> createNewPost(Post post) {
		return myBlogRepository.createNewPost(post);
	}

	/**
	 * Gets post.
	 *
	 * @param postId the post id
	 * @return the post
	 */
	public CompletableFuture<List<Post>> getPost(String postId) {
		return myBlogRepository.getPost(postId);
	}

	/**
	 * Delete completable future.
	 *
	 * @param postId the post id
	 * @return the completable future
	 */
	@Override
	public CompletableFuture<PostResponse> delete(String postId) {
		return myBlogRepository.delete(postId);
	}

	/**
	 * Update post completable future.
	 *
	 * @param post the post
	 * @return the completable future
	 */
	public CompletableFuture<PostResponse> updatePost(Post post) {
		return myBlogRepository.updatePost(post);
	}

}
