// Given two numbers represented as strings, return multiplication of the numbers as a string.
//
// Note:
// The numbers can be arbitrarily large and are non-negative.
// Converting the input string to integer is NOT allowed.
// You should NOT use internal library such as BigInteger.

// 大數字字串的乘法，利用陣列跟數學計算法邏輯慢慢一步一步完成。
public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] total = new int[l1+l2];
        for(int i = l1 - 1 ; i >= 0  ; i-- )
        for(int k = l2 - 1 ; k >= 0  ; k-- ){
            int mul = (num1.charAt(i) - '0') * (num2.charAt(k) - '0');
            int sum = total[i+k+1] + mul;
            total[i+k] += (sum /10);
            total[i+k+1] = (sum %10);
        }
        StringBuffer sb = new StringBuffer();
        for(int s : total){
            if(sb.length() == 0 && s == 0){
                continue;
            }
            sb.append(s);
        }
        if(sb.length()==0)return "0";
        return sb.toString();
    }
}
