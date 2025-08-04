/*  904. Fruit Into Baskets
    Date: 04 Aug, 2025, marked=Medium             TC = 0(2n) SC = O(n)
*/
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int i =0;
        int j =0;
        
        int cnt =0;
        int max =0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        

        while(j<n){
            hm.put(fruits[j], hm.getOrDefault(fruits[j], 0)+1);

            while(i<j && hm.size()>2){
               
                hm.put(fruits[i], hm.getOrDefault(fruits[i], 0)-1);

                if(hm.get(fruits[i]) <=0){
                    hm.remove(fruits[i]);
                }
                cnt-=1;
                i++;
            }

            cnt++;
            max = Math.max(max, cnt);
            j++;
        }

        return max;
    }
}