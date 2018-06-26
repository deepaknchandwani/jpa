package com.deepakchandwani.jpa.common.Z2;
 

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
    Z1DaoImpl dao = (Z1DaoImpl) context.getBean("Z2Dao");

    dao.test();

    context.close();
    
    //Helper.checkData();
  }
}
