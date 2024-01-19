package com.crud.crud.service;

import com.crud.crud.model.MyEntity;

import java.util.List;
import java.util.Optional;

public interface ServiceI {
    public MyEntity add(MyEntity myEntity);
    public List<MyEntity> showAll();
    public MyEntity delete(Long id) ;
    public MyEntity update(MyEntity myEntity);
    public Optional<MyEntity> one (Long id);
}
