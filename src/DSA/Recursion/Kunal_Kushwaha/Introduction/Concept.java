package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class Concept {

    //Passing Number
    //Difference between n-- and --n
    //n-- is like first pass and then subtract.
    //--n is like I'll subtract first and then pass.

    //Difference between n++ and ++n
    //n++ is like first pass and then add.
    //++n is like I'll add first and then pass.

    //Here is an Example :-
    //If I run this, it will provide me Stack Overflow which means Infinity.
    public static void fun(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        fun(n--);
    }

    //It will give proper output.
    public static void fun2(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        fun(--n);
    }

    public static void main(String[] args) {

    }
}
