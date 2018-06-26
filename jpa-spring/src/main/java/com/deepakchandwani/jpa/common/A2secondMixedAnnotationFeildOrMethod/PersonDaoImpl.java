package com.deepakchandwani.jpa.common.A2secondMixedAnnotationFeildOrMethod;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

 

@Transactional
public class PersonDaoImpl {
  public void test() {

	  Professor emp = new Professor();
	    emp.setId(1);
	    emp.setPhoneNumber("123456789");
	    em.persist(emp);
    

  }

  public List<Professor>getAll() {
		return em.createQuery("SELECT p FROM Professor p", Professor.class).getResultList();
	}
  @PersistenceContext
  private EntityManager em;
}

