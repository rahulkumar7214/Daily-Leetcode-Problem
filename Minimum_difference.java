/*  Leetcode- 2163. Minimum Difference in Sums After Removal of Elements
    Date: 18th July, 2025
*/ 
class Solution {
    public long minimumDifference(int[] nums) {

        int l = nums.length;
        int n = l/3;

        long[] leftsum = new long[l]; // stores the minsum of n ele from left till ith idx
        long[] rightsum = new long[l]; // stores the maxsum of n ele from right till ith idx
        PriorityQueue<Integer> maxh = new PriorityQueue<>((a, b) -> b - a);
        long ls = 0;
        for(int i=0; i<l-n; i++){// 0tol-n because atleast n ele should be there in right
            maxh.add(nums[i]);
            ls+= nums[i];
            if(maxh.size() >n){
                ls-=maxh.remove();  // we have to store te sum of only n ele 
            }
            leftsum[i] = ls;
        }
        PriorityQueue<Integer> minh = new PriorityQueue<>();
        long rs = 0;
        for(int i=l-1; i>=n; i--){  //atleast n ele should be there in left from l-1 to n 
            minh.add(nums[i]);
            rs+= nums[i];

            if(minh.size() >n){
                rs-=minh.remove();  // we have to store te sum of only n ele
            }
            rightsum[i] = rs;
        }

        long mindiff =Long.MAX_VALUE;
        for(int i = n-1; i<(l-n); i++){   // check with the ex of 2nd testcase 
            mindiff = Math.min(mindiff, (leftsum[i]-rightsum[i+1]));
        }
        return mindiff;
    }
}
