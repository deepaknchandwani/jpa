package com.deepakchandwani.jpa.common.jpa.performance;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
    PerformanceBean dao = (PerformanceBean) context.getBean("perDao");
    /*for (int i = 0; i < 10; i++) {
    	 dao.init(i);
	}*/
   
    List<DepartmentEntity> d=dao.findAllNeededColumnsPaginated();

    context.close();
    
    //Helper.checkData();
  }
}
