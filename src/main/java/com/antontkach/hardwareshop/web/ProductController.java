package com.antontkach.hardwareshop.web;

import com.antontkach.hardwareshop.dto.ProductTo;
import com.antontkach.hardwareshop.model.Product;
import com.antontkach.hardwareshop.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.antontkach.hardwareshop.util.ValidationUtil.assureIdConsistent;
import static com.antontkach.hardwareshop.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = ProductController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Hardware Shop Controller")
public class ProductController {
    public static final String REST_URL = "/api/admin/hardwareshop";

    @Autowired
    private ProductService service;

    @GetMapping("/type/{type}")
    public List<Product> getAllByType(@PathVariable String type) {
        log.info("getAll by {}", type);
        return service.getAllByType(type);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        log.info("get {}", id);
        return service.getById(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> create(@Valid @RequestBody ProductTo productTo) {
        log.info("create {}", productTo);
        checkNew(productTo);
        Product created = service.save(productTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody ProductTo productTo, @PathVariable int id) {
        log.info("update {} with id={}", productTo, id);
        assureIdConsistent(productTo, id);
        service.update(id, productTo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete {}", id);
        service.delete(id);
    }
}