package pattern.factory.simpleFactory;

public class Test {
    public static void main(String[] args) {
        INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_Rice);
        noodles.desc();
    }
}
