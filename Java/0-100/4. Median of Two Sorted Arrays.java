// There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

// Subscribe to see which companies asked this question
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length ==1 && nums2.length==1){
            return (nums1[0]+nums2[0])/2.0;
        }

        int totallength = nums1.length + nums2.length;
        int midian = totallength/2;
        boolean is1big = nums1.length > nums2.length;
        int[] big =is1big?nums1 :nums2;
        int[] small =!is1big?nums1 :nums2;
        int a = 0;
        int b = 0 ;
        //
        if(small.length==0){
            if(totallength%2!=0)
            return big[midian];
            if(totallength<2)
            return big[midian];
            return (big[midian-1]+big[midian])/2.0;
        }

        //

        if(totallength%2==0){
            midian--;
        }
        //

        for(int i = midian ; i>=0 ; i--){
            int index = midian - i;
            if(index>=small.length)
            break;
            if(big[i] <= small[index]){

                if(index==0)
                a = big[i];
                else
                a = big[i] > small[index-1] ? big[i] : small[index-1];
                if(totallength%2!=0)
                return a;

                if(i == (big.length-1))
                b= small[index];
                else
                b = big[i+1] > small[index] ?  small[index] : big[i+1];
                return (a+b)/2.0;
            }
        }

        int ppin = midian-small.length >= 0 ? midian-small.length:0;
        int ss = small[small.length-1] > big[ppin] ? small[small.length-1] : big[ppin];
        if(totallength%2!=0){
            if(big[ppin+1]>=small[small.length-1])
                return big[ppin] > small[small.length-1] ? big[ppin]:small[small.length-1];
            return ss;
        }
        int gogo = ss==big[midian+1-small.length]?small[small.length-1] : big[midian+1-small.length];
        return (ss+gogo)/2.0;
    }
}
