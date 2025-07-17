class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int max =2;
        for(int i=0; i<n; i++){
            for(int j =i+1; j<n; j++){
                int cnt =2;
                int no = (nums[i]+nums[j])%k;
                int l = j+1;
                int prev = j;

                while(l<n){

                    if((nums[l]+nums[prev])%k == no){
                        cnt++;
                        prev = l;
                    }
                    l++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}