package com.crud.crud.service;

import com.crud.crud.model.MyEntity;
import com.crud.crud.repo.MyRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements  ServiceI{
    private final MyRepoI myEntityRepository;


    @Autowired
    public ServiceImpl(MyRepoI myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    public List<MyEntity> showAll() {
        return myEntityRepository.findAll();
    }

    public Optional<MyEntity> one(Long id) {
        return myEntityRepository.findById(id);
    }

    public MyEntity add(MyEntity myEntity) {
        return myEntityRepository.save(myEntity);
    }

    public MyEntity delete(Long id) {
        Optional<MyEntity> one = one(id);
        if(one.isPresent()){
            myEntityRepository.deleteById(id);
            return one.get();
        }
        return new MyEntity();
    }

    public MyEntity update(MyEntity myEntity) {
        Optional<MyEntity> one = one(myEntity.getId());
        if(one.isPresent()){
            myEntityRepository.deleteById(myEntity.getId());
            return one.get();
        }
        return new MyEntity();
    }
}
