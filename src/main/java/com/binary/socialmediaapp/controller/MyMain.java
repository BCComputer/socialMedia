package com.binary.socialmediaapp.controller;

public class MyMain {
    public static void main(String []args) {

        System.out.println("Number of arguments: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }
    }
}
