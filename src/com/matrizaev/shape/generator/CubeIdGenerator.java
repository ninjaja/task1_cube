package com.matrizaev.shape.generator;

public class CubeIdGenerator {

    private static int counter = 0;

    public static int generateId() {
        return ++counter;
    }
}
