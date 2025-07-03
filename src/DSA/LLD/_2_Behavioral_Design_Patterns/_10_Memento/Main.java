package DSA.LLD._2_Behavioral_Design_Patterns._10_Memento;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type("Hello ");
        Memento saved = editor.save();  // Save state

        editor.type("World!");
        System.out.println("Text now: " + editor.getText());  // Hello World!

        editor.restore(saved);  // Undo
        System.out.println("After undo: " + editor.getText()); // Hello
    }
}
