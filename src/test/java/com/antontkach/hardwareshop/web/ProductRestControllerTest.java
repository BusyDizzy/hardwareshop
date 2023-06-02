package com.antontkach.hardwareshop.web;

import com.antontkach.hardwareshop.error.NotFoundException;
import com.antontkach.hardwareshop.model.Desktop;
import com.antontkach.hardwareshop.service.ProductService;
import com.antontkach.hardwareshop.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.antontkach.hardwareshop.ProductTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = ProductController.REST_URL + "/";

    @Autowired
    private ProductService service;

    @Test
    void getAllByDesktopType() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "type/Desktop"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DESKTOP_MATCHER.contentJson(desktop1, desktop2, desktop3));
    }

    @Test
    void getAllByLaptopType() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "type/Laptop"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(LAPTOP_MATCHER.contentJson(laptop1, laptop2, laptop3));
    }

    @Test
    void getById() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + DESKTOP2_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DESKTOP_MATCHER.contentJson(desktop2));
    }

    @Test
    void deleteById() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + LAPTOP1_ID))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> service.getById(LAPTOP1_ID));
    }

    @Test
    void deleteNotFound() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + NOT_FOUND))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void updateDesktop() throws Exception {
        Desktop updated = getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL + DESKTOP3_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        DESKTOP_MATCHER.assertMatch((Desktop) service.getById(DESKTOP3_ID), updated);
    }

    @Test
    void updateNotFound() throws Exception {
        Desktop updated = getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL + NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void createDesktop() throws Exception {
        Desktop newDesktop = getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDesktop)))
                .andExpect(status().isCreated());

        Desktop created = DESKTOP_MATCHER.readFromJson(action);
        int newId = created.id();
        newDesktop.setId(newId);
        DESKTOP_MATCHER.assertMatch(created, newDesktop);
        DESKTOP_MATCHER.assertMatch((Desktop) service.getById(newId), newDesktop);
    }

    @Test
    void createDuplicateDesktop() throws Exception {
        Desktop newDesktop = getNew();
        newDesktop.setManufacturer("KINGDEL");
        newDesktop.setSerialNumber("D002");
        perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDesktop)))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    void createInvalidDesktop() throws Exception {
        Desktop newDesktop = new Desktop(null, null, null, null, 1, null, null);
        perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDesktop)))
                .andExpect(status().isUnprocessableEntity());
    }
}