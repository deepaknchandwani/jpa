package com.deepakchandwani.jpa.common.Z1;
 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class EmployeeZ1 {

	@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100,initialValue=21)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	private int idemployee;
	private String firstname;
	private String lastname;
	private String email;

	@ManyToOne
	@JoinColumn(name = "iddepartment")
	private DepartmentZ1 department;

	public int getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DepartmentZ1 getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentZ1 department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [idemployee=" + idemployee + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email
				+ "]";
	}

}
