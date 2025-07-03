package DSA.LLD._2_Behavioral_Design_Patterns._7_Template;

public class Tea extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}
