/* 498. Diagonal Traverse
   Date : 25-08-2025  Marked---Medium
*/

// 1st way TC = O(M*N) SC = O(1)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        if(n ==0){
            return new int[0];
        }
        int[] res = new int[m*n];
        int r = 0;
        int c=0;
        for(int i=0; i<m*n; i++){
            res[i] = mat[r][c];
            if((r+c)%2 == 0){
                if(c==m-1){
                    r++;
                }else if(r==0){
                    c++;
                }else{
                    r--;
                    c++;
                }
            }else{
                if(r==n-1){
                    c++;
                }else if(c==0){
                    r++;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}

// 2nd way using hashmap
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Use HashMap to store diagonals
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Fill the map with diagonals
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }

        
        List<Integer> reslist = new ArrayList<>();
        
        for(int i =0; i<(m+n); i++){
            List<Integer> diag = map.get(i);
            if(diag == null){
                continue;
            }
            if(i%2==0){
                Collections.reverse(diag);
                
            }
            reslist.addAll(diag);
        }
        int[] res = new int[m*n];
        for(int i=0; i<reslist.size(); i++){
            res[i] = reslist.get(i);
        }
        return res;

    }
}