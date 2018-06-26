package com.deepakchandwani.jpa.common.A6Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonDaoImpl {
  public void test() {
    EmployeeA6 e = new EmployeeA6();
    e.setName("Tom");
    DepartmentA6 d = new DepartmentA6();
  
    d.setName("test");
    d.getEmployees().put(e, e.getId());
    
    
    em.persist(e);    
    em.persist(d);
   

  }

  @PersistenceContext
  private EntityManager em;
}
