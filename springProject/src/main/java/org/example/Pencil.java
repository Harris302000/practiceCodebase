package org.example;

public class Pencil implements  Writer{

    private String pencilName;

    public String getPencilName() {
        return pencilName;
    }

    public void setPencilName(String pencilName) {
        this.pencilName = pencilName;
    }


    public void write() {
        System.out.println("Writing using pencil");
    }
}
