
// GIVING TLE 85/86
class Solution {
    public int numTilePossibilities(String tiles) {
        List<String> res=new ArrayList<>();
        char[] arr=tiles.toCharArray();
        Arrays.sort(arr);
        boolean[] vis=new boolean[arr.length];
        backtrack(arr,vis,res,new StringBuilder());
        return res.size();
    }
   /* public static void backtrack(char[] arr,List<String> res,boolean[] vis,StringBuilder temp){
        for(int i=0;i<arr.length;i++){
            if(vis[i]) continue;
            vis[i]=true;
            temp.append(arr[i]);
            if(!res.contains(temp.toString())) res.add(temp.toString());
            backtrack(arr,res,vis,temp);
            temp.deleteCharAt(temp.length()-1);
            vis[i]=false;
        }
    }*/
    static void backtrack(char[] arr, boolean[] visited,List<String> result,  StringBuilder path) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue; // skip duplicates

            visited[i] = true;
            path.append(arr[i]);

            result.add(path.toString()); // add current valid sequence
            backtrack(arr, visited, result,path); // recursive call

            path.deleteCharAt(path.length() - 1); // backtrack
            visited[i] = false;
        }
    }
}   