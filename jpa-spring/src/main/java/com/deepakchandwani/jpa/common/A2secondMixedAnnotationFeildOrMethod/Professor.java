package com.deepakchandwani.jpa.common.A2secondMixedAnnotationFeildOrMethod;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Access(AccessType.FIELD)
@Entity
public class Professor {
  public static String LOCAL_AREA_CODE = "999";
  @Id
  private int id;
  @Transient
  private String phoneNum;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPhoneNumber() {
    return phoneNum;
  }

  public void setPhoneNumber(String num) {
    this.phoneNum = num;
  }

  @Access(AccessType.PROPERTY)
  @Column(name = "PHONE")
  protected String getPhoneNumberForDb() {
    if (null != phoneNum && phoneNum.length() == 10)
      return phoneNum;
    else
      return LOCAL_AREA_CODE + phoneNum;
  }

  protected void setPhoneNumberForDb(String num) {
    if (num.startsWith(LOCAL_AREA_CODE))
      phoneNum = num.substring(3);
    else
      phoneNum = num;
  }
}