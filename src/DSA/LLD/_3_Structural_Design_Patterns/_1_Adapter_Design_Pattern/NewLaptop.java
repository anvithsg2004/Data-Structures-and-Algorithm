package DSA.LLD._3_Structural_Design_Patterns._1_Adapter_Design_Pattern;

class NewLaptop {
    public void charge(UsbCCharger charger) {
        System.out.println("New laptop charging with USB-C...");
        charger.chargeWithUsbC();
    }
}
