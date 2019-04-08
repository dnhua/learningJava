package pattern.factory.abstractFactory.impl;

import pattern.factory.abstractFactory.Color;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("green fill...");
    }
}
