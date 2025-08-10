/*  808. Soup Servings
    Date: 08 Aug, 2025, marked=Medium             TC = 0(2n) SC = O(n)
*/

class Solution {
    Double dp[][];
    public double soupServings(int n) {
        // return 1.0;
        if(n>5000){
            return 1.0;
        }
        int units = (int) Math.ceil(n/25.0);
        dp= new Double[units+1][units+1];

        return solve(units , units);
    }

    public double solve(int sa, int sb){
        if(sa<=0 && sb<=0){
            return 0.5;
        }

        if(sa<=0){
            return 1.0;
        }
        if(sb <=0){
            return 0.0;
        }

        if(dp[sa][sb] != null){
            return dp[sa][sb];
        }

        double prob = 0.25*( solve(sa-4, sb) + solve(sa-3, sb-1) + solve(sa-2, sb-2) +solve(sa-1, sb-3));

        return dp[sa][sb] = prob;
        
    }
}