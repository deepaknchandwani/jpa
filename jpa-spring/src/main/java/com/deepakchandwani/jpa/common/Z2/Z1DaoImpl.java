package com.deepakchandwani.jpa.common.Z2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Z1DaoImpl {
  public void test() {
     
	  PersonZ2 prasad = new PersonZ2();
		prasad.setName("prasad");

		AddressZ2 address = new AddressZ2();
		address.setArea("Pimpri Saudagar");
		address.setCity("pune");
		address.setPincode("411 027");

		prasad.setAddress(address);

		em.persist(prasad);

		Office office = new Office();
		office.setAddress(address);

		em.persist(office);
   

  }

  @PersistenceContext
  private EntityManager em;
}
