// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
// For example:
//
//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB
public class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while(n>26){
            int i ;
            if(n % 26 == 0){
                i=26;
                n-=1;
            }else{
                i = n%26;
            }
            sb.insert(0,(char)(i+64));
            n/=26;
        }
        sb.insert(0,(char)((n % 27) + 64 ));
        return sb.toString() ;
    }
}
