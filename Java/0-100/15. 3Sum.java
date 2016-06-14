// 15. 3Sum My Submissions Question
// Total Accepted: 100996 Total Submissions: 554289 Difficulty: Medium
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets.

// For example, given array S = {-1 0 1 2 -1 -4},
//
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)

// My stupid method 36ms
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<Integer> li1 = new ArrayList<Integer>();
        ArrayList<Integer> li2 = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int n : nums){
            if(n>=0)li1.add(n);
            else li2.add(n);
        }
        Collections.sort(li2, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(li1, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int ltt1 = -1;
        int ltt2 = 1;
        if(li1.size()>2){
            if(li1.get(2) ==0){
               List<Integer> zero = new ArrayList<Integer>();
               zero.add(0);
               zero.add(0);
               zero.add(0);
               result.add(zero);
            }
        }
        for(int i = 0 ; i < li1.size() ; i++){
            int n1 = li1.get(i);
            if(n1==ltt1)continue;
            ltt1=n1;
            ltt2 = 1;
            for(int k = 0 ; k < li2.size() ; k++){
                int n2 = li2.get(k);
                if(n2==ltt2)continue;
                ltt2=n2;
                int compare = n1 + n2;
                int index = compare > 0 ? k+1 : i+1;
                List<Integer> checklist = compare > 0 ? li2 :li1;
                if(index == checklist.size())
                continue;
                int ltt3 = checklist.get(index) -1;
                for(int j = index ; j < checklist.size();j++){
                    int n3 = checklist.get(j);
                    if(n3==ltt3)continue;
                    ltt3=n3;
                    int sum = compare + n3;
                    if(compare > 0){
                     if(sum<0)
                     break;
                    }
                    if(compare < 0){
                     if(sum>0)
                     break;
                    }
                    if(sum ==0){
                        List<Integer> p = new ArrayList<Integer>();
                        p.add(n1);
                        p.add(n2);
                        p.add(n3);
                        Collections.sort(p, new Comparator<Integer>(){
                             @Override
                             public int compare(Integer o1, Integer o2) {
                                 return o1 - o2;

                             }
                         });
                        result.add(p);
                    }
                }
            }
        }
        Collections.sort(result, new Comparator<List<Integer>>(){
                             @Override
                             public int compare(List<Integer> o1, List<Integer> o2) {
                                 return o1.get(0) - o2.get(0);

                             }
                         });
        return result;
    }
}

// Internet Java solution

// Hi guys!
//
// The idea is to sort an input array and then run through all indices of a possible first element of a triplet. For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.

public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>();
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}
