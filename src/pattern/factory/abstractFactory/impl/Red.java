package pattern.factory.abstractFactory.impl;

import pattern.factory.abstractFactory.Color;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("red fill...");
    }
}
