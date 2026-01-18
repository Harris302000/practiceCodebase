package org.example;

import org.example.configurations.PackConfigurations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Student student = new Student();
//        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(PackConfigurations.class);

        Student student = (Student) context.getBean("student");

        System.out.println("Name::"+student.getName());
        student.writeExam();
       // System.out.println("PencilName::"+student.pencil.getPencilName());






    }
}
