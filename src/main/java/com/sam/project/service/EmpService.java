package com.sam.project.service;


import com.sam.project.pojo.EmployeePojo;
import com.sam.project.Entity.Employee;
import com.sam.project.mapper.EmployeeMapper;
import com.sam.project.pojo.EmployeeResponsePojo;
import com.sam.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sameer on 19/12/16.
 */
@Service
public class EmpService {

    private final EmployeeRepository userDao;
    @Autowired
    public EmpService(EmployeeRepository userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public String createUser(EmployeePojo pojo) {
       Employee ue = userDao.findByName(pojo.getName());
        if (ue == null) {
            ue = userDao.save(EmployeeMapper.mapUserRegisterPojoIntoEntity(pojo));
        }
        return "user Inserted";
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponsePojo> listUsers() {
        List<EmployeeResponsePojo> userList = new ArrayList<>();
        for (Employee ue : userDao.findAll()) {
            userList.add(EmployeeMapper.mapEntityIntoPojo(ue));
        }
        return userList;
    }
}
