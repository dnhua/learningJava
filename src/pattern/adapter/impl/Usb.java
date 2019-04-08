package pattern.adapter.impl;

import pattern.adapter.IUsb;

public class Usb implements IUsb {
    @Override
    public void usbdesc() {
        System.out.println("usb接口");
    }
}
