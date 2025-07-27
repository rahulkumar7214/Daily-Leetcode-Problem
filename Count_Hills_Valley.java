/*2210. Count Hills and Valleys in an Array
Date : 27-07-2025  Marked---Easy
*/

class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int i =0;
        int j =1;
        int cnt =0;

        while(j<n-1){

            if((nums[j] >nums[i] && nums[j] > nums[j+1]) || (nums[j] <nums[i] && nums[j] < nums[j+1])){
                cnt++;
                i =j;
            }
            j++;
        }
        return cnt;
    }
}