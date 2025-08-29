/* 3021. Alice and Bob Playing Flower Game
   Date : 29-08-2025  Marked---MEDIUM
*/
class Solution {
    
    public long flowerGame(int n, int m) {
        //------------------------------->>>way 1
        // long cnt = 0;
        // for(int i=1; i<=n; i++){
        //     for(int j =1; j<=m; j++){
        //         if((i+j)%2==0){
        //             continue;
        //         }else{
        //             cnt++;
        //         }
        //     }
        // }

        // return cnt;    way2 ---->>one liner

        // long ans = (long) n*m/2;
        // return ans;

        //---------------------------------------->>>3rd way

        //Count odds and evens in range [1, n]
        long oddx = (n+1)/2;
        long evenx = n/2;

        // Count odds and evens in range [1, m]
        long oddy = (m+1)/2;
        long eveny = m/2;

        // Alice wins when x+y is odd 
        // Case 1: x odd & y even
        // Case 2: x even & y odd

        return (oddx*eveny)+(evenx*oddy);
    }
}