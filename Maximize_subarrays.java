/*  3480. Maximize Subarrays After Removing One Conflicting Pair --- refer Video Of codestorywithMIK for best explaination
    Date: 26th July, 2025, marked=Hard
*/

class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long ans =0;   // total no of valid subarr possible

        // we will need this for storing the conflicting nos for each individual no
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0; i<=n; i++){
            al.add(new ArrayList<>());
        }
        
        // storing the conflicting nos
        for(int[] ar: conflictingPairs){
            int a = Math.max(ar[0], ar[1]);
            int b = Math.min(ar[0], ar[1]);

            al.get(a).add(b);
        }

        // these we are tracking bcz if maxconflictingno is removed then the no of subarr will increase in the ans i.e maxconf-2ndconfno 
        int maxconflictingno =0;
        int secndmaxconflictingno =0;

        // extra[i] = number of extra subarrays by removing the conflicting point i
        long[] extra = new long[n+1];

        for(int no =1; no<=n; no++){ //visiting each point and treating them as subarray ending at this point
            //total subarrays ending at this point 'end'
            for(int nos: al.get(no)){
                
                if(nos>= maxconflictingno){
                    secndmaxconflictingno = maxconflictingno;
                    maxconflictingno = nos;
                }
                else if(nos>secndmaxconflictingno){
                    secndmaxconflictingno = nos;
                }

            }
            // Count valid subarrays ending at 'end'
            ans += (no-maxconflictingno);

            // Add extra subarrays count
            extra[maxconflictingno] += (maxconflictingno-secndmaxconflictingno);   

        }
        // we will add the max extra no that we get after removing any no conflictingno
        long max = 0;
        for(long ele: extra){
            max = Math.max(max, ele);
        }

        return (ans+max);
    }
}