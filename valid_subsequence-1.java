
/* leet -3201. Find the Maximum Length of Valid Subsequence I */

/* ----------------------------------------------------------------------method 1-- > by simple Observation */
class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        // everything was about odd and even
        //by doing %2 we will either get 0 or 1, so
        // case 1==>  take all even which will give (prev+curr) % 2 == 0
        //case 2 ==> take all odd which will also give (prev+curr) % 2 == 0

        //case 3 ==> take alternatively odd-even or even-odd ehich will give (prev+curr) % 2 == 1

        // 1st way--
        // int od =0;
        // int ev = 0;
        // int od_ev =0; int oe_prev =-1;  // if prev val was even then oe_prev = 0 else 1
        // int ev_od =0; int eo_prev =-1;   //if prev val was even then eo_prev = 0 else 1

        for(int i=0; i<n; i++){
            // case1
            if(nums[i]%2 == 0){
                ev++;
                if(eo_prev == 1 || eo_prev ==-1){
                    ev_od++;
                    eo_prev=0;
                }
                if(oe_prev == 1){
                    od_ev++;
                    oe_prev=0;
                }
            }else{
                od++;
                if(oe_prev == 0 || oe_prev ==-1){
                    od_ev++;
                    oe_prev = 1;
                }
                if(eo_prev == 0){
                    ev_od++;
                    eo_prev=1;
                }
            }
        }
        int max = Math.max(od, Math.max(ev, Math.max(od_ev, ev_od)));
        return max;
        // 2nd way   -- keeping it short and clear
        int ev = 0, od = 0;
        for (int num : nums) {
            if (num % 2 == 0) 
                ev++;
            else 
                od++;
        }
        int len = 1; // At least one number
        int prevParity = nums[0]%2;
        for (int i = 1; i < nums.length; ++i) {
            int currParity = nums[i] % 2;
            if (currParity != prevParity) {
                len++;
                prevParity = currParity;
            }
        }
        return Math.max(Math.max(ev, od), len);
    }
}
/* ----------------------------------------------------- 2nd method DP method
---> it will Give TLE because constarint in this problem is (2 <= nums.length <= 2 * 105) , but it is helpfull for solving this problem part-II
----------------> before using this approach see LIS(tabulation form- Bottom up) leet->300 
------------------>it is a variant of LIS problem of the dp
*/  
class Solution {
    
    public int maximumLength(int[] nums) {
        int n  = nums.length;

        // int[] dp1 = new int[n];  // for rem 1
        // Arrays.fill(dp1, 1);   // initially sabhi ka subsequence to 1 hi rhega
        
        // int[] dp0 = new int[n];// for rem 0
        // Arrays.fill(dp0, 1);

        // instead of taking two diff dp array we can take a 2d arr this will help in   
        // to cover various rem not only for '2'
        // i.e it will help in problem (leet 3202) its second version

        int[][] dp = new int[2][n];
        for(int[] a: dp){
            Arrays.fill(a, 1);   // initially sabhi ka subsequence to 1 hi rhega
        }

        int maxsub = 0;

        for(int i=1; i<n; i++){
            for(int j =0; j<i; j++){

                int rem = (nums[i] + nums[j])%2;

                // if(rem == 1){
                //     dp1[i] = Math.max(dp1[i], dp1[j]+1);
                //     maxsub = Math.max(maxsub, dp1[i]);
                // }else{
                //     dp0[i] = Math.max(dp0[i], dp0[j]+1);
                //     maxsub = Math.max(maxsub, dp0[i]);
                // }
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
