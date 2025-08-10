/* 869. Reordered Power of 2 
    Date : 10-08-2025  Marked---Medium     
*/

class Solution {
    public String getsortedstr(int n){
        String s = Integer.toString(n);

        if(s.length() ==1){
            return s;
        }
        char[] a = s.toCharArray();
        Arrays.sort(a);

        String str = new String(a);
        return str;
    }
    public boolean reorderedPowerOf2(int n) {
        
        String s = getsortedstr(n);

        for(int p =0; p<30; p++){

            if(s.equals(getsortedstr(1<<p)) ){
                return true;
            }
        }
        return false;
    }
}