package org.example;

public class Student {

    private String name;
    public Writer writer;
    public Pencil pencil;

    public Student(String name, Writer writer, Pencil pencil) {
        System.out.println("Calling student constructor");
        this.name = name;
        this.writer = writer;
        this.pencil = pencil;

    }

    public void writeExam(){
        writer.write();
    }

}
