package DSA.Practice.Strings.Leetcode_Easy;

public class _3_Permutation_Difference_between_Two_Strings {

    public int findPermutationDifference(String s, String t) {
        int [] occS=new int [26];
        int [] occT=new int [26];
        for(int i=0;i<s.length();i++){
            occS[s.charAt(i)-'a']=i;
            occT[t.charAt(i)-'a']=i;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            ans+=Math.abs(occS[i]-occT[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
