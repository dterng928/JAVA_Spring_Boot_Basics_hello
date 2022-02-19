package com.example.hello;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component // singleton
public class NumberGenerator {

    public int get(){
        return new Random().nextInt(10);
    }
}
