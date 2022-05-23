package com.kuebiko.hello.service;

public class MyFirstService implements  MyFirstServiceIf{

    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int difference(int a, int b) {
        return a-b;
    }

    @Override
    public int multiply(int a, int b) {
        return a*b;
    }

    @Override
    public int divide(int a, int b) {
        return a/b;
    }
}
