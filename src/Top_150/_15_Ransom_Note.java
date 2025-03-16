package Top_150;

//💬 Problem:
//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by
//using the letters from magazine, else return false.
//Each letter in magazine can only be used once in ransomNote.

//🧠 Intuition:
//Count how many times each letter appears in both strings.
//Ensure that for every letter in ransomNote, magazine has equal or more count.

//✅ Example:
//ransomNote = "aabb"
//magazine = "aaabbb"
//Step 1: Count characters
//ransomNote → a:2, b:2
//magazine → a:3, b:3
//Check:
//ransom needs 2 a’s → magazine has 3 ✅
//ransom needs 2 b’s → magazine has 3 ✅
//➡️ ✅ Can build ransomNote → return true

//❌ Counter Example:
//ransomNote = "aabbc"
//magazine = "aabbb"
//Counts:
//ransomNote → a:2, b:2, c:1
//magazine → a:2, b:3, c:0
//Check:
//needs 1 ‘c’ → magazine has 0 ❌
//➡️ ❌ Cannot build ransomNote → return false

//🔄 Dry Run for "aabbc" vs "aabbb":
//magazine count → a:2, b:3, c:0
//ransom:
//'a' → ok → count[a]=1
//'a' → ok → count[a]=0
//'b' → ok → count[b]=2
//'b' → ok → count[b]=1
//'c' → ❌ count[c]=0 → return false

public class _15_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];  // For 'a' to 'z'

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;  // Count letters in magazine
        }

        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) return false;  // Not enough of this char
            count[c - 'a']--;  // Use one
        }

        return true;
    }
}
