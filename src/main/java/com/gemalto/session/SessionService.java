package com.gemalto.session;

import java.util.concurrent.CompletableFuture;

import com.gemalto.request.UserSessionRequest;
import org.springframework.http.HttpHeaders;

import com.gemalto.model.Session;

/**
 * The interface Session service.
 */
public interface SessionService {
    /**
     * Gets session.
     *
     * @param headers the headers
     *
     * @return the session
     */
    public CompletableFuture<Session> getSession(HttpHeaders headers);
    public CompletableFuture<Session> createUserSession(UserSessionRequest userSessionRequest);

}
