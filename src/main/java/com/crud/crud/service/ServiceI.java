package com.crud.crud.service;

import com.crud.crud.model.MyEntity;

import java.util.List;

public interface ServiceI {
    public void add(MyEntity myEntity);
    public List<MyEntity> showAll();
    public boolean delete(Long id) ;
    public String update(MyEntity myEntity,Long id);
    public MyEntity one (Long id);
}
