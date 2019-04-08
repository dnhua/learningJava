package pattern.adapter.impl;

import pattern.adapter.IPs2;

public class Adapter extends Usb implements IPs2 {
    @Override
    public void ps2desc() {
        System.out.println("ps2 to");
        usbdesc();
    }
}
