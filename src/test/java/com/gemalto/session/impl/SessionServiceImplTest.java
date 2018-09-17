package com.gemalto.session.impl;

import com.gemalto.model.Session;
import com.gemalto.repository.TokenRepository;
import com.gemalto.request.UserSessionRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.http.HttpHeaders;

import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static org.mockito.Mockito.*;

/**
 * com.gemalto.session.impl
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class SessionServiceImplTest {
    @Mock
    TokenRepository tokenRepository;
    @InjectMocks
    SessionServiceImpl sessionServiceImpl;

    @Mock
    HttpHeaders header;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(header.getFirst(anyString())).thenReturn("12345");
    }

    @Test
    public void testGetSession() throws Exception {
        Session session = new Session();
        session.setTimezone(TimeZone.getDefault());
        when(tokenRepository.verifyToken(anyString())).thenReturn(CompletableFuture.completedFuture(session));
        CompletableFuture<Session> result = sessionServiceImpl.getSession(header);
    }

    @Test
    public void testCreateUserSession() throws Exception {
        when(tokenRepository.createUserSession(any())).thenReturn(CompletableFuture.completedFuture(new Session()));
        CompletableFuture<Session> result = sessionServiceImpl.createUserSession(new UserSessionRequest("userId", "clientId", "clientSecret"));
        Assert.assertNotNull(result.get());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme