/*  342. Power of Four
    Date: 04 Aug, 2025, marked=Easy 
*/
class Solution {
    public boolean isPowerOfFour(int n) {
        double x = Math.log10(n)/Math.log10(4);
        int y = (int)(x);

        if(x==y){
            return true;
        }
        return false;
    }
}