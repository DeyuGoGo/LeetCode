// 11. Container With Most Water My Submissions Question

// Given n non-negative integers a1, a2, ..., an,
// where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
// Find two lines, which together with x-axis forms a container,
// such that the container contains the most water.

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int maxlo = 0;
        int maxhi = 0;
        int startindex = 0;
        int endindex = height.length -1;
        while(startindex<endindex){
            maxlo = height[startindex];
            maxhi = height[endindex];
            int size = Integer.min(height[startindex],height[endindex])*(endindex-startindex);
            if(size>max)max= size;
            if(height[startindex]>height[endindex])
            while(endindex>startindex && height[--endindex] < maxhi);
            else
            while(startindex<endindex && height[++startindex] < maxlo);
            }
        return max;
    }
}
