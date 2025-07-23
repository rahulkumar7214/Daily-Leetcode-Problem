/*1717. Maximum Score From Removing Substrings
Date : 23-07-2025
link : https://leetcode.com/problems/maximum-score-from-removing-substrings?envType=daily-question&envId=2025-07-23
*/

// ----------------------------------1st method ---------------------------->
// T.C= O(2n);
//S.C = O(n)
class Solution {
    public int maximumGain(String s, int x, int y) {
        
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int i=0;
        int score =0;
        if(x>y){
            while(i < n-1){
                if(i==-1){
                    i=0;
                }
                if(sb.charAt(i)=='a' && sb.charAt(i+1)=='b'){
                    score+=x;
                    sb.delete(i, i+2);
                    i--;
                    n = sb.length();
                }else{
                    i++;
                }
            }
            int j=0;
            int m = sb.length();
            while(j < m-1){
                if(j == -1){
                    j=0;
                }
                if(sb.charAt(j)=='b' && sb.charAt(j+1)=='a'){
                    score+=y;
                    sb.delete(j, j+2);
                    j--;
                    m = sb.length();
                }else{
                    j++;
                }
            }
        }else{
            while(i < n-1){
                if(i==-1){
                    i=0;
                }
                if(sb.charAt(i)=='b' && sb.charAt(i+1)=='a'){
                    score+=y;
                    sb.delete(i, i+2);
                    i--;
                    n = sb.length();
                }else{
                    i++;
                }
            }
            int j=0;
            int m = sb.length();
            while(j < m-1){
                if(j == -1){
                    j=0;
                }
                if(sb.charAt(j)=='a' && sb.charAt(j+1)=='b'){
                    score+=x;
                    sb.delete(j, j+2);
                    j--;
                    m = sb.length();
                }else{
                    j++;
                }
            }
        }
        return score;
    }
}


// --------------------------------2nd Method ------------------------------->
// TC= O(n);
// SC = O(n);
class Solution {
    public String removestr(String s, String match){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && match.charAt(1)==ch && st.peek()==match.charAt(0)){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        String maxstr = x>=y? "ab":"ba";    // store the max and min str based on x and y
        String minstr = x<y? "ab": "ba";

        String rem_str = removestr(s, maxstr);   // remove the maxval string from input string and receive the remaining string
        int removed_str_len = (n-rem_str.length())/2;  // str are removed in pair("ab" or "ba") so divide by 2
        int score = Math.max(x,y)*removed_str_len;   // then finally get score 

        // same step as prev
        String sec = removestr(rem_str, minstr);
        int rem_len1 = (rem_str.length()-sec.length())/2;
        score += (Math.min(x, y)*rem_len1);

        return score;
    }
}

// ---------------------------------------------->3rd Method<-----------------------------------
// tc =o(n) and sc = o(1)
class Solution {
    public String removepair2(String s, String matchstr){
        StringBuilder sb = new StringBuilder();
        int j=0;

        for(int i=0; i<s.length(); i++){

            sb.append(s.charAt(i));
            j++;
            if(j>1 && sb.charAt(j-2) == matchstr.charAt(0) && sb.charAt(j-1) == matchstr.charAt(1)){
                sb.delete(j-2, j);// here  j is excluding
                j-=2;
            }
        }
        return sb.toString();
    }
    public int maximumGain(String s, int x, int y) {
        int score =0;
        int n = s.length();
        String maxstr = (x>y)? "ab":"ba";
        String minstr = (x<y)? "ab":"ba";

        //1st pass to remove the pair with max no
        String first = removepair2(s,maxstr);
        int removedpair = (n-first.length())/2;
        score += removedpair*Math.max(x,y);

        //2nd passto remove the pair with min no
        String second = removepair2(first,minstr);
        removedpair = (first.length()-second.length())/2;
        score += removedpair*Math.min(x,y);

        return score;
    }
} 