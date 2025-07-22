/*  Leetocde-1695. Maximum Erasure Value
    Date: 22th July, 2025, Tuesday
*/ 

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;

        int i=0;
        int j =0;
        HashSet<Integer> hs = new HashSet<>();
        int sum =0;
        int max = 0;
        while(j<n){
            int curr = nums[j];

            while( i<j && hs.contains(curr)){
                sum -= nums[i];
                hs.remove(nums[i]);
                i++;
            }
            hs.add(curr);
            sum+=curr;
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }
}