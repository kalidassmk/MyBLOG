package com.gemalto.repository.impl;

import com.gemalto.model.Session;
import com.gemalto.request.UserSessionRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

/**
 * com.gemalto.repository.impl
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class TokenRepositoryImplTest {
    @Mock
    MongoTemplate mongoTemplate;
    @InjectMocks
    TokenRepositoryImpl tokenRepositoryImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerifyToken() throws Exception {
        CompletableFuture<Session> result = tokenRepositoryImpl.verifyToken("sessionId");
    }

    @Test
    public void testCreateUserSession() throws Exception {
        CompletableFuture<Session> result = tokenRepositoryImpl.createUserSession(new UserSessionRequest("userId", null, null));
        Assert.assertNotNull( result.get());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme