package com.antontkach.hardwareshop.web;

import com.antontkach.hardwareshop.model.Product;
import com.antontkach.hardwareshop.service.ProductService;
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
public class ProductController {
    public static final String REST_URL = "/api/admin/hardwareshop";

    @Autowired
    private ProductService service;

    @GetMapping("/type/{type}")
    public List<Product> getProductsByType(@PathVariable String type) {
        log.info("getAll by {}", type);
        return service.getAllByType(type);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        log.info("get {}", id);
        return service.getById(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> add(@Valid @RequestBody Product product) {
        log.info("create {}", product);
        checkNew(product);
        Product created = service.save(product);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Product product, @PathVariable int id) {
        log.info("update {} with id={}", product, id);
        assureIdConsistent(product, id);
        service.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete {}", id);
        service.delete(id);
    }
}