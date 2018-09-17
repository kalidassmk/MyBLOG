package com.gemalto.exception;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * com.gemalto.exception
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class AsyncExceptionTest {


    @Test
    public void test() {
        AsyncException exe1 = new AsyncException(null,null,true,true);
        AsyncException exe2 = new AsyncException("Test",null);
        AsyncException exe5 = new AsyncException("Test");
        AsyncException exe6 = new AsyncException(new Throwable());
        AsyncException exe = new AsyncException();
        exe.setStackTrace(new Exception("Exception").getStackTrace());
        exe.getMessage();
        exe.getCause();

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme