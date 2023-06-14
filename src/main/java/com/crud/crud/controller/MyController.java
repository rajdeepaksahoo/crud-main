package com.crud.crud.controller;

import com.crud.crud.model.MyEntity;
import com.crud.crud.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class MyController {
    @Autowired
    ServiceImpl service;
    @PostMapping("/add")
    public ResponseEntity<MyEntity> add(@RequestBody MyEntity myEntity){
        service.add(myEntity);
        return ResponseEntity.ok(myEntity);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deletr(id);
        return ResponseEntity.ok(id.toString()+" Deleted");
    }
    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<List<MyEntity>> show(){
        return ResponseEntity.ok(service.showAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody MyEntity myEntity,@PathVariable Long id){
        service.update(myEntity,id);
        return ResponseEntity.ok(id.toString()+" Updated..");
    }
    @PutMapping("/one/{id}")
    public ResponseEntity<MyEntity> one(@PathVariable Long id){
        return ResponseEntity.ok(service.one(id));
    }
}
