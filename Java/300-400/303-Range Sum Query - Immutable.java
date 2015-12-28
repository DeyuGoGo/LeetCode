//先把每個位置的總和放上去之後，用大總和減小總和=區間總和
public class NumArray {
int[] nums;
int[] numSum;

public NumArray(int[] nums) {
    this.nums = nums;
    numSum = new int[nums.length + 1];
    numSum[0] = 0;
    for(int i = 1; i < numSum.length; i++){
        numSum[i] = numSum[i - 1] + nums[i - 1];
    }
}

public int sumRange(int i, int j) {
    if(i < 0 || j >= nums.length){
        return 0;
    }

    return numSum[j + 1] - numSum[i];
}
}
// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
