package com.crud.crud.repo;

import com.crud.crud.model.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepoI extends JpaRepository<MyEntity,Long> {
}
