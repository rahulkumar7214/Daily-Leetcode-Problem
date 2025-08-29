/* 3000. Maximum Area of Longest Diagonal Rectangle
   Date : 26-08-2025  Marked---Easy
*/

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int m = dimensions[0].length;

        double diag = 0.0;
        int maxarea = 0;
        for(int i=0; i<n; i++){
            int l = dimensions[i][0];
            int b = dimensions[i][1];

            double di = Math.sqrt((l*l)+(b*b));
            if(di >= diag){
                
                if(di==diag){
                    maxarea = Math.max(maxarea,l*b);
                }else{
                    maxarea = l*b;
                }
                diag = di;
            }
        }
        return maxarea;

        // 2nd way
        // int maxArea = 0, maxDiag = 0;

        // for (int i = 0; i < n; i++) {
        //     int l = dimensions[i][0];
        //     int w = dimensions[i][1];
        //     int currDiag = l * l + w * w;

        //     if (currDiag > maxDiag || (currDiag == maxDiag && l * w > maxArea)) {
        //         maxDiag = currDiag;
        //         maxArea = l * w;
        //     }
        // }
        // return maxArea;
    }
}