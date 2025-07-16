
// leet -3201. Find the Maximum Length of Valid Subsequence I

class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        // everything was about odd and even
        //by doing %2 we will either get 0 or 1, so
        // case 1==>  take all even which will give (prev+curr) % 2 == 0
        //case 2 ==> take all odd which will also give (prev+curr) % 2 == 0

        //case 3 ==> take alternatively odd-even or even-odd ehich will give (prev+curr) % 2 == 1

        // 1st way--
        // int od =0;
        // int ev = 0;
        // int od_ev =0; int oe_prev =-1;  // if prev val was even then oe_prev = 0 else 1
        // int ev_od =0; int eo_prev =-1;   //if prev val was even then eo_prev = 0 else 1

        for(int i=0; i<n; i++){
            // case1
            if(nums[i]%2 == 0){
                ev++;
                if(eo_prev == 1 || eo_prev ==-1){
                    ev_od++;
                    eo_prev=0;
                }

                if(oe_prev == 1){
                    od_ev++;
                    oe_prev=0;
                }

            }else{
                od++;
                if(oe_prev == 0 || oe_prev ==-1){
                    od_ev++;
                    oe_prev = 1;
                }

                if(eo_prev == 0){
                    ev_od++;
                    eo_prev=1;
                }

            }
        }
        int max = Math.max(od, Math.max(ev, Math.max(od_ev, ev_od)));
        return max;


        // 2nd way   -- keeping it short and clear
        int ev = 0, od = 0;
        for (int num : nums) {
            if (num % 2 == 0) 
                ev++;
            else 
                od++;
        }

        int len = 1; // At least one number
        int prevParity = nums[0]%2;

        for (int i = 1; i < nums.length; ++i) {
            int currParity = nums[i] % 2;
            if (currParity != prevParity) {
                len++;
                prevParity = currParity;
            }
        }
        return Math.max(Math.max(ev, od), len);
    }
    
}
