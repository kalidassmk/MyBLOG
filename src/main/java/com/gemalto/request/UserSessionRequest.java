package com.gemalto.request;

import javax.validation.constraints.NotNull;

/**
 * Created by Kalidass Mahalingam on 10/12/2017.
 */
public class UserSessionRequest {

    @NotNull
    private String userId;

    @NotNull
    private String clientId;

    @NotNull
    private String clientSecret;

    public UserSessionRequest() {
    }

    public UserSessionRequest(String userId, String clientId, String clientSecret) {
        this.userId = userId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
