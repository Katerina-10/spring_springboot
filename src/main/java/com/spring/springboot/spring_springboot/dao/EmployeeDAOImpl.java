package com.spring.springboot.spring_springboot.dao;

import com.spring.springboot.spring_springboot.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    //@Transactional //когда есть сервис - указывается в сервисе
    public List<Employee> getAllEmployees() {
//        //Session session = sessionFactory.getCurrentSession();
//        Session session = entityManager.unwrap(Session.class);
//        //List<Employee> allEmps = session.createQuery("from Employee", Employee.class).getResultList();
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmps = query.getResultList();

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmps = query.getResultList();

        return allEmps;
    }

    @Override
    public void saveEmpl(Employee employee) {
//        //Session session = sessionFactory.getCurrentSession();
//        Session session = entityManager.unwrap(Session.class);
//        //session.save(employee);
//        session.saveOrUpdate(employee);//если id = 0, то save, если id из бд, то update. метод hibernate
        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployee(int id)
    {
//        Session session = entityManager.unwrap(Session.class);
//        //Session session = sessionFactory.getCurrentSession();
//        Employee employee = session.get(Employee.class, id);
//        return employee;
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        //Session session = sessionFactory.getCurrentSession();
//        //Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
//        Query<Employee> query = session.createQuery("delete from Employee where id="+id);
//        //query.setParameter("employeeId", id);
//        query.executeUpdate();
        Query query = entityManager.createQuery("delete from Employee where id="+id);
        query.executeUpdate();
    }
}
