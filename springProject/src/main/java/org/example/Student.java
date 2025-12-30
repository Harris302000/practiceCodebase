package org.example;

public class Student {

    private String name;
    public Writer writer;


    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeExam(){
        writer.write();
    }

}
