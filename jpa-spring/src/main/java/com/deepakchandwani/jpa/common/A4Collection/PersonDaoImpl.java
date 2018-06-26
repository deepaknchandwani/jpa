package com.deepakchandwani.jpa.common.A4Collection;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonDaoImpl {
  public void test() {
    Employee e = new Employee();
    e.setName("Tom");
    Map<String,String> phoneMap= new HashMap<String, String>();
    phoneMap.put("TestPhoneNumber","1234");
    e.setPhoneNumbers(phoneMap);
    Department d = new Department();
    d.addEmployee(e);
    d.setName("test");
    
    e.setDepartment(d);
    
    d.addEmployee(e);
    em.persist(e);
    em.persist(d);
  }

  @PersistenceContext
  private EntityManager em;
}
