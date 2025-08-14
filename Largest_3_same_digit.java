/*  326. Power of Three
    Date : 14-08-2025  Marked---Easy     
*/

class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int max =-1;
        String ans ="";
        int cnt =1;

        for(int i=1; i<n; i++){
            if(num.charAt(i-1) == num.charAt(i)){
                cnt++;
            }else{
                if(cnt>=3){
                    int no = num.charAt(i-1)-'0';
                    max = Math.max(max, no);
                }
                cnt =1;
            }
        }
        if(cnt>=3){
            int no = num.charAt(n-1)-'0';
            max = Math.max(max, no);
        }
        if(max==-1){
            return ans;
        }
        String m = Integer.toString(max);
        ans+=m;
        ans+=m;
        ans+=m;
        return ans;
    }
}