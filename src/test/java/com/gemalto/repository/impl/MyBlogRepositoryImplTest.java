package com.gemalto.repository.impl;

import com.gemalto.model.Post;
import com.gemalto.response.PostResponse;
import com.gemalto.response.PostState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

/**
 * com.gemalto.repository.impl
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class MyBlogRepositoryImplTest {
    @Mock
    Logger logger;
    @Mock
    MongoTemplate mongoTemplate;
    @InjectMocks
    MyBlogRepositoryImpl myBlogRepositoryImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateNewPost() throws Exception {
        CompletableFuture<PostResponse> result = myBlogRepositoryImpl.createNewPost(new Post());
        Assert.assertNotNull( result.get());
    }
    @Test
    public void testGetSinglePost() throws Exception {
        CompletableFuture<List<Post>> result = myBlogRepositoryImpl.getPost("1234");
        Assert.assertNotNull( result.get());
    }

    @Test
    public void testGetAllPost() throws Exception {
        CompletableFuture<List<Post>> result = myBlogRepositoryImpl.getPost("ALL");
        Assert.assertNotNull( result.get());
    }

    @Test
    public void testUpdatePost() throws Exception {
        CompletableFuture<PostResponse> result = myBlogRepositoryImpl.updatePost(new Post());
        Assert.assertNotNull( result.get());
    }

    @Test
    public void testDelete() throws Exception {
        CompletableFuture<PostResponse> result = myBlogRepositoryImpl.delete("123");

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme