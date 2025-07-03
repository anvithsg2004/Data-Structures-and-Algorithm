package DSA.LLD._2_Behavioral_Design_Patterns._7_Template;

public abstract class BeverageTemplate {

    // Template method (final so subclasses can't change it)
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Abstract steps to be defined by subclasses
    protected abstract void brew();

    protected abstract void addCondiments();
}
