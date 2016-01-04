// Given a string, find the length of the longest substring without repeating characters.
// For example, the longest substring without repeating letters
// for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the
// longest substring is "b", with the length of 1.
// My solution but peference not good
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0 ,temp = 0 , index = 0;
        HashMap<Character , Integer> map = new HashMap<Character , Integer>();
        char[] chars = s.toCharArray();
        int i = 0;
        for(;;){
            if(i>= chars.length)
            return max;
            if(map.get(chars[i])!=null){
                temp=0;
                i=index;
                map.clear();
                index++;
            }
            map.put(chars[i],1);
            temp+=1;
            if(temp > max)
            max = temp;
            i++;
        }
    }
}
