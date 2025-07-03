package DSA.LLD._2_Behavioral_Design_Patterns._7_Template;

public class Coffee extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
