/*  2438. Range Product Queries of Powers
    Date : 11-08-2025  Marked---Medium     
*/

class Solution {
    int mod = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer> pow = new ArrayList<>();
        // compute powers arr
        for(int i=0; i<32; i++){      //those bits are set in 'n' they will get stored in pow
            if( (n& (1<<i)) != 0){  // means ith bit is set in the n
                pow.add(1<<i);
            }
        }
        int ans[] = new int[queries.length];
        int id =0;
        for(int[] a: queries){
            int st = a[0];
            int en = a[1];

            long prod = 1;
            for(int i=st; i<=en; i++){
                prod = (prod*pow.get(i)) %mod;
            }
            ans[id++] = (int)prod;
        }
        return ans;
    }
}