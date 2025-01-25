package Java_Core.Java.Old;

class ekclass{
    int a;

    public int getA() {
        return a;
    }

//    ekclass(int v){
//        this.a=v;
//    }

    //Or you can use this also

    ekclass(int a){
        this.a=a;
    }

    public int returnone(){
        return 1;
    }
}

class doclass extends ekclass{

    doclass(int c){
        super(c);
        System.out.println("I am a constructor ");
    }

}

public class _7_this_and_super {
    public static void main(String[] args) {

        ekclass e = new ekclass(5);
        doclass d = new doclass(65);
        System.out.println(e.getA());


    }
}
