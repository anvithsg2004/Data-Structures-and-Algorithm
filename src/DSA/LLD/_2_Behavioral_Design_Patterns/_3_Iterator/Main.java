package DSA.LLD._2_Behavioral_Design_Patterns._3_Iterator;

public class Main {
    public static void main(String[] args) {
        NameRepository repo = new NameRepository();

        MyIterator it = repo.getIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
