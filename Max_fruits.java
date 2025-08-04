/*  2106. Maximum Fruits Harvested After at Most K Steps
    Date: 03 Aug, 2025, marked=HARD  
*/

class Solution {
    public int lowerbound(int[] a, int tar){
        int l =0;
        int r = a.length;

        while(l<r){
            int m = (l+r)/2;

            if(a[m] <tar){
                l = m+1;
            }else{
                r = m;
            }
        }
        return l;
    }

    public int upperbound(int[] a, int tar){
        int l =0;
        int r = a.length;

        while(l<r){
            int m = (l+r)/2;
            if(a[m] <=tar){
                l = m+1;
            }else{
                r = m;
            }
        }
        return l;
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;

        // first compute prefisum arr and indexes arr in fruits
        int[] psum = new int[n];
        int[] indxarr = new int[n];

        for(int i=0; i<n; i++){
            indxarr[i] = fruits[i][0];
            psum[i] = fruits[i][1] + (i>0? psum[i-1]: 0);
        }

        // next compute both the cases to get max fruits
        int maxans =0;

        for(int d =0; d<=k/2; d++){

            // case 1   --- first going to left then right
            int i = startPos-d;    // i is for left step
            int rem = k-2*d; // step remins after returning from left to og posn
            int j = startPos+rem;      // j is for right step

            //then get the lower and upper bound for i and j through indexarr
            int left = lowerbound(indxarr, i);
            int right = upperbound(indxarr, j) -1;

            if (left <= right) {
                int total = psum[right] - (left > 0 ? psum[left - 1] : 0);
                maxans = Math.max(maxans, total);
            }

            // case 2 --- first going to right then left
            j = startPos+d;
            rem = k-2*d;
            i = startPos-rem;

            left = lowerbound(indxarr, i);
            right = upperbound(indxarr, j) -1;

            if (left <= right) {
                int total = psum[right] - (left > 0 ? psum[left - 1] : 0);
                maxans = Math.max(maxans, total);
            }
        }

        return maxans;
    }
}