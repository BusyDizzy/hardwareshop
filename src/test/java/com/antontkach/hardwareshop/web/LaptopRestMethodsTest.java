package com.antontkach.hardwareshop.web;

import com.antontkach.hardwareshop.dto.ProductTo;
import com.antontkach.hardwareshop.model.Laptop;
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

public class LaptopRestMethodsTest extends AbstractControllerTest {

    private static final String REST_URL = ProductController.REST_URL + "/";

    @Autowired
    private ProductService service;

    @Test
    void update() throws Exception {
        ProductTo updatedTo = getUpdatedLaptop();
        perform(MockMvcRequestBuilders.put(REST_URL + LAPTOP3_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updatedTo)))
                .andExpect(status().isNoContent());
        Laptop updated = (Laptop) ConvertorTo.convertProductToProduct(updatedTo);
        LAPTOP_MATCHER.assertMatch((Laptop) service.getById(LAPTOP3_ID), updated);
    }

    @Test
    void create() throws Exception {
        ProductTo newLaptopTo = getNewLaptop();
        ResultActions action = perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newLaptopTo)))
                .andExpect(status().isCreated());

        Laptop created = LAPTOP_MATCHER.readFromJson(action);
        int newId = created.id();
        newLaptopTo.setId(newId);
        Laptop newLaptop = (Laptop) ConvertorTo.convertProductToProduct(newLaptopTo);
        LAPTOP_MATCHER.assertMatch(created, newLaptop);
        LAPTOP_MATCHER.assertMatch((Laptop) service.getById(newId), newLaptop);
    }

    @Test
    void createInvalidParams() throws Exception {
        ProductTo newLaptop = new ProductTo();
        perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newLaptop)))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void createInvalidScreenSize() throws Exception {
        ProductTo newLaptop = getNewLaptop();
        newLaptop.setScreenSize(22);
        perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newLaptop)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void updateNotFound() throws Exception {
        ProductTo updated = getUpdatedLaptop();
        perform(MockMvcRequestBuilders.put(REST_URL + NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}