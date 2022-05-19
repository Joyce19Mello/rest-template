package com.api.cats.rest.template.controller;

import com.api.cats.rest.template.dto.TheCatDTO;
import com.api.cats.rest.template.service.TheCatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("theCat")
public class TheCatController {

    @Autowired
    private TheCatService service;

    @GetMapping("/cats")
    public ResponseEntity<List<TheCatDTO>> getCatBreed() {
        log.info("Relizando a busca de todos os dados de gatinhos");
        return service.getCats().map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
