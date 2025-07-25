/*  3487. Maximum Unique Subarray Sum After Deletion
    Date: 25th July, 2025, Tuesday
*/
class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int cntp=0;
        int negmax =Integer.MIN_VALUE;

        for(int no : nums){
            if(!hs.contains(no)){
                if(no>0){
                    cntp+=no;
                }else{
                    negmax = Math.max(negmax, no);
                }
                
            }
            hs.add(no);
        }

        if(cntp==0){
            return negmax;
        }
        return cntp;
    }
}