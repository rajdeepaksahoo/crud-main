package com.crud.crud.controller;

import com.crud.crud.model.MyEntity;
import com.crud.crud.service.ServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {
    private final ServiceImpl service;

    @Autowired
    public MyController(ServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<MyEntity> add(@RequestBody MyEntity myEntity) {
        MyEntity addedEntity = service.add(myEntity);
        return ResponseEntity.ok(addedEntity);
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<MyEntity> one(@PathVariable Long id) {
        MyEntity addedEntity = service.one(id).get();
        return ResponseEntity.ok(addedEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MyEntity> delete(@PathVariable Long id) {
        Optional<MyEntity> optionalEntity = service.one(id);
        if (optionalEntity.isPresent()) {
            return new ResponseEntity<>(service.delete(id),HttpStatus.ACCEPTED);
        }
            return new ResponseEntity<>(new MyEntity(),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MyEntity>> show() {
        List<MyEntity> entities = service.showAll();
        return ResponseEntity.ok(entities);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MyEntity> update(@RequestBody MyEntity myEntity, @PathVariable Long id) {
       return new ResponseEntity<>(service.update(myEntity),HttpStatus.CREATED);
    }
}
