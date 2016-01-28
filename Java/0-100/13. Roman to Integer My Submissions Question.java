// 13. Roman to Integer My Submissions Question
// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.
// "DCXXI"
// "XI"
// "IX"
// "CDIV"
// Your answer
//
// 621
// 11
// 9
// 404


public class Solution {
    private final char one = 'I';
    private final char five = 'V';
    private final char ten = 'X';
    private final char fifty = 'L';
    private final char hundred = 'C';
    private final char fivehundred = 'D';
    private final char thousand = 'M';
    public int romanToInt(String s) {
        int total = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char a = s.charAt(i);
            switch(a){
                case five:
                    total +=5;
                    continue;
                case fifty:
                    total+= 50;
                    continue;
                case fivehundred:
                    total+=500;
                    continue;
            }
            if(i+1 != s.length()){
            char m = s.charAt(i+1);
                    switch(a){
                    case one:
                        if(m==five){
                            total+=4;
                            i++;
                            continue;
                        }
                        if(m==ten){
                            total+=9;
                            i++;
                            continue;
                        }
                        break;
                    case ten:
                        if(m==fifty){
                            total+=40;
                            i++;
                            continue;
                        }
                        if(m==hundred){
                            total+=90;
                            i++;
                            continue;
                        }
                        break;
                    case hundred:
                        if(m==fivehundred){
                            total+=400;
                            i++;
                            continue;
                        }
                        if(m==thousand){
                            total+=900;
                            i++;
                            continue;
                        }
                        break;
                    }
            }
                switch(a){
                    case one:
                        total+=1;
                        break;
                    case ten:
                        total+=10;
                        break;
                    case hundred:
                        total+=100;
                        break;
                    case thousand:
                        total+=1000;
                        break;
                }
        }
        return total;
    }
}
