package pattern.factory.abstractFactory.impl;

import pattern.factory.abstractFactory.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square draw...");
    }
}
