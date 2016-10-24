// Implement wildcard pattern matching with support for '?' and '*'.
//
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
//
// The matching should cover the entire input string (not partial).
//
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false

public class Solution {
    // My idea but not accpet beacuse timelimit 我的廣度搜尋想法。
    // public boolean isMatch(String s, String p) {
    //     int head = 0 ;
    //     int tail = 0 ;
    //     if(s.length()==0 && p.length()==0)return true;
    //     if(p.length()<1)return false;
    //     if(p.length() == 1 && p.charAt(0) == '*')return true;
    //     if(s.length() < 1)return false;
    //     Map<Integer,String[]> temp = new HashMap<>();
    //     temp.put(tail,new String[]{s,p});
    //     tail++;
    //     while(head < tail){
    //         String[] c = temp.get(head);
    //         if(c[0].length()==0 && c[1].length()==0)return true;
    //         if(c[1].length() == 0){
    //             head++;
    //             continue;
    //         }
    //         char x = c[1].charAt(0);
    //         switch(x){
    //             case '?':
    //                 if(c[0].length()<1)break;
    //                 if(c[1].length()>1){
    //                 temp.put(tail,new String[]{c[0].substring(1),c[1].substring(1)});
    //                 tail++;
    //                 break;
    //                 }
    //                 if(c[0].length() == 1 && c[1].length() == 1)
    //                 return true;
    //                 break;
    //             case '*':
    //                 int unknowcount = 0;
    //                 boolean jump = true;
    //                 while(c[1].length() > 0 && jump){
    //                     switch(c[1].charAt(0)){
    //                         case '*':
    //                             c[1] = c[1].substring(1);
    //                             break;
    //                         case '?':
    //                             unknowcount++;
    //                             c[1] = c[1].substring(1);
    //                             break;
    //                         default:
    //                         jump=false;break;
    //                     }
    //                 }
    //                 if(c[1].length() == 0){
    //                     if(c[0].length()>=unknowcount)
    //                     return true;
    //                     else
    //                     return false;
    //                 }
    //                 if(c[0].length()<unknowcount)break;
    //                 c[0] = c[0].substring(unknowcount);
    //                 String f="";
    //                 for(int m = 0 ; m < c[1].length() ; m++){
    //                     if(c[1].charAt(m)=='*'||c[1].charAt(m)=='?')
    //                     break;
    //                     f+=c[1].charAt(m);
    //                 }
    //                 while(c[0].indexOf(f)!=-1){
    //                     c[0]= c[0].substring(c[0].indexOf(f)+1);
    //                     temp.put(tail,new String[]{c[0],c[1].substring(1)});
    //                     tail++;
    //                 }
    //                 break;
    //             default:
    //             if(c[0].length()<1 || c[0].charAt(0)!=x)break;
    //             if(c[0].length()>=1 && c[1].length()>1){
    //                 temp.put(tail,new String[]{c[0].substring(1),c[1].substring(1)});
    //                 tail++;
    //                 break;
    //             }
    //             if(c[0].length() == 1 && c[1].length() == 1)
    //             return true;
    //             break;
    //         }
    //         temp.remove(head);
    //         head++;
    //     }
    //     return false;
    // }

    // 網路大大的回逤法。
    boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
}
