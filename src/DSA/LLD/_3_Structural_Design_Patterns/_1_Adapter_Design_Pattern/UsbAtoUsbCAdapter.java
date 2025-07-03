package DSA.LLD._3_Structural_Design_Patterns._1_Adapter_Design_Pattern;

// The adapter/converter
class UsbAtoUsbCAdapter implements UsbCCharger {
    private OldUsbACharger oldCharger;

    public UsbAtoUsbCAdapter(OldUsbACharger charger) {
        this.oldCharger = charger;
    }

    public void chargeWithUsbC() {
        System.out.println("Adapter converting USB-A to USB-C...");
        oldCharger.chargeWithUsbA();
    }
}
