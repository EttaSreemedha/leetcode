class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        if(k==0 || n==0) return res;
        int[] nums={1,2,3,4,5,6,7,8,9};
        backtrack(k,n,res,nums,new ArrayList<>(),0);
        return res;
    }
    public static void backtrack(int k, int t, List<List<Integer>> res, int[] nums, List<Integer> temp, int ind) {
    if (temp.size() > k || t < 0) return;
    if (temp.size() == k && t == 0) {
        res.add(new ArrayList<>(temp));
        return;
    }
    if (ind >= nums.length) return;

    temp.add(nums[ind]);
    backtrack(k, t - nums[ind], res, nums, temp, ind + 1);
    temp.remove(temp.size() - 1);

    backtrack(k, t, res, nums, temp, ind + 1);
}

   
}