// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
//
// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

// Your input
//
// "123456789"
// 1
// "12"
// 2
// "ABC"
// 3
// "ABC"
// 2
// "ABCDE"
// 4
// "ABCDEFGIJKLMN"
// 4
// Your answer
//
// "123456789"
// "12"
// "ABC"
// "ACB"
// "ABCED"
// "AGNBFIMCEJLDK"
public class Solution {
    public String convert(String s, int numRows) {
        int sl = s.length();
        int b = getblocknums(numRows);
        int ok = sl%b;
        int gogo = sl/b ;
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < numRows ; i++){
            for(int k = 0 ; k <= gogo ; k++){
                 if(k==gogo){
                     if(i == 0 || i== numRows-1){
                         if(i<ok)
                         sb.append(s.charAt((k*b)+i));
                     }else{
                         if(i<ok)
                         sb.append(s.charAt((k*b)+i));
                         if(b-i<ok)
                         sb.append(s.charAt((k*b)+(b-i)));
                     }
                    break;
                }
                if(i == 0 || i== numRows-1){
                    sb.append(s.charAt((k*b)+i));
                }else{
                    sb.append(s.charAt((k*b)+i));
                    sb.append(s.charAt((k*b)+(b-i)));
                }
            }
        }
        return sb.toString();
    }
    private int getblocknums(int nums){
        int result = nums;
        if(nums>2){
            result = nums+(nums-2);
        }
        return result;
    }
}
