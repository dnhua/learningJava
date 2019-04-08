package pattern.factory.abstractFactory.impl;

import pattern.factory.abstractFactory.Color;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("blue fill...");
    }
}
