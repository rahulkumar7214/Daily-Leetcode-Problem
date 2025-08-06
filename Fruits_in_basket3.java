/* 3479. Fruits Into Baskets III 
    Date : 06-08-2025  Marked---Medium     
*/

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        ArrayList<Integer> al = new ArrayList<>();    // basically to store the max val of each sector
        int n = fruits.length;
        int m = baskets.length;
        int a = (int) Math.sqrt(m);
        int cnt =0;
        int max =0;
        for(int i=0; i<m; i++){
            if(cnt == a){           // if cnt == a i.e size of one sector
                al.add(max);
                max =baskets[i];
                cnt =1;
            }else{
                max = Math.max(max, baskets[i]);
                cnt++;
            }
        }
        al.add(max);       // adding for the last sector
        int remain =0;
        // now find left fruit whic cant be placed
        for(int i=0; i<n; i++){
            int k =0;       // it is for tracing the idx of sector in al
            int flag =1;   // to check whether we find any valid idx for fruits[i]

            for(int j =0; j<m; j+=a){    // here j+=a bcz we divided it into sector i.e 1sect size = sqrt(m) m=basket.len
                if(al.get(k) < fruits[i]){
                    k++;
                    continue;
                }
                //we reached to valid sector , now lets find the valid index
                for(int r=j; r<Math.min(j+a, m); r++){
                    if(baskets[r] >= fruits[i]){
                        baskets[r]=0;
                        flag =0;
                        break;
                    }
                }
                // now lets find the new maxele for the sector in which fuits[i] has got the valid index to be placed
                if(flag ==0){
                    al.set(k,0);  // update the max
                    for(int r = j; r<Math.min(j+a, m); r++){
                        al.set(k, Math.max(baskets[r], al.get(k)));
                    }
                    break;
                }
            }
            remain += flag;
        }
        return remain;
    }
}