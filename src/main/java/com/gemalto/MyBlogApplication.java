package com.gemalto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Kalidass Mahalingam
 *  The type My blog application.
 */
@SpringBootApplication
@EnableAsync
public class MyBlogApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);
	}

}
