package com.gemalto.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kalidass Mahalingam on 10/12/2017.
 */
public class KeyGenerationTest {

    @Test
    public void testGetaccountNo() throws Exception {
        String result = KeyGeneration.getPostId();
        String result2 = KeyGeneration.getUserId();
        String result3 = KeyGeneration.getCommentId();
        Assert.assertNotNull(result3);
        Assert.assertNotNull(result2);
        Assert.assertNotNull(result);
    }
}

