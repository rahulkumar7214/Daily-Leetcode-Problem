/*  2419. Longest Subarray With Maximum Bitwise AND
    Date: 30th July, 2025  Marked: Medium
*/
// ------------TC = O(N)  SC = O(1)
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int maxand = 0;
        for(int a: nums){
            maxand = Math.max(maxand, a);
        }
        int i=0;
        int maxlen = 0;
        while(i<n){
            int flag =0;

            if(nums[i] == maxand){
                int j = i+1;
                while(j<n && nums[j]==maxand){
                    j++;
                }
                maxlen = Math.max(maxlen, j-i);
                i =j;
                flag =1;
            }
            if(flag == 1){
                continue;
            }
            i++;
        }
        return maxlen;
    }
}