package com.gemalto.model;

import com.gemalto.request.UserSessionRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.*;

/**
 * com.gemalto.model
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class CommentTest {
    //Field _id of type ObjectId - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    Date createDate;


    Post post;

    User user;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAllProp() {
        Comment comment = new Comment();
        user = new User();
        user.setActive(1);
        user.setEmail("");
        user.setLastName("");
        user.setName("");
        user.setPassword("");
        user.setRoleId(null);
        user.setUserId("");
        user.setUsername("");
        user.getActive();
        user.getEmail();
        user.getLastName();
        user.getName();
        user.getPassword();
        user.getRoleId();
        user.getUserId();
        user.getUsername();


        Role role= new Role();
        role.setId("");
        role.setRole("");
        role.setUserId(new ArrayList<>());

        role.getId();
        role.getRole();
        role.getUserId();

        comment.setBody("");
        comment.setCreateDate(new Date());
        comment.setId("123");
        comment.setUserId("1234");
        comment.setPostId("1234");


        comment.getBody();
        comment.getCreateDate();
        comment.getId();
        comment.getUserId();
        comment.getPostId();
        UserSessionRequest userSessionRequest = new UserSessionRequest();
        userSessionRequest.setClientId("");
        userSessionRequest.setClientSecret("");
        userSessionRequest.setUserId("");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme