package DSA.Hashing;

import java.util.HashMap;

public class _3_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> program = new HashMap<String, Integer>();

        program.put("Java", 10);
        program.put("Python", 1);
        program.put("C", 5);
        program.put("C++", 8);

        System.out.println(program);

        System.out.println(program.size());

        int index = program.size();

        for (int i = 0; i < index; i++) {
            String key = (String) program.keySet().toArray()[i];
            Integer value = program.get(key);

            System.out.println("Program : " + key + " Value : " + value);
        }
    }
}
