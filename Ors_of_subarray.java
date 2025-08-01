/*  898. Bitwise ORs of Subarrays
    Date: 26th July, 2025, marked=Medium
*/
// ----------------->> Method 1 <<<--------------------------------------->>
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(i, new HashSet<>());
        }

        HashSet<Integer> hsor = new HashSet<>();

        for(int i=0; i<n; i++){
            if( i==0){
                hm.get(i).add(arr[i]);
                hsor.add(arr[i]);
            }else{

                int previd = i-1;
                for(int ele: hm.get(previd)){
                    int or_val = arr[i]|ele;
                    hsor.add(or_val);
                    hm.get(i).add(or_val);
                }

                // at last add the ele on that idx as single len subarr
                hsor.add(arr[i]);
                hm.get(i).add(arr[i]);
            }
        }

        return hsor.size();
    }
}

//--------------------------------------->>> Method 2 The above is almost simmilar to this ------->>
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> prev = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        for(int i=0; i<n; i++){

            for(int ele: prev){
                curr.add(arr[i] | ele);
                ans.add(arr[i] | ele);
            }
            curr.add(arr[i]);
            ans.add(arr[i]);

            prev = curr;
            curr = new HashSet<>();

        }

        return ans.size();
    }
}