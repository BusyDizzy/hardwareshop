package com.antontkach.hardwareshop.web;

import com.antontkach.hardwareshop.dto.ProductTo;
import com.antontkach.hardwareshop.model.Desktop;
import com.antontkach.hardwareshop.service.ProductService;
import com.antontkach.hardwareshop.web.convertor.ConvertorTo;
import com.antontkach.hardwareshop.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.antontkach.hardwareshop.ProductTestData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DesktopRestMethodsTest extends AbstractControllerTest {

    private static final String REST_URL = ProductController.REST_URL + "/";

    @Autowired
    private ProductService service;

    @Test
    void update() throws Exception {
        ProductTo updatedTo = getUpdatedDesktop();
        perform(MockMvcRequestBuilders.put(REST_URL + DESKTOP3_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updatedTo)))
                .andExpect(status().isNoContent());
        Desktop updated = (Desktop) ConvertorTo.convertProductToProduct(updatedTo);
        DESKTOP_MATCHER.assertMatch((Desktop) service.getById(DESKTOP3_ID), updated);
    }

    @Test
    void create() throws Exception {
        ProductTo newDesktopTo = getNewDesktop();
        ResultActions action = perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDesktopTo)))
                .andExpect(status().isCreated());

        Desktop created = DESKTOP_MATCHER.readFromJson(action);
        int newId = created.id();
        newDesktopTo.setId(newId);
        Desktop newDesktop = (Desktop) ConvertorTo.convertProductToProduct(newDesktopTo);
        DESKTOP_MATCHER.assertMatch(created, newDesktop);
        DESKTOP_MATCHER.assertMatch((Desktop) service.getById(newId), newDesktop);
    }

    @Test
    void createInvalidParams() throws Exception {
        ProductTo newDesktop = new ProductTo();
        perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDesktop)))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void createInvalidFormFactor() throws Exception {
        ProductTo newDesktop = getNewDesktop();
        newDesktop.setFormFactor("INVALID_FORMAT");
        perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDesktop)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void updateNotFound() throws Exception {
        ProductTo updated = getUpdatedDesktop();
        perform(MockMvcRequestBuilders.put(REST_URL + NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}
