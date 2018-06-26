package com.deepakchandwani.jpa.common.A6Collection;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;

@Entity
public class DepartmentA6 {
    @Id @GeneratedValue/*(strategy=GenerationType.IDENTITY)*/
    private int id;
    private String name;
    
    @ElementCollection
    @CollectionTable(name="EMP_SENIORITY")
    @MapKeyJoinColumn(name="EMP_ID")
    @Column(name="SENIORITY")
    private Map<EmployeeA6, Integer> seniorities;
    
    public DepartmentA6() {
        seniorities = new HashMap<EmployeeA6, Integer>();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String deptName) {
        this.name = deptName;
    }
    
    public Map<EmployeeA6, Integer> getEmployees() {
        return seniorities;
    }

    public void setEmployeeSeniority(EmployeeA6 employeeA6, int seniority) {
        seniorities.put(employeeA6, seniority);
    }

    public void removeEmployee(EmployeeA6 employeeA6) {
        seniorities.remove(employeeA6);
    }

    public String toString() {
        StringBuffer aBuffer = new StringBuffer("DepartmentA6 ");
        aBuffer.append(" id: ");
        aBuffer.append(id);
        aBuffer.append(" name: ");
        aBuffer.append(name);
        aBuffer.append(" employeeCount: ");
        aBuffer.append(seniorities.size());
        return aBuffer.toString();
    }
}