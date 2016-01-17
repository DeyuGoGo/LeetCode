// 7. Reverse Integer My Submissions Question
// Reverse digits of an integer.
//
// Example1: x = 123, return 321
// Example2: x = -123, return -321
public class Solution {
    public int reverse(int x) {
        try{
             int a = Integer.valueOf(okqwer(Math.abs(x)));
             if(x<0)a=a*-1;
            return a;
        }catch(Exception e){
            return 0;
        }
    }
    private String okqwer(int x){
        String strY = new String(""+x);
        char[] abc = strY.toCharArray();
        int ok = strY.length();
        for(int i = 0 ; i < ok ; i++){
            int po =  ((ok -i)-1);
            if(i >= po)
            break;
            char temp = abc[i];
            abc[i] =abc[po];
            abc[po] = temp;
        }
        return new String(abc);
    }
}
