package com.crud.crud.service;

import com.crud.crud.model.MyEntity;
import com.crud.crud.repo.MyRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements ServiceI{
    @Autowired
    MyRepoI repo;
    @Override
    public void add(MyEntity myEntity) {
        repo.save(myEntity);
    }

    @Override
    public List<MyEntity> showAll() {
        return repo.findAll();
    }

    @Override
    public void deletr(Long id) {
        repo.deleteById(id);
    }

    @Override
    public String update(MyEntity myEntity,Long id) {
        Optional<MyEntity> opt =repo.findById(id);
        if (opt.isPresent()){
            repo.save(myEntity);
            System.out.println(opt.get());
            return "Updated..";
        }else {
            return "Not Found...";
        }
    }
}
