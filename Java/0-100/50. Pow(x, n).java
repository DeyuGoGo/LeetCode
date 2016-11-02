// imp pow

public class Solution {
    public double myPow(double x, int n) {
        double temp = x , temp2 = 0;
        if(n==0) return 1;
        if(n == Integer.MIN_VALUE){
            return 1/x * myPow(x,n+1);
        }
        int absn = n < 0 ? -n : n;
        int t = 0;
        // 如果是30次方 會等於 temp 次方(1 -> 2 -> 4 -> 8 -> 16)* temp2 次方(如果有餘數的話才會出現 8 + 4 + 2)
        // 16 + 14
        while(absn>=2){
            if(absn % 2 == 1){
                if(temp2 == 0 )
                temp2  = temp;
                else
                temp2 = temp2 * temp;
            }
            temp *= temp;
            absn /= 2;
        }
        if(temp2!=0)
        temp*=temp2;
        return n > 0 ? temp : 1 / temp;
    }
}
