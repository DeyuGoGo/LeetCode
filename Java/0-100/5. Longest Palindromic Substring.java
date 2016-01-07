// Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

// Subscribe to see which companies asked this question

// Your input
//
// "a"
// "abck"
// "aba"
// "aaaah"
// Your answer
//
// "a"
// "k"
// "aba"
// "aaaa"

public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int max = -1 ;
        for(int index = 0 , sl = s.length(); index < sl ; index++){
            if(max-1 >(sl - index ))break;
            int m1 = getMaxI(s,index,sl ,1);
            int m2 = getMaxII(s,index,sl,1);
            if(max > m1 && max >= m2)
            continue;
            if(m1>=m2){
                result = s.substring(index - m1, index+ (m1+1));
                max = m1;
            }
            else{
                result = s.substring(index - (m2-1) , index+(m2+1));
                max =m2;
            }
        }

        return result;
    }

    private int getMaxI(String s , int index , int Slength , int offset){
        int max = offset-1 ;
        if(index+offset >= Slength)
        return max;
        if(index-offset < 0)
        return max;
        if(s.charAt(index-offset)==s.charAt(index+offset))
        return getMaxI(s,index,Slength,++offset);
        return max;
    }
    private int getMaxII(String s , int index , int Slength , int offset){
        int max = offset -1;
        if(index+offset >= Slength)
        return max;
        if(index-(offset-1) < 0)
        return max;
        if(s.charAt(index-(offset-1))==s.charAt(index+offset))
        return getMaxII(s,index,Slength , ++offset);
        return max;
    }
}
