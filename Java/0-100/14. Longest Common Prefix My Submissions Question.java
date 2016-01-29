// 14. Longest Common Prefix My Submissions Question
// Write a function to find the longest common prefix string amongst an array of strings.

// Subscribe to see which companies asked this question


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null)return "";
        if(strs.length <1) return "";
        int checksize = strs[0].length();
        String result = "";
        for(String s : strs){
            if(s.length()< checksize)
            checksize = s.length();
        }
        for(int i = 0 ; i < checksize ; i ++){
            char x = strs[0].charAt(i);
            for(String s : strs){
                if(s.charAt(i) !=x)
                return result;
            }
            result +=x;
        }
        return result ;
    }
}
