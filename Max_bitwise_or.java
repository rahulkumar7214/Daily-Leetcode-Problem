/*  2411. Smallest Subarrays With Maximum Bitwise OR
    Date: 29th July, 2025  Marked: Medium
*/

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        // observation -- har ek nums[i] ka binary representation hai uske har ek bit ko 1 krne to maximize and to set each bit 1, we have to OR element till a particular idx that form subarray-----------------refer codestorywithMIK video fro best explanation

        int n = nums.length;

        int[] setbitidx = new int[32];   // to store the index which set the jth bit in binary representation of nums[i]
        Arrays.fill(setbitidx, -1); 
        int[] ans = new int[n]; 

        for(int i=n-1; i>=0; i--){
            int endidx = i;   
            for(int j=0; j<32; j++){
                // check whether the jth bit is set in nums[i]
                if((nums[i] &(1<<j)) == 0){    // if jth bit not set then we will find the idx which can set the jth bit
                    if(setbitidx[j] != -1){
                        endidx = Math.max(endidx, setbitidx[j]);
                    }
                }else {   //  if jth idx is set in the nums[i] then we will update the setbitidx arr-- at jth bit 
                    setbitidx[j] = i; // this mean the ele at i can set the jth bit 
                }
            }
            ans[i] = endidx-i+1;
        }
        return ans;
    }
}