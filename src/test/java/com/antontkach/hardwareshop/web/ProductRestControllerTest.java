package com.antontkach.hardwareshop.web;

import com.antontkach.hardwareshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.antontkach.hardwareshop.ProductTestData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = ProductController.REST_URL;

    @Autowired
    private ProductService service;

    @Test
    void getAllByDesktopType() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/type/Desktop"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DESKTOP_MATCHER.contentJson(desktop1, desktop2, desktop3));
    }
}