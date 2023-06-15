package com.crud.crud.service;

import com.crud.crud.model.MyEntity;
import com.crud.crud.repo.MyRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl {
    private final MyRepoI myEntityRepository;


    @Autowired
    public ServiceImpl(MyRepoI myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    public List<MyEntity> showAll() {
        return myEntityRepository.findAll();
    }

    public Optional<MyEntity> getById(Long id) {
        return myEntityRepository.findById(id);
    }

    public MyEntity add(MyEntity myEntity) {
        return myEntityRepository.save(myEntity);
    }

    public void delete(Long id) {
        myEntityRepository.deleteById(id);
    }

    public void update(MyEntity myEntity) {
        myEntityRepository.save(myEntity);
    }
}
