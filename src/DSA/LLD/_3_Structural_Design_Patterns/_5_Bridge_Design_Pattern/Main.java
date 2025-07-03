package DSA.LLD._3_Structural_Design_Patterns._5_Bridge_Design_Pattern;

interface Device {
    void turnOn();

    void turnOff();
}

class TV implements Device {
    public void turnOn() {
        System.out.println("TV is ON");
    }

    public void turnOff() {
        System.out.println("TV is OFF");
    }
}

class Fan implements Device {
    public void turnOn() {
        System.out.println("Fan is ON");
    }

    public void turnOff() {
        System.out.println("Fan is OFF");
    }
}

class Remote {
    private Device device; // Bridge here!

    public Remote(Device device) {
        this.device = device;
    }

    public void pressOnButton() {
        device.turnOn();
    }

    public void pressOffButton() {
        device.turnOff();
    }
}

public class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        Device fan = new Fan();

        Remote remote1 = new Remote(tv);
        remote1.pressOnButton();   // TV is ON
        remote1.pressOffButton();  // TV is OFF

        Remote remote2 = new Remote(fan);
        remote2.pressOnButton();   // Fan is ON
        remote2.pressOffButton();  // Fan is OFF
    }
}
