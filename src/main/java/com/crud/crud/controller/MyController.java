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
        MyEntity addedEntity = service.getById(id).get();
        return ResponseEntity.ok(addedEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,HttpStatus>> delete(@PathVariable Long id) {
        Optional<MyEntity> optionalEntity = service.getById(id);
        Map<String,HttpStatus> map = new HashMap<>();
        if (optionalEntity.isPresent()) {
            map.put(id+" Deleted...",HttpStatus.OK);
            service.delete(id);
            return ResponseEntity.ok(map);
        } else {
            map.put(id+" Not Found...",HttpStatus.NOT_FOUND);

            return ResponseEntity.ok(map);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<MyEntity>> show() {
        List<MyEntity> entities = service.showAll();
        return ResponseEntity.ok(entities);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MyEntity> update(@RequestBody MyEntity myEntity, @PathVariable Long id) {
        Optional<MyEntity> optionalEntity = service.getById(id);

        if (optionalEntity.isPresent()) {
            myEntity.setId(id);
            service.update(myEntity);
            return ResponseEntity.ok(optionalEntity.get());
        }
        return null;
    }
}
