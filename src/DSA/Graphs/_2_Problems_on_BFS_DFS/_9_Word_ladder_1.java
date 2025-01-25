package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.*;

class Pair4 {
    String word;
    int steps;

    public Pair4(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

public class _9_Word_ladder_1 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair4> queue = new LinkedList<>();
        //Add the "beginWord" into the queue.
        queue.add(new Pair4(beginWord, 1));
        //Remove from the wordList.
        wordList.remove(beginWord);


        //Simple BFS
        while (!queue.isEmpty()) {

            String word = queue.peek().word;
            int steps = queue.peek().steps;

            queue.remove();

            //If you get the word from queue then return the steps used to go there.
            if (word.equals(endWord)) {
                return steps;
            }

            //Try changing the character in the word and If it is present in the wordList
            // then remove from the wordList and add it to the queue.
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    //If it exists in the set, then remove and add it in the queue.
                    if (wordList.contains(replacedWord) == true) {
                        wordList.remove(replacedWord);
                        queue.add(new Pair4(replacedWord, steps + 1));
                    }
                }
            }

        }

        return 0;

    }

    public static void main(String[] args) {

    }
}
