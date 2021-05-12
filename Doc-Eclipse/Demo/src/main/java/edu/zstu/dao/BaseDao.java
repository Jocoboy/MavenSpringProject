package edu.zstu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BaseDao<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
