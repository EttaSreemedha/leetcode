class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=newArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,res,new ArrayList<>(),0);
        return res;
    }
    public void backtrack(int[] nums,List<List<Integer>> res,List<Integer> temp,int ind){
        if(ind==nums.length){
            if(!ans.contains(temp)){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(nums[ind]);
        backtrack(nums,res,temp,ind+1);
        temp.remove(temp.size()-1);
        backtrack(nums,res,temp,ind+1);
    }
}