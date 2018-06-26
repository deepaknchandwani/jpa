package com.deepakchandwani.jpa.common.Z1;
 
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DepartmentZ1 {

	@Id
	private int iddepartment;
	private String name;

	public int getIddepartment() {
		return iddepartment;
	}

	public void setIddepartment(int iddepartment) {
		this.iddepartment = iddepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [iddepartment=" + iddepartment + ", name=" + name
				+ "]";
	}

}