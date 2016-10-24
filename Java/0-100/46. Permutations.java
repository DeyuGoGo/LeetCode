// Given a collection of distinct numbers, return all possible permutations.
//
// For example,
// [1,2,3] have the following permutations:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

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
