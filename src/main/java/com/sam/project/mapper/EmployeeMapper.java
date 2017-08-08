package com.sam.project.mapper;

import com.sam.project.pojo.EmployeePojo;
import com.sam.project.Entity.Employee;
import com.sam.project.pojo.EmployeeResponsePojo;


public final class EmployeeMapper {
    public static Employee mapUserRegisterPojoIntoEntity(EmployeePojo data) {
        Employee ue = new Employee();
        ue.setName(data.getName());
        ue.setEmail(data.getEmail());
        ue.setPhone(data.getPhone());
        return ue;
    }

    public static EmployeeResponsePojo mapEntityIntoPojo(Employee entity) {
        EmployeeResponsePojo pojo = new EmployeeResponsePojo(
                entity.getName(),
                entity.getEmail(),
                entity.getPhone()
        );
        return pojo;
    }
}
