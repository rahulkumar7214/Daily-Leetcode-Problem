/*3202. Find the Maximum Length of Valid Subsequence II
Date : 17-07-2025
*/
// ----------------------------------------------------Brute Force Method ---Gives TLE -----------------------------------------------------//
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int max =2;
        for(int i=0; i<n; i++){
            for(int j =i+1; j<n; j++){
                int cnt =2;
                int no = (nums[i]+nums[j])%k;
                int l = j+1;
                int prev = j;
                while(l<n){
                    if((nums[l]+nums[prev])%k == no){
                        cnt++;
                        prev = l;
                    }
                    l++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
// --------------------------------------> 2nd Method Using DP-MemoIzation-------  still Gives TLE------------------------>
class Solution {
    public int solve(int[] a, int currid, int previd, int k, int rem, int[][] dp){
        if(currid >= a.length){
            return 0;
        }
        if(previd != -1 && dp[currid][previd] != -1){
            return dp[currid][previd];
        }
        int t =0;
        int nt =0;
        if(previd ==-1 || (a[previd]+a[currid])%k==rem ){
            t = 1+ solve(a, currid+1, currid, k, rem, dp);
        }
        nt = 0+solve(a, currid+1, previd, k, rem, dp);

        if(previd != -1){
            dp[currid][previd] = Math.max(t, nt);
        }
        return Math.max(t, nt);
    }
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        
        for(int i =0; i<k; i++){
            int[][] dp= new int[n][n];
            for(int[] a: dp){
                Arrays.fill(a, -1);
            }
            max = Math.max(max, solve(nums, 0, -1, k, i, dp)); // arr, curidx, previdx, k, rem
        }
          
        return max;
    }
}
// --------------------------------------> 3nd Method Using DP-Tabulation(BOTTOM-UP)------------------------------->
class Solution {
    // need to see LIS before solving This
    // public int solve(int[] a, int currid, int previd, int k, int rem, int[][] dp){
    //     if(currid >= a.length){
    //         return 0;
    //     }
    //     if(previd != -1 && dp[currid][previd] != -1){
    //         return dp[currid][previd];

    //     }
    //     int t =0;
    //     int nt =0;

    //     if(previd ==-1 || (a[previd]+a[currid])%k==rem ){
    //         t = 1+ solve(a, currid+1, currid, k, rem, dp);
    //     }
    //     nt = 0+solve(a, currid+1, previd, k, rem, dp);

    //     if(previd != -1){
    //         dp[currid][previd] = Math.max(t, nt);
    //     }
    //     return Math.max(t, nt);

    // }
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[k][n];
        for(int[] a: dp){
            Arrays.fill(a, 1);
        }
        int maxsub = 0;
        for(int i=1; i<n; i++){
            for(int j =0; j<i; j++){
                int rem = (nums[i] + nums[j])%k;
                // the above was when we took diff arr for diff remainder(rem)
                
                //rem = 0 = 0th row , %2 = 0 waale case ka result
                //rem = 1 = 1st row, %2 = 1 waale case ka result
                dp[rem][i] = Math.max(dp[rem][i], dp[rem][j]+1);
                maxsub = Math.max(maxsub, dp[rem][i]);
            }
        }
        return maxsub;
    }
}
