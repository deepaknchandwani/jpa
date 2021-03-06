package com.deepakchandwani.jpa.common.jpa.performance;

 
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query; 

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roberto Cortez
 */
/*@Singleton*/@Transactional
public class PerformanceBean {
    @PersistenceContext
    private EntityManager entityManager;

    /*@PostConstruct*/  
    public void init(int loop) {
    	 
        for (int i = 1+ loop*10000; i <= 10000 + loop*10000; i++) {
            System.out.println("Inserting record " + i);
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setId((long) i);

            for (int j = 1; j <= 100; j++) {
                try {
                    BeanUtils.setProperty(departmentEntity, "property" + j, "abcdefghijklmno");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            departmentEntity.setEmployees(new ArrayList<EmployeeEntity>());
            for (int j = 1; j <= 2; j++) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId((long) (i * 10 - 10 + j));

                for (int k = 1; k <= 100; k++) {
                    try {
                        BeanUtils.setProperty(employeeEntity,
                                              "property" + k,
                                              "abcdefghijklmno");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                employeeEntity.setDepartmentEntity(departmentEntity);
                departmentEntity.getEmployees().add(employeeEntity);
            }

            entityManager.persist(departmentEntity);
            if(i%2500==2499)entityManager.flush();
        }
        System.out.println("init exiting");
    }

    public Long count() {
        return (Long) entityManager.createQuery("select count(p) from DepartmentEntity p").getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<DepartmentEntity> findAll() {
        return entityManager.createQuery("select p from DepartmentEntity p").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<DepartmentEntity> findAllNeededColumns() {
        return entityManager.createQuery("select p.id, p.property01, p.property02, p.property03, p.property04, " +
                                         "p.property05, p.property06, p.property07, p.property08, p.property09, " +
                                         "p.property10 from DepartmentEntity p").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<DepartmentEntity> findAllNeededColumnsPaginated() {
        Query query =entityManager.createQuery("select d from 	DepartmentEntity d left join fetch d.employees");
        /*entityManager.createQuery("select p from DepartmentEntity p");
                entityManager.createQuery("select p.id, p.property01, p.property02, p.property03, p.property04, " +
                                          "p.property05, p.property06, p.property07, p.property08, p.property09, " +
                                          "p.property10 from DepartmentEntity p");*/
        query.setFirstResult(1);
        query.setMaxResults(1);
        return query.getResultList();
    }

    /*@SuppressWarnings("unchecked")
    public List<DepartmentEntity> findAllEager() {
        Query query = entityManager.createQuery("select p from DepartmentEntity p");
        query.setHint("javax.persistence.fetchgraph",  entityManager.getEntityGraph("departmentWithEmployees") );
        return query.getResultList();
    }*/

    public List<DepartmentEntity> findAllLazy() {
        List<DepartmentEntity> all = findAll();
        for (DepartmentEntity departmentEntity : all) {
            List<EmployeeEntity> employeeEntities =
                    departmentEntity.getEmployees();
            System.out.println(employeeEntities.size());
        }
        return all;
    }

    @SuppressWarnings("unchecked")
    public List<DepartmentEntity> findAllFetchLazy() {
        return entityManager.createQuery(
                "select p from DepartmentEntity p left join fetch p.employees").getResultList();
    }
    
 private static List<String> results = new ArrayList<>();
    
    public void testFindAll() {
        System.out.println("PerformanceBeanTest.testFindAll");
        long start = System.currentTimeMillis();
        List<DepartmentEntity> all = new PerformanceBean().findAll();
        long end = System.currentTimeMillis();
        results.add("Time for findAll: " + (end - start));
        System.out.println("Elements for findAll: " + all.size());
    }
}
