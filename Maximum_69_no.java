/*
    1323. Maximum 69 Number
    Date : 16-08-2025  Marked---Easy
*/

class Solution {
    public int maximum69Number (int num) {
    
        String s = Integer.toString(num);

        String ans = "";
        int flag = 0;
        int n = s.length();
        
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '6' && flag ==0){
                ans += '9';
                flag =1;
            }else{
                ans += (s.charAt(i));
            }
        }
        
        return Integer.parseInt(ans);
    }
}