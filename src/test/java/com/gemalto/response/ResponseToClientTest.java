package com.gemalto.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.gemalto.model.Comment;
import com.gemalto.model.Post;
import com.gemalto.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.gemalto.response
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class ResponseToClientTest {

    @Test
    public void testObjectToClient() throws Exception {
        ErrorMessage errorMessage= new ErrorMessage("123","test","message");
        JsonNode result = ResponseToClient.objectToClient(errorMessage);
        Assert.assertNotNull( result);
    }

    @Test
    public void testListToClient() throws Exception {
        List<ErrorStatus>  status = new ArrayList<>();
        ErrorStatus errorStatus= new ErrorStatus(ErrorStatus.ErrorType.INTERNAL_ERROR);
        status.add(errorStatus);
        ErrorStatus errorStatus1= new ErrorStatus(ErrorStatus.ErrorType.INTERNAL_ERROR, new ArrayList<>());
        status.add(errorStatus1);
        ErrorStatus errorStatus2= new ErrorStatus(new ArrayList<>());
        status.add(errorStatus2);

        JsonNode result = ResponseToClient.listToClient(status);
        Assert.assertNotNull( result);
    }

    @Test
    public void testObjectToClient2() throws Exception {
        JsonNode result = ResponseToClient.objectToClient("obj", new Info(Info.InfoType.INFO_OK));
        Assert.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme