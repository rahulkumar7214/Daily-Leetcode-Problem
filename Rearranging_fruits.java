/*  2561. Rearranging Fruits
    Date: 2nd Aug, 2025, marked: HARD   
*/

// ------------------------------------>1st Way Gives TLE------------>

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n1 = basket1.length;
        int n2 = basket2.length;
        HashMap<Integer,Integer>m1 = new HashMap<>();
        HashMap<Integer,Integer>m2 = new HashMap<>();
        int minele = Integer.MAX_VALUE;
        for(int i=0; i<n1; i++){
            minele = Math.min(minele, Math.min(basket1[i], basket2[i]));
            m1.put(basket1[i], m1.getOrDefault(basket1[i], 0)+1);
            m2.put(basket2[i], m2.getOrDefault(basket2[i], 0)+1);
        }
        ArrayList<Integer> al1= new ArrayList<>();
        int flag =0;
        for(int i=0; i<n1; i++){  // iteratinng over b1
            if(!al1.contains(basket1[i])){
                int total =0;
                if(m1.containsKey(basket1[i])){
                    total += m1.get(basket1[i]);
                }
                if(m2.containsKey(basket1[i])){
                    total += m2.get(basket1[i]);
                }
                if(total%2 != 0){
                    flag =1;
                    break;
                }
                //now extra 
                int extra1 = 0;  // extra currele in b1
                int extra2 =0;  // extra currele in b2
                if(m1.containsKey(basket1[i])){
                    extra1 = m1.get(basket1[i])-(total/2);
                }
                if(m2.containsKey(basket1[i])){
                    extra2 = m2.get(basket1[i])-(total/2);
                }
                while(extra1>0){
                    al1.add(basket1[i]);
                    extra1--;
                }
                while(extra2>0){
                    al1.add(basket1[i]);
                    extra2--;
                }
            }
        }
        if(flag ==1){
            return -1;
        }
        int flag2 =0;
        for(int i=0; i<n2; i++){  // iteratinng over b2
            if(!al1.contains(basket2[i]) ){
                int total =0;
                if(m1.containsKey(basket2[i])){
                    total += m1.get(basket2[i]);
                }
                if(m2.containsKey(basket2[i])){
                    total += m2.get(basket2[i]);
                }
                if(total%2 != 0){
                    flag2 =1;
                    break;
                }
                int extra1 = 0;  // extra currele in b1
                int extra2 =0;  // extra currele in b2
                if(m1.containsKey(basket2[i])){
                    extra1 = m1.get(basket2[i])-(total/2);
                }
                if(m2.containsKey(basket2[i])){
                    extra2 = m2.get(basket2[i])-(total/2);
                }
                while(extra1>0){
                    al1.add(basket2[i]);
                    extra1--;
                }
                while(extra2>0){
                    al1.add(basket2[i]);
                    extra2--;
                }
            }
        }
        if(flag2 ==1){
            return -1;
        }
        Collections.sort(al1);
        long cost =0;
        for(int i=0; i<al1.size()/2; i++){
            cost += Math.min(al1.get(i), minele+minele);
        }
        return cost;
    }
}
//---------------------------------->Most important observation TestCase
// basket2 =[32,32,42,68,68,100,42,84,14,8]
// basket1 =[84,80,43,8,80,88,43,14,100,88]  out = 48 
// explaination:You can do it like this: min(80, 8) = 8; min(8, 32) = 8; min(88, 8) = 8; min(8, 42) = 8; min(43, 8) = 8; min(8, 68) = 8.
// Here, the total cost is 6 × 8 = 48. By repeatedly using the smallest number from both sides, you can achieve this.

//-------------------------------------2ND Way--------- TC = O(n) and SC = O(n)------------------------->>>>>>>>>>
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        
        HashMap<Integer,Integer>map = new HashMap<>();
        int minele =Integer.MAX_VALUE;

        for(int i=0; i<n; i++){

            map.put(basket1[i], map.getOrDefault(basket1[i], 0)+1);
            map.put(basket2[i], map.getOrDefault(basket2[i], 0)-1);
            minele = Math.min(minele, Math.min(basket1[i], basket2[i]));
        }

        ArrayList<Integer> al= new ArrayList<>();  // store all no need to be swapped

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int cost = entry.getKey();
            int freq = entry.getValue();

            if(freq == 0){
                continue;
            }

            if(freq%2 != 0){
                return -1;
            }
            freq = Math.abs(freq);
            for(int i=1; i<=freq/2; i++){
                al.add(cost);
            }
        }

        Collections.sort(al);

        long ans =0;
        for(int i=0; i<al.size()/2; i++){
            ans += Math.min(al.get(i), minele*2); // here i took 2minele bcz  if we will use minele to swap we need to place it back to original basket 
        }
        return ans;
    }
}