// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
// For example,
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

// 自己想的，一直向左靠攏
public class Solution {
    public int trap(int[] height) {
        if(height.length<1)
        return 0;
        int sum = 0 ,heightestindex = 0;
        int lasth = height[0];
        int heightestnow = lasth;
        for(int i = 1; i < height.length ; i ++ ){
            int h = height[i];
            if(h > lasth){
                int t = Math.min(h ,heightestnow);
                for(int k = i -1 ; k > heightestindex ; k--){
                    int s = t - height[k];
                    if(s <= 0)
                    break;
                    sum+=s;
                    height[k] = t;
                }
            }
            if(h >= heightestnow){
                heightestnow = h;
                heightestindex = i;
            }
            lasth = h ;
        }
        return sum;
    }
}

// 網路神人答案，兩邊同時靠攏。
public int trap(int[] A){
    int a=0;
    int b=A.length-1;
    int max=0;
    int leftmax=0;
    int rightmax=0;
    while(a<=b){
        leftmax=Math.max(leftmax,A[a]);
        rightmax=Math.max(rightmax,A[b]);
        if(leftmax<rightmax){
            max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
            a++;
        }
        else{
            max+=(rightmax-A[b]);
            b--;
        }
    }
    return max;
}
