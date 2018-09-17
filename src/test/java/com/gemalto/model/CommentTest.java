package com.gemalto.model;

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
        user.setRoles(null);
        user.setUserId("");
        user.setUsername("");
        user.setPosts(null);
        user.getActive();
        user.getEmail();
        user.getLastName();
        user.getName();
        user.getPassword();
        user.getPosts();
        user.getRoles();
        user.getUserId();
        user.getUsername();


        Role role= new Role();
        role.setId("");
        role.setRole("");
        role.setUsers(new ArrayList<>());

        role.getId();
        role.getRole();
        role.getUsers();

        comment.setBody("");
        comment.setCreateDate(new Date());
        comment.setId("123");
        comment.setPost(new Post());
        comment.setUser(user);

        comment.getBody();
        comment.getCreateDate();
        comment.getId();
        comment.getPost();
        comment.getUser();

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme