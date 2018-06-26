package com.deepakchandwani.jpa.common.A5Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonDaoImpl {
  public void test() {

    EmployeeA5 emp = new EmployeeA5();
    emp.setName("name");
    emp.setSalary(12345);
    
    VacationEntry v = new VacationEntry();
    v.setDaysTaken(10);
    
    emp.getVacationBookings().add(v);
    emp.getNickNames().add("Tester");
    em.persist(emp);
  }

  @PersistenceContext
  private EntityManager em;
}
