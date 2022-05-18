package com.practice.mvc.repository;

import com.practice.mvc.entity.EmployeeEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    Slice<EmployeeEntity> findAllByName(String ravi, Pageable nextPageable);
}
