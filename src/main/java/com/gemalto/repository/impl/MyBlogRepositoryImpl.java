package com.gemalto.repository.impl;

import com.gemalto.model.Post;
import com.gemalto.repository.MyBlogRepository;
import com.gemalto.response.PostResponse;
import com.gemalto.util.KeyGeneration;
import com.mongodb.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.gemalto.response.PostState.*;

/**
 * Created by Kalidass Mahalingam on 15/09/2018.
 */
@Repository("accountRepository")
public class MyBlogRepositoryImpl implements MyBlogRepository {

    private final Logger logger = LoggerFactory.getLogger(MyBlogRepositoryImpl.class);

    /**
     * The Mongo template.
     */
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * Create new post completable future.
     *
     * @param post the post
     * @return the completable future
     */
    @Override
    public CompletableFuture<PostResponse> createNewPost(Post post) {
        logger.info("Create a new Post start.....................");
        return CompletableFuture.supplyAsync(() -> {
            post.setPostId(KeyGeneration.getPostId());
            post.setCreateDate(new Date());
            mongoTemplate.insert(post);
            logger.info("New Post created post id {} .....................", post.getPostId());
            return new PostResponse(post.getPostId(), POST_CREATED);
        });
    }


    /**
     * Gets post.
     *
     * @param postId the post id
     * @return the post
     */
    @Override
    public CompletableFuture<List<Post>> getPost(String postId) {
        logger.info("get Post id {} ", postId);
        return CompletableFuture.supplyAsync(() -> {
            List<Post> postList;
            if ("ALL".equals(postId)) {
                Query query = new Query();
                Criteria criteria = Criteria.where("postId").in(postId);
                query.addCriteria(criteria);
                postList = mongoTemplate.find(query, Post.class);
            } else {
                postList = mongoTemplate.findAll(Post.class);
            }
            return postList;
        });
    }

    /**
     * Update post completable future.
     *
     * @param post the post
     * @return the completable future
     */
    @Override
    public CompletableFuture<PostResponse> updatePost(Post post) {
        logger.info("update Post start.....................");
        return CompletableFuture.supplyAsync(() -> {
            post.setPostId(KeyGeneration.getPostId());
            mongoTemplate.save(post);
            logger.info("updated Post id {} ", post.getPostId());
            return new PostResponse(post.getPostId(), POST_UPDATED);
        });
    }

    /**
     * Delete completable future.
     *
     * @param postId the post id
     * @return the completable future
     */

    @Override
    public CompletableFuture<PostResponse> delete(String postId) {
        logger.info("Delete Post start.....................");
        return CompletableFuture.supplyAsync(() -> {
            Query query = new Query();
            Criteria criteria = Criteria.where("postId").is(postId);

            query.addCriteria(criteria);

            Update update = new Update();
            update.set("status", "InActive");

            final WriteResult writeResult  = mongoTemplate.updateFirst(query,update, Post.class);

            if (writeResult.getN() <= 0) {
                throw new RuntimeException("Exception While delete the post");
            }
            logger.info("Deleted Post id {} ", postId);
            return new PostResponse(postId, POST_DELETED);

        });
    }
}
