package com.gemalto.exception;

import com.gemalto.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

/**
 * com.gemalto.exception
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class GlobalExceptionHandlerTest {
    @Mock
    Logger logger;
    @InjectMocks
    GlobalExceptionHandler globalExceptionHandler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHandleException() throws Exception {
        Response<Object> result = globalExceptionHandler.handleException(new RuntimeException("Exception"));
        Assert.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme