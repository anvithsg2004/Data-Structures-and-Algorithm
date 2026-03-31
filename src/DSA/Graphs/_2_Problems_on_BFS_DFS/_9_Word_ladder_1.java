package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.*;

public class _9_Word_ladder_1 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (dict.contains(endWord) == false) {
            return 0;
        }

        int count = 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return count;
                }

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[j] = ch;

                        String newWord = new String(arr);

                        if (dict.contains(newWord)) {
                            queue.add(newWord);
                            dict.remove(newWord);
                        }

                    }

                    arr[j] = original;

                }

            }

            count++;

        }

        return 0;

    }
}
