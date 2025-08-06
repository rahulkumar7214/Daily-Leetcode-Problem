/*  3477. Fruits Into Baskets II
    Date: 06 Aug, 2025, marked=Easy             TC = 0(n^2) SC = O(1)
*/
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int m = baskets.length;
        int cnt =0;
        for(int i=0; i<n; i++){
            int flag =0;
            for(int j=0; j<m; j++){
                if(baskets[j]!= -1 && baskets[j] >= fruits[i]){
                    baskets[j] = -1;
                    flag =1;
                    break;
                }
            }
            if(flag == 0){
                cnt++;
            }
        }
        return cnt;
    }
}