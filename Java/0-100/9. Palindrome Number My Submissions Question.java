// 9. Palindrome Number My Submissions Question

// 做個檢測數字是否為回文
// Determine whether an integer is a palindrome. Do this without extra space.
public class Solution {
    public boolean isPalindrome(int x) {
        String ok = String.valueOf(x);
        int l = ok .length();
        int index = l / 2;
        int small = index -1;
        int k = l % 2;
        if(k == 1) index += 1;
        while(true){
            if(small<0)break;
            if(!(ok.charAt(small) == (ok.charAt(index))))
            return false;
            small--;
            index++;
        }
        return true;
    }
}
