// 10. Regular Expression Matching My Submissions Question

// Implement regular expression matching with support for '.' and '*'.
//
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
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
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true

// Test Cases
// "aa"
// "a"
// "abdcdsab"
// "sa"
// ""
// "*"
// "abc"
// "abc"
// "and"
// "an."
// "aaaaabc"
// "a*bc"
// "adfadfbc"
// ".*bc"
// "aa"
// "a*"
// "aa"
// ".*"
// "aab"
// "a*a*b"
// "abc"
// "abc"
// "abc"
// "d*abc"
// "aab"
// "c*a*b"
// "abdc"
// "a*b*c*"
// "abcd"
// "e*"
// "a"
// "ab*"
// "a"
// "ab*a"
// "ab"
// ".*.."
// ""
// "c*c*"
// "cbaacacaaccbaabcb"
// "c*b*b*.*b*a*"
// "b"
// "bc*a*"
// ""
// "c*a*"
// "cbaacacaa"
// "c*b*b*.*ac*"
public class Solution {
    public boolean isMatch(String s, String p) {
        int length1 = s.length();
        int length2 = p.length();
        int index1 = 0;
        int index2 = 0;
        while(true){
            if(index1==length1 && index2==length2)
            break;
            if(index1==length1){
                if(index2+1!=length2){
                    if(p.charAt(index2+1)==42){
                        if(index2+2==length2)
                        return true;
                        return isMatch(s.substring(index1),p.substring(index2+2));
                    }
                }
                return false;
            }
            if(index2==length2)
            return false;

            if(p.charAt(index2)==42){
                if(index2 == 0)
                return false;
            }
            if(p.charAt(index2) == 46){
                if(index2+1<length2){
                    if(p.charAt(index2+1)==42){
                        if(index2+2 == length2)
                        return true;
                        String oo = s.substring(index1);
                        String ko = p.substring(index2+2);
                        while(true){
                        if(isMatch(oo,ko))
                        return true;
                        if(oo.length()<1)
                        return isMatch("",ko);
                        oo = oo.substring(1);
                        }
                    }
                }
                index1 ++;
                index2 ++;
                continue;
            }
            if(index2+1!=length2){
                if(p.charAt(index2+1)==42){
                    char compare = p.charAt(index2);
                    String oo = s.substring(index1);
                    if(index2+2==length2){
                        while(true){
                        if(oo.length()<1)
                            return true;
                        if(compare != oo.charAt(0))
                        return false;
                        oo = oo.substring(1);
                        }
                    }
                    String ko = p.substring(index2+2);
                    while(true){
                        if(isMatch(oo,ko))
                        return true;
                        if(oo.length()<1)
                        return isMatch("",ko);
                        if(compare != oo.charAt(0))
                        return false;
                        oo = oo.substring(1);

                    }

                }
            }
            if(p.charAt(index2) != s.charAt(index1)){
                return false;
            }
            index1++ ;
            index2++ ;
        }
        return true;
    }
}
