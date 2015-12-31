// Given an array of integers, find two numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
// You may assume that each input would have exactly one solution.
//
// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2
// 第一種方法
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int s = 0; s < nums.length ; s ++){
            int diff = target - nums[s];
            for(int k = s + 1 ; k < nums.length ; k ++){
                if(diff ==nums[k]){
                    int[] result = new int[2];
                    result[0] = s+1;
                    result[1] = k+1;
                    return result;
                }
            }
        }
        return null;
    }
}
// 第二種方法，把差放進去map 然後去找尋map
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
         for(int i = 0 ; i < nums.length; i ++){
            if(map.get(nums[i])==null){
            map.put(target-nums[i] , i);
            continue;
            }
            return new int[]{map.get(nums[i]) + 1,i+1};
        }
        return null;
    }
}
