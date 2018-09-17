package com.gemalto.service.impl;

import com.gemalto.model.Post;
import com.gemalto.model.User;
import com.gemalto.repository.MyBlogRepository;
import com.gemalto.response.PostResponse;
import com.gemalto.response.PostState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

/**
 * com.gemalto.service.impl
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class BlogServiceImplTest {
    @Mock
    MyBlogRepository myBlogRepository;
    @InjectMocks
    BlogServiceImpl blogServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateNewPost() throws Exception {
        when(myBlogRepository.createNewPost(any())).thenReturn(CompletableFuture.completedFuture(new PostResponse("123", PostState.POST_CREATED)));
        Post post = new Post();
        post.setPostId("123");
        post.setCreateDate(new Date());
        post.setBody("Java 8 ");
        post.setComments(new ArrayList<>());
        post.setTitle("Java 8");
        post.setUser(new User());
        post.setStatus("Active");

        CompletableFuture<PostResponse> result = blogServiceImpl.createNewPost(post);
        Assert.assertEquals(PostState.POST_CREATED, result.get().getStatus());
        Assert.assertEquals(post.getPostId(), result.get().getPostId());

    }

    @Test
    public void testGetPost() throws Exception {
        when(myBlogRepository.getPost(anyString())).thenReturn(CompletableFuture.completedFuture(Arrays.<Post>asList(new Post())));

        CompletableFuture<List<Post>> result = blogServiceImpl.getPost("123");
        Assert.assertNotNull(result.get());
    }

    @Test
    public void testDelete() throws Exception {
        when(myBlogRepository.delete(anyString())).thenReturn(CompletableFuture.completedFuture(new PostResponse("123", PostState.POST_DELETED)));
        CompletableFuture<PostResponse> result = blogServiceImpl.delete("123");
        Assert.assertEquals(PostState.POST_DELETED, result.get().getStatus());
        Assert.assertEquals("123", result.get().getPostId());    }

    @Test
    public void testUpdatePost() throws Exception {
        when(myBlogRepository.updatePost(any())).thenReturn(CompletableFuture.completedFuture(new PostResponse("123", PostState.POST_UPDATED)));
        Post post = new Post();
        post.setPostId("123");
        CompletableFuture<PostResponse> result = blogServiceImpl.updatePost(post);
        Assert.assertEquals(PostState.POST_UPDATED, result.get().getStatus());
        Assert.assertEquals(post.getPostId(), result.get().getPostId());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme