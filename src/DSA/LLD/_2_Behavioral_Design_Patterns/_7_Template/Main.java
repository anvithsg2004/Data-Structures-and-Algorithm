package DSA.LLD._2_Behavioral_Design_Patterns._7_Template;

public class Main {
    public static void main(String[] args) {
        BeverageTemplate tea = new Tea();
        tea.prepareBeverage();

        System.out.println();

        BeverageTemplate coffee = new Coffee();
        coffee.prepareBeverage();
    }
}
