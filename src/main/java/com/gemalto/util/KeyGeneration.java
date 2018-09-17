package com.gemalto.util;

import java.util.Random;

/**
 * The type Key generation.
 */
public class KeyGeneration {

    /**
     * Gets post id.
     *
     * @return the post id
     */
    public static synchronized String getPostId() {
        return  (""+getRand()).replace("-", "");
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public static synchronized String getUserId() {
        return  (""+getRand()).replace("-", "");
    }

    /**
     * Gets comment id.
     *
     * @return the comment id
     */
    public static synchronized String getCommentId() {
        return  (""+getRand()).replace("-", "");
    }


    private static long getRand() {
        Random rand = new Random();
        return rand.nextLong();
    }

}

