package pattern.factory.abstractFactory.impl;

import pattern.factory.abstractFactory.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("rectangle draw...");
    }
}
