package com.deepakchandwani.jpa.common.Z1;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Z1DaoImpl {
  public void test() {
     
	  DepartmentZ1 d = new DepartmentZ1();
	  d.setIddepartment(1);
	  d.setName("TestZ1");
    EmployeeZ1 employee = new EmployeeZ1();
	employee.setEmail("someMail@gmail.com");
	employee.setFirstname("Prasad");
	employee.setLastname("kharkar"); 
    employee.setDepartment(d);;
    
    
    em.persist(d);    
    em.persist(employee);
   

  }

  @PersistenceContext
  private EntityManager em;
}
