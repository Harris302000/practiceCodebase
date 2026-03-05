package org.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pencil implements  Writer{

    public Pencil(String pencilName) {

        this.pencilName = pencilName;
    }

    @Value("Natraj")
    private String pencilName;

    public Pencil(){
        System.out.println("Calling Pencil constructor");
    }
    public void write() {

        System.out.println("Writing using pencil");
    }
}
