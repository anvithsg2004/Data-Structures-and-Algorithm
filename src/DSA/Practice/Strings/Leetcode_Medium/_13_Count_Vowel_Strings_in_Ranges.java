package DSA.Practice.Strings.Leetcode_Medium;

import java.util.Arrays;
import java.util.HashSet;

public class _13_Count_Vowel_Strings_in_Ranges {

    //Here I'm using "Prefix Sum".
    public int[] vowelStrings2(String[] words, int[][] queries) {

        // Use the length of words to determine the prefix sum array size
        int m = words.length;
        int n = queries.length;

        int[] prefixSum = new int[m]; // prefixSum array size based on words length
        prefixSum[0] = isVowel(words[0]);

        for (int i = 1; i < m; i++) {
            prefixSum[i] = prefixSum[i - 1] + isVowel(words[i]);
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // Ensure the query is within the bounds of the word array
            if (right >= m) {
                throw new ArrayIndexOutOfBoundsException("Query index out of bounds: " + right);
            }

            int result = prefixSum[right];

            if (left != 0) {
                result = result - prefixSum[left - 1];
            }

            answer[i] = result;
        }

        return answer;
    }

    public int isVowel(String word) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
            return 1;
        } else {
            return 0;
        }
    }

    //This is correct, but the time limit exceeded.
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;

        int[] answer = new int[n];

        HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u')
        );

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = queries[i][0]; j <= queries[i][1]; j++) {

                String res = words[j];

                if (vowels.contains(res.charAt(0)) && vowels.contains(res.charAt(res.length() - 1))) {
                    count++;
                }

            }

            answer[i] = count;

        }

        return answer;
    }
}
