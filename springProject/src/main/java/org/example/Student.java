package org.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Data
@Component
public class Student {

    @Value("Agnes")
    private String name;

    @Autowired
    @Qualifier("pen")
    public Writer writer;

    @Autowired
    public Pencil pencil;

    @Autowired
    public Pen pen;

//    public Student(String name, Writer writer, Pencil pencil) {
//        System.out.println("Calling student constructor");
//        this.name = name;
//        this.writer = writer;
//        this.pencil = pencil;
//
//    }

    public void writeExam(){
        writer.write();
    }

}
