package Java_Core.Java.Old.Interfaces;

interface bicycle{
    int s = 22;
    void ApplyBrakes(int decrement);
    void ApplySpeed(int increment);
}

interface HornBycicle{
  void HornK3g();
  void HornMHN();
};

//We can add many interface to one class.
//But in abstract it can not be done.
class HeroCycle implements bicycle,HornBycicle{
    public void ApplyBrakes(int decrement){
        System.out.println("Applying Brakes");
    }
    public void ApplySpeed(int increment){
        System.out.println("Applying Speed");
    }
    public void Horn(){
        System.out.println("Pee Pee Poo Poo");
    }
    public void HornK3g(){
        System.out.println("Kahbi kushi kabhi gham");
    };
    public void HornMHN(){
        System.out.println("Har gadi");
    };
}

public class _1_Interfaces {
    public static void main(String[] args) {
        HeroCycle anva = new HeroCycle();
        anva.ApplyBrakes(5);
        //We can create new properties in interface.
        System.out.println(HeroCycle.s);
        //We can not modify the properties in the interface.
//      HeroCycle.s=45;
//      System.out.println(HeroCycle.s);
        anva.HornK3g();
        anva.HornMHN();
    }
}
