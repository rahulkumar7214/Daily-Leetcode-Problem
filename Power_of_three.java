/*  326. Power of Three
    Date : 13-08-2025  Marked---Easy     
*/

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        if( n == 1){
            return true;
        }
        
        // int no =n;
        // while(no>1){
        //     if((no%3) != 0){
        //         return false;
        //     }
        //     no = no/3;
        // }
        // return true;

        double x = Math.log10(n)/Math.log10(3);
        int y = (int)(x);

        if(x==y){
            return true;
        }
        return false;
    }
}