package org.example;

import lombok.Data;

@Data
public class Pencil implements  Writer{

    private String pencilName;

    public Pencil(){
        System.out.println("Calling Pencil constructor");
    }
    public void write() {
        System.out.println("Writing using pencil");
    }
}
