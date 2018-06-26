package com.deepakchandwani.jpa.common.A3EntityRemoveAndLob;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonDaoImpl {
	
	
	public void test() {
		PersonA3 emp = new PersonA3();
	    emp.setName("Tom");

	    em.persist(emp);
	    
	    emp = em.find(PersonA3.class, emp.getId());
	    
	    PersonA3 managedEmp = em.merge(emp);
	    managedEmp.setLastAccessTime(new Date());

	  }
  public void test1(){
    PersonA3 p1 = new PersonA3("Tom", "Smith");
    //p1.setId(1L);
    p1.setPicture("asdf".getBytes());
    PersonA3 p2 = new PersonA3("Jack", "Kook");
    //p2.setId(2L);
    p1.setPicture("com.deepakchandwani".getBytes());
    
    save(p1);
    save(p2);

    listAll();
    
    PersonA3 emp =  em.find(PersonA3.class, 1L);
    if (emp != null) {
      em.remove(emp);
    }
    listAll();
  }
  private void listAll(){
    List<PersonA3> persons = getAll();
    for (PersonA3 person : persons) {
      System.out.println(person);
    }

  }
	@PersistenceContext
	private EntityManager em;
	
	
	public Long save(PersonA3 person) {
		em.persist(person);
		return person.getId();
	}
	
	public List<PersonA3>getAll() {
		return em.createQuery("SELECT p FROM PersonA3 p", PersonA3.class).getResultList();
	}
	
}
