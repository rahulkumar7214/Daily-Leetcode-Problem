/*  1493. Longest Subarray of 1's After Deleting One Element
    Date : 20-07-2025  Marked---Medium   TC= O(2N)

*/
class Solution {
    public int longestSubarray(int[] nums) {
        int cntone =0;
        int cntz =0;
        int i=0;
        int j =0;
        int n = nums.length;
        int max =0;
        while(j<n){
            if (nums[j] == 1) {
                cntone++;
            } else {
                cntz++;
            }
            max = Math.max(max, cntone);

            while(i<n && cntz>1){
                if (nums[i] == 1) {
                    cntone--;
                } else {
                    cntz--;
                }
                i++;
            }
            j++;
        }   
        if(max == n){
            return max-1;
        }
        return max;
    }
}