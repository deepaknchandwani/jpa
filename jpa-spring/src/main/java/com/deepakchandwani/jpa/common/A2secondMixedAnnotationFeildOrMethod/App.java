package com.deepakchandwani.jpa.common.A2secondMixedAnnotationFeildOrMethod;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
    PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao2");
    dao.test();
    
    List<Professor> professors = dao.getAll();
    for (Professor person : professors) {
      System.out.println(person);
    }

     
    context.close();
  }
}
