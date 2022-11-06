package com.udemy.jpa_study.inheritance.repository;

import com.udemy.jpa_study.inheritance.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public void insert(Employee employee){
        em.persist(employee);
    }

/*    public List<Employee> insertAllEmployees(){
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }*/

    public List<Employee> insertAllPartTimeEmployees(){
        return em.createQuery("select e from PartTimeEmployee e", Employee.class).getResultList();
    }

    public List<Employee> insertAllFullTimeEmployees(){
        return em.createQuery("select e from FullTimeEmployee e", Employee.class).getResultList();
    }
}
