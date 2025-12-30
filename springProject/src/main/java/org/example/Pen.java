package org.example;

import org.springframework.stereotype.Component;

@Component
public class Pen implements Writer {

    public Pen(){
        System.out.println("Calling pen constructor");
    }

    public void write() {
        System.out.println("Writing using pen");
    }


}
