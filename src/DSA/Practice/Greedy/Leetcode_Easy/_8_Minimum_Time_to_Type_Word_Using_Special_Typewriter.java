package DSA.Practice.Greedy.Leetcode_Easy;

public class _8_Minimum_Time_to_Type_Word_Using_Special_Typewriter {
    public int minTimeToType(String word) {

        int n = word.length();

        int answer = 0;

        char current = 'a';

        for (int i = 0; i < n; i++) {

            char next = word.charAt(i);

            int forward = (next - current + 26) % 26;
            int backward = (current - next + 26) % 26;

            answer = answer + Math.min(forward, backward) + 1;

            current = next;

        }

        return answer;

    }

    public static void main(String[] args) {

        char a = 'a';

        System.out.println('b' - a);
    }
}
