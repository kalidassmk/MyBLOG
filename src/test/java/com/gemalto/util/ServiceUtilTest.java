package com.gemalto.util;

import com.gemalto.response.PostResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.gemalto.response.PostState.POST_CREATED;

/**
 * Created by Kalidass Mahalingam on 10/12/2017.
 */
public class ServiceUtilTest {

    @Mock
    ObjectMapper defaultObjectMapper;
    @Mock
    ObjectMapper objectMapper;
    @InjectMocks
    ServiceUtil serviceUtil;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNewDefaultMapper() throws Exception {
        ObjectMapper result = ServiceUtil.newDefaultMapper();
        Assert.assertNotNull(result);
    }

    @Test
    public void testMapper() throws Exception {
        ObjectMapper result = ServiceUtil.mapper();
        Assert.assertNotNull(result);
    }

    @Test
    public void testToJson() throws Exception {
        JsonNode result = ServiceUtil.toJson(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testNewObject() throws Exception {
        ObjectNode result = ServiceUtil.newObject();
        Assert.assertNotNull(result);
    }

    @Test
    public void testNewArray() throws Exception {
        ArrayNode result = ServiceUtil.newArray();
        Assert.assertEquals(new ArrayNode(new JsonNodeFactory(true), 0), result);
    }

    @Test
    public void testStringify() throws Exception {
        PostResponse resp = new PostResponse() {{
            setPostId("1");
            setStatus(POST_CREATED);
        }};
        JsonNode node= ServiceUtil.toJson(resp);
        String result = ServiceUtil.stringify(node);
        Assert.assertNotNull(result);
    }

    @Test
    public void testAsciiStringify() throws Exception {
        PostResponse resp = new PostResponse() {{
            setPostId("1");
            setStatus(POST_CREATED);
        }};
        JsonNode node= ServiceUtil.toJson(resp);
        String result = ServiceUtil.asciiStringify(node);
        Assert.assertNotNull(result);
    }

    @Test
    public void testPrettyPrint() throws Exception {
        PostResponse resp = new PostResponse() {{
            setPostId("1");
            setStatus(POST_CREATED);
        }};
       JsonNode node= ServiceUtil.toJson(resp);

        String result = ServiceUtil.prettyPrint(ServiceUtil.toJson(resp));
        Assert.assertNotNull(result);
    }

    @Test
    public void testParse() throws Exception {
        PostResponse resp = new PostResponse() {{
            setPostId("1");
            setStatus(POST_CREATED);
        }};
        JsonNode result = ServiceUtil.parse(ServiceUtil.toJson(resp).toString());
        Assert.assertNotNull(result);
    }



    @Test
    public void testParse3() throws Exception {
        PostResponse resp = new PostResponse() {{
            setPostId("1");
            setStatus(POST_CREATED);
        }};
        JsonNode result = ServiceUtil.parse(ServiceUtil.toJson(resp).toString().getBytes());
        Assert.assertNotNull(result);
    }
}

