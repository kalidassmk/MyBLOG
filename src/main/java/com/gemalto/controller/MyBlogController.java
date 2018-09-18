package com.gemalto.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import com.gemalto.model.Comment;
import com.gemalto.model.Post;
import com.gemalto.model.Role;
import com.gemalto.model.User;
import com.gemalto.request.UserSessionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import com.gemalto.response.ResponseToClient;
import com.gemalto.service.BlogService;
import com.gemalto.session.SessionService;
import com.fasterxml.jackson.databind.JsonNode;

import static com.gemalto.session.impl.SessionServiceImpl.AUTH_HEADER_NAME;

/**
 * The type My blog controller.
 */
@RestController
public class MyBlogController {

    /**
     * The Blog service.
     */
    @Autowired
	BlogService blogService;

	@Autowired
	private SessionService sessionService;
	
	private final Logger logger = LoggerFactory.getLogger(MyBlogController.class);

    /**
     * Create user session completable future.
     *
     * @param userSessionRequest the user session request
     * @return the completable future
     */
	@RequestMapping(value = "/createUserSession", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> createUserSession(@RequestBody UserSessionRequest userSessionRequest) {
		return sessionService.createUserSession(userSessionRequest).thenApply(session
				-> ResponseToClient.objectToClient(session));
	}


    /**
     * Create new post completable future.
     *
     * @param post    the post
     * @param headers the headers
     * @return the completable future
     */
    @RequestMapping(value = "/createNewPost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<JsonNode> createNewPost(@RequestBody Post post, @RequestHeader HttpHeaders headers) {
        logger.info("open the account" + headers.get(AUTH_HEADER_NAME));
        return  sessionService.getSession(headers).thenCompose(session -> {
            return blogService.createNewPost(post).thenApply(resp -> ResponseToClient.objectToClient(resp));
        });
    }


    /**
     * Gets post.
     *
     * @param postId  the post id
     * @param headers the headers
     * @return the post
     */
    @RequestMapping(value = "/getPost", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> getPost(@RequestParam( value = "postId") String postId, @RequestHeader HttpHeaders headers) {
		logger.info("open the account" + headers.get(AUTH_HEADER_NAME));
		return  sessionService.getSession(headers).thenCompose(session -> {
			return blogService.getPost(postId).thenApply(resp -> ResponseToClient.objectToClient(resp));
		});
	}

    /**
     * Update post completable future.
     *
     * @param post    the post
     * @param headers the headers
     * @return the completable future
     */
    @RequestMapping(value = "/updatePost", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> updatePost(@RequestBody Post post, @RequestHeader HttpHeaders headers) {
		logger.info("transfer the amount" + headers.get(AUTH_HEADER_NAME));
		return  sessionService.getSession(headers).thenCompose(session -> {
			return blogService.updatePost(post).thenApply(resp -> ResponseToClient.objectToClient(resp));
		});
	}


    /**
     * Delete completable future.
     *
     * @param postId  the post id
     * @param headers the headers
     * @return the completable future
     */
	@RequestMapping(value = "/deletePost", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> delete(@RequestParam( value = "postId") String postId, @RequestHeader HttpHeaders headers) {
		logger.info("get te the account Detail" + headers.get(AUTH_HEADER_NAME));
		return  sessionService.getSession(headers).thenCompose(session -> {
			return blogService.delete(postId).thenApply(resp -> ResponseToClient.objectToClient(resp));
		});
	}
}
