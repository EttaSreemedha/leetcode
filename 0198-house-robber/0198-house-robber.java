class Solution {
    public int rob(int[] nums) {
        int l=nums.length;
        if(n==1) return return nums[0];
        int []dp=new int[l];
        dp[0]=nums[0]; 
        dp[1]=Math.amx(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],dp[i-2]);
        }
        return dp[l-1];
    }
}