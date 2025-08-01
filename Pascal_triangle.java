/*118. Pascal's Triangle
Date : 01-08-2025  Marked---Easy
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> al = new ArrayList<>();

        List<Integer> al1 = new ArrayList<>();
        al1.add(1);
        al.add(al1);

        if(numRows == 1){
            return al;
        }else{

            for(int i=2; i<=numRows; i++){
                List<Integer> alin = new ArrayList<>();

                for(int j =0; j<i; j++){
                    if(j ==0 || j== i-1){
                        alin.add(1);
                    }else{
                        int ele1 = al.get(al.size()-1).get(j-1);
                        int ele2 = al.get(al.size()-1).get(j);
                        alin.add(ele1+ele2);
                    }
                }
                al.add(alin);
            }
        }

        return al;
    }
}