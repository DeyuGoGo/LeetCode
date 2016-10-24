// 47. Permutations II   QuestionEditorial Solution  My Submissions
// Total Accepted: 91657
// Total Submissions: 304016
// Difficulty: Medium
// Contributors: Admin
// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// For example,
// [1,1,2] have the following unique permutations:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

// 大數字字串的乘法，利用陣列跟數學計算法邏輯慢慢一步一步完成。
public class Solution {
     List<List<Integer>> result = new ArrayList<>();
     Map<String,Boolean> mMap = new HashMap<>();
     int[] a ;
     int[] book;
     int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        a = new int[nums.length];
        book = new int[nums.length];
        Arrays.sort(nums);
        dfs(0);
        return result;
    }
    private void dfs(int step){
        if(step == nums.length){
            List<Integer> l = new ArrayList<>();
            System.out.println(Arrays.toString(a));
            for(int tp : a)
            l.add(tp);
            result.add(l);

            return;
        }

        for(int i = 0 ; i < nums.length ; i++ ){
            if(book[i]==1)continue;
            if(i>0 &&nums[i-1]==nums[i] && book[i-1] == 0) continue;
            a[step] = nums[i];
            book[i] = 1;
            dfs(step+1);
            book[i]=0;
        }
        return ;
    }
}
