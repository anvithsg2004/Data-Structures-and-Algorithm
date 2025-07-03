package DSA.LLD._3_Structural_Design_Patterns._1_Adapter_Design_Pattern;

public class Main {
    public static void main(String[] args) {
        OldUsbACharger oldCharger = new OldUsbACharger();
        UsbCCharger adapter = new UsbAtoUsbCAdapter(oldCharger);

        NewLaptop laptop = new NewLaptop();
        laptop.charge(adapter);
    }
}
