/*2044. Count Number of Maximum Bitwise-OR Subsets
Date : 28-07-2025  Marked---Medium
*/

// -----------------------------------------------------1st method -- using Recursion --TC = O(2^n)--SC = O(1)----------------------------------
class Solution {
    public int solve(int[] a, int max, int id, int or_val){
        if(id>=a.length){
            if(or_val == max){
                return 1;
            }
            return 0;
        }
        int t = solve(a, max, id+1, or_val|a[id]);
        int nt = solve(a, max, id+1, or_val);
        return t+nt;
    }
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxbitwiseOr = 0;
        for(int a: nums){
            maxbitwiseOr = maxbitwiseOr|a;
        }
        int ans = solve(nums, maxbitwiseOr, 0, 0);
        return ans;
    }
}


// -----------------------------------------------------2nd method -- using Recursion(memoization) --TC =  O(n*maxOr)--SC = O(1)----------------------------------
class Solution {
    public int solve(int[] a, int max, int id, int or_val, int[][] dp){
        if(id>=a.length){
            if(or_val == max){
                return 1;
            }
            return 0;
        }

        if(dp[id][or_val] != -1){
            return dp[id][or_val];
        }

        int t = solve(a, max, id+1, or_val|a[id], dp);
        int nt = solve(a, max, id+1, or_val, dp);

        return dp[id][or_val] = t+nt;
    }
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxbitwiseOr = 0;
        for(int a: nums){
            maxbitwiseOr = maxbitwiseOr|a;
        }
        // memoize
        int[][] dp = new int[n+1][maxbitwiseOr+1];
        for(int[] ar: dp){
            Arrays.fill(ar, -1);
        }
        int ans = solve(nums, maxbitwiseOr, 0, 0, dp);
        return ans;
    }
}