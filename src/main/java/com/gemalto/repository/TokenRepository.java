package com.gemalto.repository;

import com.gemalto.model.Session;
import com.gemalto.request.UserSessionRequest;

import java.util.concurrent.CompletableFuture;

/**
 * The interface Token service.
 */
public interface TokenRepository {
    /**
     * Verify token session.
     *
     * @param sessionId the session id
     *
     * @return the session
     */
    CompletableFuture<Session> verifyToken(String sessionId);

    CompletableFuture<Session> createUserSession(UserSessionRequest userSessionRequest);

}
