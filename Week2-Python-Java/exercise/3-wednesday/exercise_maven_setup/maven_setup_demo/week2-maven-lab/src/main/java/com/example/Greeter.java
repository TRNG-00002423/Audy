package com.example;

public class Greeter {
        String hello(String name){

            if (name.isBlank()){
                throw new IllegalArgumentException("Name can not be blank");
            }
            return "Hello, " + name;
        }
    }

