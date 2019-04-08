package pattern.factory.abstractFactory.impl;

import pattern.factory.abstractFactory.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("circle draw...");
    }
}
