package com.antontkach.hardwareshop.web;

import com.antontkach.hardwareshop.dto.ProductTo;
import com.antontkach.hardwareshop.model.HardDrive;
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

public class HardDriveRestMethodsTest extends AbstractControllerTest {

    private static final String REST_URL = ProductController.REST_URL + "/";

    @Autowired
    private ProductService service;

    @Test
    void update() throws Exception {
        ProductTo updatedTo = getUpdatedHardDrive();
        perform(MockMvcRequestBuilders.put(REST_URL + HARD_DRIVE3_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updatedTo)))
                .andExpect(status().isNoContent());
        HardDrive updated = (HardDrive) ConvertorTo.convertProductToProduct(updatedTo);
        HARD_DRIVE_MATCHER.assertMatch((HardDrive) service.getById(HARD_DRIVE3_ID), updated);
    }

    @Test
    void create() throws Exception {
        ProductTo newHardDriveTo = getNewHardDrive();
        ResultActions action = perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newHardDriveTo)))
                .andExpect(status().isCreated());

        HardDrive created = HARD_DRIVE_MATCHER.readFromJson(action);
        int newId = created.id();
        newHardDriveTo.setId(newId);
        HardDrive newHardDrive = (HardDrive) ConvertorTo.convertProductToProduct(newHardDriveTo);
        HARD_DRIVE_MATCHER.assertMatch(created, newHardDrive);
        HARD_DRIVE_MATCHER.assertMatch((HardDrive) service.getById(newId), newHardDrive);
    }

    @Test
    void createInvalidParams() throws Exception {
        ProductTo newHardDrive = new ProductTo();
        perform(MockMvcRequestBuilders.post(ProductController.REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newHardDrive)))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void updateNotFound() throws Exception {
        ProductTo updated = getUpdatedHardDrive();
        perform(MockMvcRequestBuilders.put(REST_URL + NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}