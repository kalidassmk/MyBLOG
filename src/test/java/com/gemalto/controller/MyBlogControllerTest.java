package com.gemalto.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gemalto.model.Post;
import com.gemalto.model.Session;
import com.gemalto.request.UserSessionRequest;
import com.gemalto.response.PostResponse;
import com.gemalto.response.PostState;
import com.gemalto.service.BlogService;
import com.gemalto.session.SessionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static org.mockito.Mockito.*;

/**
 * com.gemalto.controller
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class MyBlogControllerTest {
    @Mock
    BlogService blogService;
    @Mock
    SessionService sessionService;
    @Mock
    Logger logger;
    @Mock
    HttpHeaders header;

    @InjectMocks
    MyBlogController myBlogController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Session session = new Session();
        CompletableFuture<Session> sessionFuture = supplyAsync(() -> session);
        PowerMockito.when(sessionService.getSession(Mockito.any(HttpHeaders.class))).thenReturn(sessionFuture);
    }

    @Test
    public void testCreateUserSession() throws Exception {
        when(sessionService.createUserSession(any())).thenReturn(CompletableFuture.completedFuture(new Session()));
        UserSessionRequest userSessionRequest = new UserSessionRequest("userId", "clientId", "clientSecret");
        CompletableFuture<JsonNode> result = myBlogController.createUserSession(userSessionRequest);
        Assert.assertNotNull(result.get());
        Assert.assertNotNull(userSessionRequest.getUserId());
        Assert.assertNotNull(userSessionRequest.getClientId());
        Assert.assertNotNull(userSessionRequest.getClientSecret());
        Assert.assertNotNull(userSessionRequest.toString());
    }

    @Test
    public void testCreateNewPost() throws Exception {
        when(blogService.createNewPost(any())).thenReturn(CompletableFuture.completedFuture(new PostResponse("postId", PostState.POST_UPDATED)));
        when(sessionService.getSession(any())).thenReturn(CompletableFuture.completedFuture(new Session()));
        CompletableFuture<JsonNode> result = myBlogController.createNewPost(new Post(), header);
        Assert.assertNotNull(result.get());
    }

    @Test
    public void testGetPost() throws Exception {
        when(blogService.getPost(anyString())).thenReturn(CompletableFuture.completedFuture(Arrays.<Post>asList(new Post())));
        when(sessionService.getSession(any())).thenReturn(CompletableFuture.completedFuture(new Session()));

        CompletableFuture<JsonNode> result = myBlogController.getPost("postId", header);
        Assert.assertNotNull(result.get());
    }

    @Test
    public void testUpdatePost() throws Exception {
        when(blogService.updatePost(any())).thenReturn(CompletableFuture.completedFuture(new PostResponse("postId", PostState.POST_UPDATED)));
        when(sessionService.getSession(any())).thenReturn(CompletableFuture.completedFuture(new Session()));

        CompletableFuture<JsonNode> result = myBlogController.updatePost(new Post(), header);
        Assert.assertNotNull(result.get());
    }

    @Test
    public void testDelete() throws Exception {
        when(blogService.delete(anyString())).thenReturn(CompletableFuture.completedFuture(new PostResponse("postId", PostState.POST_UPDATED)));
        when(sessionService.getSession(any())).thenReturn(CompletableFuture.completedFuture(new Session()));

        CompletableFuture<JsonNode> result = myBlogController.delete("postId", header);
        Assert.assertNotNull(result.get());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme