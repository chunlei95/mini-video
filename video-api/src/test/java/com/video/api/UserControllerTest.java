package com.video.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author xzmeasy
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VideoApiApplication.class)
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mock = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void register() throws Exception {
        //language=JSON
        String user = "{\n" +
                "  \"username\": \"zaz\",\n" +
                "  \"password\": \"aaa\",\n" +
                "  \"icon\": \"ddd\",\n" +
                "  \"nickname\": \"www\"\n" +
                "}";
        mock.perform(
                post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(user)
        ).andDo(print());
    }

}
