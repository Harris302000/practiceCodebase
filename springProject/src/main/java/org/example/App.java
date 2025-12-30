package org.example;

import org.springframework.context.ApplicationContext;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

        Student student = (Student) context.getBean("s1");

        String name = student.getName();
        System.out.println("name::"+name);


    }
}
