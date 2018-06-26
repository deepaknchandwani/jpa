package com.deepakchandwani.jpa.common.Z1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
    Z1DaoImpl dao = (Z1DaoImpl) context.getBean("Z1Dao");

    dao.test();

    context.close();
    
    //Helper.checkData();
  }
}
