// 8. String to Integer (atoi)
// Implement atoi to convert a string to an integer.
//
// Hint: Carefully consider all possible input cases.
// If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//
// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
// You are responsible to gather all the input requirements up front.

public class Solution {
    public int myAtoi(String str) {
        StringBuffer sb = new StringBuffer();
        char[] abc = str.toCharArray();
        boolean hasInt = false;
        boolean ko = false;
        for(int i = 0 ; i <abc.length ; i++){
            int b = abc[i];
            if(b>57)break;
            if(b<48){
                if(b==32){
                    if(ko)break;
                    if(hasInt)
                    break;
                    continue;
                }
                if( b==43 || b==45){
                    if(ko)break;
                    ko = true;
                    if(hasInt)
                    break;
                    continue;
                }
                break;
            }

            if(!hasInt){
                if(i > 0){
                    if(abc[i-1] == 45){
                        sb.append('-');
                    }
                }
            }
            sb.append(abc[i]);
            hasInt = true;
        }
        String result = sb.toString();
        if(result.equals("") || result.equals("-"))
        return 0 ;
        if(result.length()>11){
            if(result.charAt(0) == '-')
            return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        long s = Long.parseLong(result);
        if(s > Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if(s < Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return (int)s;
    }
}
