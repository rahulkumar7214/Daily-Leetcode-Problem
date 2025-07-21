/*1957. Delete Characters to Make Fancy String
Date : 20-07-2025  Marked---Easy
*/

class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        if(n<3){
            return s;
        }
        char c = s.charAt(0);
        int count = 1;
        sb.append(c);

        for(int i=1; i<n; i++){
            if(s.charAt(i) == c){
                count++;
                if(count <3){
                    sb.append(s.charAt(i));
                }
            }else{
                c = s.charAt(i);
                sb.append(s.charAt(i));
                count =1;
            }
        }
        return sb.toString();
    }
}