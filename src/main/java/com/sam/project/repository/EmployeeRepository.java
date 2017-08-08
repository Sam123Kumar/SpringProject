package com.sam.project.repository;

import com.sam.project.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("SELECT ue from  Employee ue where ue.name = :name"
    )
    Employee findByName(@Param("name") String name);
}
