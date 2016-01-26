// 12. Integer to Roman My Submissions Question

// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.
// Your input
//
// 1
// 123
// 42
// 928
// 1239
// 2349
// Your answer
//
// "I"
// "CXXIII"
// "XLII"
// "CMXXVIII"
// "MCCXXXIX"
// "MMCCCXLIX"

public class Solution {
    private char one = 'I';
    private char five = 'V';
    private char ten = 'X';
    private char fifty = 'L';
    private char hundred = 'C';
    private char fivehundred = 'D';
    private char thousand = 'M';
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        int th = num/1000;
        while(th>0){
            th--;
            sb.append(thousand);
        }
        num = num % 1000;
        sb = append(sb,num , hundred , fivehundred , thousand, 100);
        num = num % 100;
        sb = append(sb,num , ten , fifty ,hundred, 10);
        num = num % 10 ;
        sb = append(sb,num , one , five ,ten, 1);
        return sb.toString();
    }
    private StringBuffer append(StringBuffer sb  ,int num , char one , char five , char ten, int unit){
        int nineunit = unit * 9;
        int fiveunit = unit * 5;
        int fourunit = unit * 4;
        if(num / nineunit !=0){
            sb.append(one);
            sb.append(ten);
            return sb;
        }
        if(num / fiveunit !=0){
            sb.append(five);
            num -= fiveunit;
        }
        else{
            if(num / fourunit !=0){
                sb.append(one);
                sb.append(five);
                num -= fourunit;
            }
        }
        int k = num /unit;
        while(k>0){
            sb.append(one);
            k--;
        }
        return sb;
    }
}
