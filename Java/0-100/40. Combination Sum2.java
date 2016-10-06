// 39. Combination Sum
// QuestionEditorial Solution  My Submissions
// Total Accepted: 116151
// Total Submissions: 341751
// Difficulty: Medium
// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// The same repeated number may be chosen from C unlimited number of times.
//
// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [2, 3, 6, 7] and target 7,
// A solution set is:
// [
//   [7],
//   [2, 2, 3]
// ]

// 反正就是找出可能會成為target的組合。 我使用的是廣度搜尋法。
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates.length < 1 || candidates[0] > target){
            return result;
        }
        int tail = 1,head = 1;
        Map<Integer , Note> map = new HashMap<>();
        for(int i = 0 ; i < candidates.length && candidates[i] <= target ; i ++){
            if(i > 0 && candidates[i] == candidates[i-1])
            continue;
            map.put(tail,new Note(i , candidates[i] , candidates[i] , -1));
            tail++;
        }
        while(head<tail){
            Note n = map.get(head);
            if(n.sum == target){
                List<Integer> list = new ArrayList<>();
                while(true){
                    list.add(n.val);
                    if(n.f == -1)break;
                    n = map.get(n.f);
                }
                result.add(list);
                head++;
                continue;
            }
            for(int i = n.index + 1; i < candidates.length  ; i ++){
                if((n.sum + candidates[i]) > target)
                break;
                if(i > n.index + 1){
                    if(candidates[i] == candidates[i-1])
                    continue;
                }
                map.put(tail,new Note(i ,candidates[i] , n.sum + candidates[i], head));
                tail++;
            }
            head++;
        }
        return result;
    }
    private class Note{
        public int index = 0;
        public int sum = 0;
        public int val = 0;
        public int f = -1;
        public Note(int index,int val , int sum , int f){
            this.index = index;
            this.val = val;
            this.sum = sum ;
            this.f = f;
        }
    }
}
