package org.example.configurations;

import org.example.Pen;
import org.example.Pencil;
import org.example.Student;
import org.example.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")

public class PackConfigurations {

//    @Bean
//    public Student student(@Autowired Writer writer){
//        return new Student("Agnes",writer,pencil());
//    }
//
//    @Bean
//    public Pen pen(){
//        return new Pen();
//    }
//
//    @Bean @Primary
//    public Pencil pencil(){
//        return new Pencil();
//    }


}
