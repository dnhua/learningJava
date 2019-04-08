package pattern.factory.simpleFactory;

public class SimpleNoodlesFactory {
    public static final int TYPE_Rice = 1;
    public static final int TYPE_Sliced = 2;
    public static final int TYPE_Instant = 3;

    public static INoodles createNoodles(int type) {
        switch (type) {
            case TYPE_Rice:
                return new RiceNoodles();
            case TYPE_Sliced:
                return new SlicedNoodles();
            case TYPE_Instant:
            default:
                return new InstantNoodles();
        }
    }
}
