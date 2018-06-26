package com.deepakchandwani.jpa.common.Z2;
 

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class PersonZ2 {

	@TableGenerator(name = "personZ2_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "personZ2_gen")
	private int idperson;
	private String name;

	@Embedded
	private AddressZ2 address;

	public int getIdperson() {
		return idperson;
	}

	public void setIdperson(int idperson) {
		this.idperson = idperson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressZ2 getAddress() {
		return address;
	}

	public void setAddress(AddressZ2 address) {
		this.address = address;
	}

}
