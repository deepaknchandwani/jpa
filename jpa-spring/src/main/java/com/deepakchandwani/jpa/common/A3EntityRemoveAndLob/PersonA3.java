package com.deepakchandwani.jpa.common.A3EntityRemoveAndLob;
import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMP")
public class PersonA3 {
	@Id
  @Column(name = "EMP_ID")
	@GeneratedValue
  private long id;
	
  @Basic
	private String name;
	private String surname;
	
	@Temporal(TemporalType.DATE)
    private Date lastAccessTime;
	
  public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

@Lob 
  @Basic(fetch=LAZY)
  private byte[] picture;
  
	public PersonA3() {}

	public PersonA3(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }

  @Override
	public String toString() {
		return "PersonA3 [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
}