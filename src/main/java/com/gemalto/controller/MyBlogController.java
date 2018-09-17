package com.gemalto.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.gemalto.model.Post;
import com.gemalto.request.UserSessionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @Async
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
    @Async
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
    @Async
    @RequestMapping(value = "/getPost", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> getPost(@RequestBody String postId, @RequestHeader HttpHeaders headers) {
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
    @Async
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
    @Async
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> delete(@RequestBody String postId, @RequestHeader HttpHeaders headers) {
		logger.info("get te the account Detail" + headers.get(AUTH_HEADER_NAME));
		return  sessionService.getSession(headers).thenCompose(session -> {
			return blogService.delete(postId).thenApply(resp -> ResponseToClient.objectToClient(resp));
		});
	}


}
