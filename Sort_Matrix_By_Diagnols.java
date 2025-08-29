/* 3446. Sort Matrix by Diagonals
   Date : 28-08-2025  Marked---MEDIUM
*/

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] mat = new int[n][m];

        int i=0;
        int j=m-1;

        while(i<n && j<m){
            ArrayList<Integer> al = new ArrayList<>();
            int i_= i;
            int j_ = j;

            while(i_<n && j_<m){
                al.add(grid[i_][j_]);
                i_++;
                j_++;
            }
            Collections.sort(al);
            i_=i;
            j_=j;
            if(j>0){
                for(int id =0; id<al.size(); id++){
                    mat[i_][j_] = al.get(id);
                    i_++;
                    j_++;
                }
            }else{
                for(int id = al.size()-1; id>=0; id--){
                    mat[i_][j_] = al.get(id);
                    i_++;
                    j_++;
                }
            }
            if(j==0){
                i++;
            }else{
                j--;
            }
        }
        return mat;  
    }
}