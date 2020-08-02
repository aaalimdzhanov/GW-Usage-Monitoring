package com.gwumonitor.demo.repository;

import com.gwumonitor.demo.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    @Override
    List<Resource> findAll();
    Optional<Resource> findById(Long id);
}
