package pattern.adapter;

import pattern.adapter.impl.Adapter;

public class Test {
    public static void main(String[] args) {
        IPs2 p = new Adapter();
        p.ps2desc();
    }
}
