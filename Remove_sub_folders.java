/*1233. Remove Sub-Folders from the Filesystem
Date : 19-07-2025
*/

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        ArrayList<String> al = new ArrayList<>();
        Arrays.sort(folder);

        for(int i=0; i<n; i++){
            String curr = folder[i];
            if(al.size() == 0){
                al.add(curr);
            }else{

                String prev = al.get(al.size()-1);
                if(curr.startsWith(prev) && prev.length()<curr.length() && curr.charAt(prev.length()) == '/'){ // here the condition is given to verify example 3 dry run on it
                    continue;
                }
                //else
                al.add(curr);
            }
        }
        return al;
    }
}
